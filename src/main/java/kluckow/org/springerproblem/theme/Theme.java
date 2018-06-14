package kluckow.org.springerproblem.theme;

import javafx.scene.paint.Color;

/**
 * The Interface Theme.
 */
public class Theme {

	public interface Field {

		/** The Constant COLOR_WHITE. */
		public static final Color COLOR_WHITE = Color.NAVAJOWHITE;

		/** The Constant COLOR_BLACK. */
		public static final Color COLOR_BLACK = Color.LIGHTSALMON;
	}

	public interface ChessPiece {

		/** The Constant COLOR_DEFAULT. */
		public static final Color COLOR_DEFAULT = Theme.Field.COLOR_BLACK;
	}
}
