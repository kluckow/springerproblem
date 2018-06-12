package kluckow.org.springerproblem.handler;

import java.util.ArrayList;
import java.util.List;

import kluckow.org.springerproblem.view.components.Knight;
import kluckow.org.springerproblem.view.components.Position;

/**
 * The Class MovementHandler.
 *
 * @param <T> the generic type
 */
public class MovementHandler<T> {

	/** The chess piece. */
	private T chessPiece;

	/**
	 * Instantiates a new movement handler.
	 *
	 * @param chessPiece the chess piece
	 */
	public MovementHandler(T chessPiece) {
		this.setChessPiece(chessPiece);
	}

	/**
	 * Gets the possible target positions.
	 *
	 * @return the possible target positions
	 */
	public List<Position> getPossibleTargetPositions() {

		List<Position> possiblePositions = new ArrayList<>();
		if (this.chessPiece instanceof Knight) {
			int[][] knightMovesets = Moveset.Static.KNIGHT;
			for (int[] moveset : knightMovesets) {
				Knight knight = (Knight) this.chessPiece;
				if (this.validate(knight.getPosition(), moveset)) {
					Position possiblePosition = this.apply(knight.getPosition(), moveset);
					possiblePositions.add(possiblePosition);
				}
			}
		}
		return possiblePositions;
	}

	/**
	 * Apply.
	 *
	 * @param position the position
	 * @param moveset the moveset
	 * @return the position
	 */
	private Position apply(Position position, int[] moveset) {

		int newX = position.getX() + moveset[0];
		int newY = position.getY() + moveset[1];

		return new Position(newX, newY);
	}

	/**
	 * Validate.
	 *
	 * @param position the position
	 * @param moveset the moveset
	 * @return true, if successful
	 */
	private boolean validate(Position position, int[] moveset) {

		int newX = position.getX() + moveset[0];
		int newY = position.getY() + moveset[1];
		boolean isValidX = newX >= 0 && newX <= 7;
		boolean isValidY = newY >= 0 && newY <= 7;

		return isValidX && isValidY;
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
