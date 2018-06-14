package kluckow.org.springerproblem.view.components;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The Class Field.
 *
 * @param <T> the generic type
 */
public class Field<T> extends StackPane {

	/** The Constant FIELD_SIZE. */
	private static final int FIELD_SIZE = 70;

	/** The Constant PADDING. */
	public static final Insets PADDING = new Insets(5);

	/** The row. */
	private int row;

	/** The col. */
	private int col;

	/** The color. */
	private Color color;

	/** The chess piece. */
	private T chessPiece;


	/**
	 * Instantiates a new field.
	 *
	 * @param parent the parent
	 * @param row the row
	 * @param col the col
	 * @param color the color
	 */
	public Field(Chessboard<?> parent, int row, int col, Color color) {

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

	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * Sets the row.
	 *
	 * @param row the new row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Gets the col.
	 *
	 * @return the col
	 */
	public int getCol() {
		return this.col;
	}

	/**
	 * Sets the col.
	 *
	 * @param col the new col
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Gets the chess piece.
	 *
	 * @return the chess piece
	 */
	public T getChessPiece() {
		return this.chessPiece;
	}

	/**
	 * Sets the chess piece.
	 *
	 * @param chessPiece the new chess piece
	 */
	public void setChessPiece(T chessPiece) {
		this.chessPiece = chessPiece;
	}

}
