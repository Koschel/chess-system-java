package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;

	public King(Board board, Color color,  ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;

	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColunms()];

		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getColunm());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getColunm());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColunm() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColunm() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// nw
		p.setValues(position.getRow() - 1, position.getColunm() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// ne
		p.setValues(position.getRow() - 1, position.getColunm() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// sw
		p.setValues(position.getRow() + 1, position.getColunm() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// se
		p.setValues(position.getRow() + 1, position.getColunm() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// #Specialmove castling

		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// #Specialmove castling kingSide rook
			Position posT1 = new Position(position.getRow(), position.getColunm() + 3);
			if (testRookCastling(posT1)) {
				Position p1 = new Position(position.getRow(), position.getColunm() + 1);
				Position p2 = new Position(position.getRow(), position.getColunm() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColunm() + 2] = true;
				}
			}

			// #Specialmove castling QueenSide rook
			Position posT2 = new Position(position.getRow(), position.getColunm() - 4);
			if (testRookCastling(posT2)) {
				Position p1 = new Position(position.getRow(), position.getColunm() - 1);
				Position p2 = new Position(position.getRow(), position.getColunm() - 2);
				Position p3 = new Position(position.getRow(), position.getColunm() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColunm() - 2] = true;
				}
			}
		}

		return mat;
	}

}
