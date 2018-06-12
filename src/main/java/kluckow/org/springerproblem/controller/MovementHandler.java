package kluckow.org.springerproblem.controller;

import java.util.ArrayList;
import java.util.List;

import kluckow.org.springerproblem.view.nodes.Knight;
import kluckow.org.springerproblem.view.nodes.Position;

public class MovementHandler<T> {

	private T chessPiece;

	public MovementHandler(T chessPiece) {
		this.setChessPiece(chessPiece);
	}

	public T getChessPiece() {
		return this.chessPiece;
	}

	public void setChessPiece(T chessPiece) {
		this.chessPiece = chessPiece;
	}

	public List<Position> getPossibleTargetPositions() {

		List<Position> possiblePositions = new ArrayList<>();
		if (this.chessPiece instanceof Knight) {
			int[][] knightMovesets = Moveset.Static.KNIGHT;
			for (int[] moveset : knightMovesets) {
				Knight knight = (Knight) this.chessPiece;
				if (this.validate(knight.getPosition(), moveset)) {
					Position possiblePosition = this.apply(knight.getPosition(), moveset);
					possiblePositions.add(possiblePosition);
				}
			}
		}
		return possiblePositions;
	}

	private Position apply(Position position, int[] moveset) {

		int newX = position.getX() + moveset[0];
		int newY = position.getY() + moveset[1];

		return new Position(newX, newY);
	}

	private boolean validate(Position position, int[] moveset) {

		int newX = position.getX() + moveset[0];
		int newY = position.getY() + moveset[1];
		boolean isValidX = newX >= 0 && newX <= 7;
		boolean isValidY = newY >= 0 && newY <= 7;

		return isValidX && isValidY;
	}

}
