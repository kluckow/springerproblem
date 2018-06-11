package kluckow.org.springerproblem.view;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import kluckow.org.springerproblem.theme.Theme;

public class Field extends StackPane implements Theme {

	private static final int FIELD_SIZE = 70;
	public static final Insets PADDING = new Insets(5);
	private int row;
	private int col;
	private Color color;

	public Field(Chessboard parent, int row, int col, Color color) {

		// background
		Rectangle rec = new Rectangle(FIELD_SIZE, FIELD_SIZE);
		rec.setFill(color);

        this.setRow(row);
        this.setCol(col);
        GridPane.setRowIndex(this, row);
        GridPane.setColumnIndex(this, col);
        this.getChildren().addAll(rec);
        parent.getChildren().addAll(this);
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return this.col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
