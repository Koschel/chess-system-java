package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	//só pode ser usado pela propria classe classe 
	protected Board getBoard() {
		return board;
	}

	
	
}
