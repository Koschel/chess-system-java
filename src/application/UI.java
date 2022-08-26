package application;

import chess.ChessPiece;

public class UI {
	public static void printBoard(ChessPiece[][] pieces) {
		//cria a tabuleiro
		for(int i=0; i<pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for(int j=0; j<pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.println("  A B C D E F G H");
	}
	
	private static void printPiece(ChessPiece piece) {
		//caso não tenha nada na possição deve imprimir -
		if(piece == null) {
			System.out.print("-");
		}
		//preenche com a peça
		else{
			System.out.print(piece);
		}
		//espaço para separar as peças do tabuleiro
		System.out.print(" ");
	}
}
