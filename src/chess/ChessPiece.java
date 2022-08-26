package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece{

	private Color color;

	public ChessPiece(Board board, Color color) {
		//passa o construtor para a puper classe "Piece"
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

}
