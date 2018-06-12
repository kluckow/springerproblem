package kluckow.org.springerproblem.view.components;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import kluckow.org.springerproblem.theme.Theme;

public class Knight extends ChessPiece {

	private Color color;
	public static final String FILENAME_PREFIX = "knight";
	private static final String COLOR_STR_DEFAULT = "black";

	public Knight() {
		this.setColor(COLOR_DEFAULT);
		this.setImage(new Image(FILENAME_PREFIX + "_" + COLOR_STR_DEFAULT + "." + IMG_EXTENSION_CHESSPIECE));
	}

	public Knight(Color color) {
		this.setColor(color);
		String colorStr = color == Theme.COLOR_BLACK ? "black" : "white";
		this.setImage(new Image("knight_" + colorStr + ".png"));
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
		String colorStr = color == Theme.COLOR_BLACK ? "black" : "white";
		this.setImage(new Image("knight_" + colorStr + ".png"));
	}

	public void invertColor() {
		this.color = this.color == Theme.COLOR_BLACK ? Theme.COLOR_WHITE : Theme.COLOR_BLACK;
		String colorStr = this.color == Theme.COLOR_BLACK ? "black" : "white";
		this.setImage(new Image("knight_" + colorStr + ".png"));
	}
}
