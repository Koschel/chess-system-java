package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	//só pode ser usado psela classe boardgame
	protected Board getBoard() {
		return board;
	}

	
	
}
