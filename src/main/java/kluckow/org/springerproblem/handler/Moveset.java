package kluckow.org.springerproblem.handler;

/**
 * The Class Moveset.
 */
public class Moveset {

	/**
	 * The Interface Static.
	 */
	public interface Static {

		/** The Constant KNIGHT. */
		// right-up, right-down, down-right, down-left, left-down, left-up, up-left, up-right
		public static final int[][] KNIGHT = {
			{2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}
		};
	}

}
