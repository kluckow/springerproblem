package kluckow.org.springerproblem.view.nodes;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import kluckow.org.springerproblem.theme.Theme;

public class Chessboard<T> extends GridPane implements Theme {

	private static final int SIZE_CHESSBOARD = 8;
	private Field[][] fields = new Field[SIZE_CHESSBOARD][SIZE_CHESSBOARD];

	public Chessboard() {
		this.setupUI();
	}

	private void setupUI() {

		this.setAlignment(Pos.BASELINE_CENTER);

		Color color = COLOR_WHITE;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Field<Knight> field = new Field<>(this, row, col, color);
				this.getFields()[col][row] = field;
				color = this.toggleColor(color);
			}
			color = this.toggleColor(color);
		}
	}

	private Color toggleColor(Color color) {

		return COLOR_BLACK == color ? COLOR_WHITE : COLOR_BLACK;
	}

	public Field[][] getFields() {
		return this.fields;
	}

	public void setFields(Field[][] fields) {
		this.fields = fields;
	}

	public void clear() {

		// iterate over fields
		for (int row = 0; row < SIZE_CHESSBOARD; row++) {
			for (int col = 0; col < SIZE_CHESSBOARD; col++) {
				Field<?> field = this.fields[col][row];
				field.getChildren().forEach(e -> {
					// since imageview exists once an image has been placed, do additional null check on image
					if (e instanceof ImageView && ((ImageView) e).getImage() != null) {
						System.out.println("Found a field with ImageView, it is now cleared!");
						((ImageView) e).setImage(null);
					}
				});
			}
		}
	}

	public <T> void clear(T exception) {

		// iterate over fields
		for (int row = 0; row < SIZE_CHESSBOARD; row++) {
			for (int col = 0; col < SIZE_CHESSBOARD; col++) {
				Field<?> field = this.fields[col][row];
				field.getChildren().forEach(e -> {
					// since imageview exists once an image has been placed, do additional null check on image
					// additionally exclude exception peice
					if (e instanceof ImageView && ((ImageView) e).getImage() != null && (ChessPiece) e != exception) {
						System.out.println("Found a field with ImageView, it is now cleared!");
						((ImageView) e).setImage(null);
					}
				});
			}
		}
	}

}
