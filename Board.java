import java.util.*;

public class Board
{
	private Position[][] positions;
	private final int length = 7;

	public Board() {
		this.positions 	= new Position[this.length][this.length];
	}

	public Board(Board board) {
		this.positions  = new Position[this.length][this.length];

		for(int i = 0; i < this.length; i++) {
			for(int j = 0; j < this.length; j++) {
				this.positions[i][j] = board.positions[i][j];
			}
		}

	}

	public Board(Position[][] positions) {
		this.positions  = new Position[this.length][this.length];

		for(int i = 0; i < this.length; i++) {
			for(int j = 0; i < this.length; i++) {
				this.positions[i][j] = positions[i][j];
			}
		}
	}

	public void addPosition(Position position) {
		this.positions[position.getX()][position.getY()] = position;
	}

	public int getMatrixLength() {
		return this.length;
	}

	public Position[][] getPositions() {
		return this.positions;
	}

	public boolean hasPlacement(int x, int y) {

		Position _position = this.positions[x][y];

		if(_position == null) {
			return false;
		}else {
			return _position.isPlaced();
		}

	}

	public String toString() {
		String _val = "";

		for(int y = 0; y < this.length ; y++) {
			for(int x = 0; x < this.length; x++) {
				Position _pos = this.positions[x][y];

				if(_pos == null || !_pos.isPlaced()) {
					_val += "x ";
					continue;
				}


				if(_pos.getIsOpponent()) {
					_val += "1 ";
				}else {
					_val += "0 ";
				}
			}

			_val += "\r\n";
		}

		return _val;
	}
}
