package kluckow.org.springerproblem.view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import kluckow.org.springerproblem.theme.Theme;

public class Chessboard extends GridPane implements Theme {

	private static final int SIZE_CHESSBOARD = 8;
	private Field[][] fields = new Field[SIZE_CHESSBOARD][SIZE_CHESSBOARD];

	public Chessboard() {
		this.setupUI();
	}

	private void setupUI() {

		Color color = COLOR_WHITE;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Field field = new Field(this, row, col, color);
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

		for (int row = 0; row < SIZE_CHESSBOARD; row++) {
			for (int col = 0; col < SIZE_CHESSBOARD; col++) {
				Field[][] fields = Chessboard.this.getFields();
				Field field = fields[col][row];
				field.getChildren().forEach(e-> {

					if (e instanceof ImageView && ((ImageView) e).getImage() != null) {
						System.out.println("found a field with ImageView, it is now cleared!");
						((ImageView) e).setImage(null);
					}
				});
			}
		}
	}

}
