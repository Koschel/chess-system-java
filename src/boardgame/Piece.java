package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	//s� pode ser usado pela propria classe classe 
	protected Board getBoard() {
		return board;
	}

	
	
}
