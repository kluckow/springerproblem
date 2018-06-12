package kluckow.org.springerproblem.view.components;

import java.util.List;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import kluckow.org.springerproblem.controller.MovementHandler;

public class Toolbar extends HBox {

	private Button btnStart;
	private Button btnPrevious;
	private Button btnNext;
	private Button btnRandomize;
	private Button btnClear;

	private Chessboard<?> board;
	private Knight knight;

	public Toolbar(Chessboard<?> board) {
		this.board = board;
		this.setupUI();
	}

	private void setupUI() {

		this.setupLayout();

		this.setupBtnStart();
		this.setupBtnPrevious();
		this.setupBtnNext();
		this.setupBtnRandomize();
		this.setupBtnClear();

		this.getChildren().addAll(this.btnStart, this.btnPrevious, this.btnNext, this.btnRandomize, this.btnClear);
	}

	private void setupLayout() {
		this.setAlignment(Pos.TOP_CENTER);
		this.setSpacing(10);
	}

	private void setupBtnClear() {

		// clear
		this.btnClear = new Button("Clear");
		this.btnClear.setMinWidth(100);
		this.btnClear.setDisable(true);
		this.btnClear.setOnAction(event -> {
			if (this.knight == null) {
				System.out.println("Not clearing anything, because board is already empty!");
				return;
			}
			this.board.clear();
			this.disablePlacementBtns();
		});
	}

	private void setupBtnRandomize() {

		// randomize
		this.btnRandomize = new Button("Randomize");
		this.btnRandomize.setMinWidth(100);
		this.btnRandomize.setDisable(true);
		this.btnRandomize.setOnAction(event -> {
			if (this.knight == null) {
				return;
			}
			this.board.clear(this.knight);
			Random rnd = new Random();
			Position newPosition = null;
			int x;
			int y;
			do {
				x = rnd.nextInt(8);
				y = rnd.nextInt(8);
			} while (x == this.knight.getPosition().getX() && y == this.knight.getPosition().getY());

			newPosition = new Position(x, y);
			this.knight.setPosition(newPosition);
			Field<?> rndField = this.board.getFields()[x][y];
			rndField.getChildren().addAll(this.knight);
			System.out.println("Setting knight on a random position: (" + x + "|" + y + ")");
			this.displayPossibleTargetPositions();
		});
	}

	private void setupBtnNext() {

		// next
		this.btnNext = new Button("Next");
		this.btnNext.setMinWidth(100);
		this.btnNext.setDisable(true);
		this.btnNext.setOnAction(event -> {
			if (this.knight == null) {
				return;
			}
			this.board.clear(this.knight);
			int x = this.knight.getPosition().getX();
			int y = this.knight.getPosition().getY();
			Position nextPosition = this.getNextPosition(x, y);
			this.knight.setPosition(nextPosition);
			Field<?> nextField = this.board.getFields()[nextPosition.getX()][nextPosition.getY()];
			nextField.getChildren().addAll(this.knight);
			this.displayPossibleTargetPositions();
		});
	}

	private void setupBtnPrevious() {

		// previous
		this.btnPrevious = new Button("Previous");
		this.btnPrevious.setMinWidth(100);
		this.btnPrevious.setDisable(true);
		this.btnPrevious.setOnAction(event -> {
			if (this.knight == null) {
				return;
			}
			this.board.clear(this.knight);
			int x = this.knight.getPosition().getX();
			int y = this.knight.getPosition().getY();
			Position previousPosition = this.getPreviousPosition(x, y);
			this.knight.setPosition(previousPosition);
			Field<?> previousField = this.board.getFields()[previousPosition.getX()][previousPosition.getY()];
			previousField.getChildren().addAll(this.knight);
			this.displayPossibleTargetPositions();
		});
	}

	private void setupBtnStart() {

		// start
		this.btnStart = new Button("Start");
		this.btnStart.setMinWidth(100);
		this.btnStart.setOnAction(event -> {
			this.board.clear();
			Position knightPos = new Position(0, 0);
			Field<?> startField = this.board.getFields()[knightPos.getX()][knightPos.getY()];
			this.knight = new Knight();
			this.knight.setPosition(knightPos);
			startField.getChildren().addAll(this.knight);
			this.displayPossibleTargetPositions();
			this.disablePlacementBtns();
		});
	}

	private void disablePlacementBtns() {

		// enable navigations once knight is placed on the board
		this.btnPrevious.setDisable(false);
		this.btnNext.setDisable(false);
		this.btnRandomize.setDisable(false);
		this.btnClear.setDisable(false);
	}

	private void displayPossibleTargetPositions() {

		// display possible positions for other knight in order to establish threat for both
		MovementHandler<Knight> movementResolver = new MovementHandler<>(this.knight);
		List<Position> possiblePositions = movementResolver.getPossibleTargetPositions();
		for (Position position : possiblePositions) {
			System.out.println(position.getX() + "|" + position.getY());
			// create knight with inverted color on each position
			Knight knight = new Knight(this.knight.getColor());
			knight.setPosition(position);
			knight.invertColor();
			this.board.getFields()[knight.getPosition().getX()][knight.getPosition().getY()].getChildren().addAll(knight);
		}
	}

	private Position getNextPosition(int x, int y) {

		if (x == 7 && y == 7) {
			x = 0;
			y = 0;
		} else if (x == 7 && y < 7) {
			y++;
			x = 0;
		} else if (x < 7) {
			x++;
		}
		return new Position(x, y);
	}

	private Position getPreviousPosition(int x, int y) {

		if (x == 0 && y == 0) {
			x = 7;
			y = 7;
		} else if (x == 0 && y > 0) {
			y--;
			x = 7;
		} else if (x > 0) {
			x--;
		}
		return new Position(x, y);
	}

	public Button getBtnStart() {
		return this.btnStart;
	}

	public void setBtnStart(Button btnStart) {
		this.btnStart = btnStart;
	}

	public Button getBtnPrevious() {
		return this.btnPrevious;
	}

	public void setBtnPrevious(Button btnPrevious) {
		this.btnPrevious = btnPrevious;
	}

	public Button getBtnNext() {
		return this.btnNext;
	}

	public void setBtnNext(Button btnNext) {
		this.btnNext = btnNext;
	}

	public Button getBtnRandomize() {
		return this.btnRandomize;
	}

	public void setBtnRandomize(Button btnRandomize) {
		this.btnRandomize = btnRandomize;
	}

}
