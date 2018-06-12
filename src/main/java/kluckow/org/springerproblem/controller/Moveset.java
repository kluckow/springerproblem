package kluckow.org.springerproblem.controller;

public class Moveset {

	public interface Static {

		// right-up, right-down, down-right, down-left, left-down, left-up, up-left, up-right
		public static final int[][] KNIGHT = {
			{2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}
		};
	}

}
