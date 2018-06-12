package kluckow.org.springerproblem.view.components;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import kluckow.org.springerproblem.theme.Theme;

abstract class ChessPiece extends ImageView {

	private Position position;
	protected static final String IMG_EXTENSION_CHESSPIECE = "png";
	protected static final Color COLOR_DEFAULT = Theme.COLOR_BLACK;

	public void clearImage() {
		this.setImage(null);
	}

	public boolean hasImage() {
		return this.getImage() != null;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
