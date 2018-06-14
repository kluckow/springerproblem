package kluckow.org.springerproblem.view.components;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import kluckow.org.springerproblem.theme.Theme;

/**
 * The Class Knight.
 */
public class Knight extends ChessPiece {

	/** The color. */
	private Color color;

	/** The Constant FILENAME_PREFIX. */
	public static final String FILENAME_PREFIX = "knight";

	/** The Constant COLOR_STR_DEFAULT. */
	private static final String COLOR_STR_DEFAULT = "black";

	/**
	 * Instantiates a new knight.
	 */
	public Knight() {
		this.setColor(COLOR_DEFAULT);
		this.setImage(new Image(FILENAME_PREFIX + "_" + COLOR_STR_DEFAULT + "." + IMG_EXTENSION_CHESSPIECE));
	}

	/**
	 * Instantiates a new knight.
	 *
	 * @param color the color
	 */
	public Knight(Color color) {
		this.setColor(color);
		String colorStr = color == Theme.Field.COLOR_BLACK ? "black" : "white";
		this.setImage(new Image("knight_" + colorStr + ".png"));
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
		String colorStr = color == Theme.Field.COLOR_BLACK ? "black" : "white";
		this.setImage(new Image("knight_" + colorStr + ".png"));
	}

	/**
	 * Invert color.
	 */
	public void invertColor() {
		this.color = this.color == Theme.Field.COLOR_BLACK ? Theme.Field.COLOR_WHITE : Theme.Field.COLOR_BLACK;
		String colorStr = this.color == Theme.Field.COLOR_BLACK ? "black" : "white";
		this.setImage(new Image("knight_" + colorStr + ".png"));
	}
}
