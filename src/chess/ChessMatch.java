package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

//Cora��o do board do chess
public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
		
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColunms()];
		for(int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColunms(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup(){
		//Teste de posi��es
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8,new King(board, Color.BLACK));
		placeNewPiece('e', 1,new King(board, Color.WHITE));
	}
}
