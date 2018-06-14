package kluckow.org.springerproblem.view.components;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import kluckow.org.springerproblem.theme.Theme;

/**
 * The Class Chessboard.
 *
 * @param <T> the generic type
 */
public class Chessboard<T> extends GridPane {

	/** The Constant SIZE_CHESSBOARD. */
	private static final int SIZE_CHESSBOARD = 8;

	/** The fields. */
	private Field[][] fields = new Field[SIZE_CHESSBOARD][SIZE_CHESSBOARD];

	/**
	 * Instantiates a new chessboard.
	 */
	public Chessboard() {
		this.setupUI();
	}

	/**
	 * Setup UI.
	 */
	private void setupUI() {

		this.setAlignment(Pos.BASELINE_CENTER);

		Color color = Theme.Field.COLOR_WHITE;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Field<Knight> field = new Field<>(this, row, col, color);
				this.getFields()[col][row] = field;
				color = this.toggleColor(color);
			}
			color = this.toggleColor(color);
		}
	}

	/**
	 * Toggle color.
	 *
	 * @param color the color
	 * @return the color
	 */
	private Color toggleColor(Color color) {

		return Theme.Field.COLOR_BLACK == color ? Theme.Field.COLOR_WHITE : Theme.Field.COLOR_BLACK;
	}

	/**
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	public Field[][] getFields() {
		return this.fields;
	}

	/**
	 * Sets the fields.
	 *
	 * @param fields the new fields
	 */
	public void setFields(Field[][] fields) {
		this.fields = fields;
	}

	/**
	 * Clear.
	 */
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

	/**
	 * Clear.
	 *
	 * @param <T> the generic type
	 * @param exception the exception
	 */
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
