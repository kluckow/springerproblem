package kluckow.org.springerproblem.view.components;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import kluckow.org.springerproblem.theme.Theme;

/**
 * The Class ChessPiece.
 */
abstract class ChessPiece extends ImageView {

	/** The position. */
	private Position position;

	/** The Constant IMG_EXTENSION_CHESSPIECE. */
	protected static final String IMG_EXTENSION_CHESSPIECE = "png";

	/** The Constant COLOR_DEFAULT. */
	protected static final Color COLOR_DEFAULT = Theme.COLOR_BLACK;

	/**
	 * Clear image.
	 */
	public void clearImage() {
		this.setImage(null);
	}

	/**
	 * Checks for image.
	 *
	 * @return true, if successful
	 */
	public boolean hasImage() {
		return this.getImage() != null;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Position getPosition() {
		return this.position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
}
