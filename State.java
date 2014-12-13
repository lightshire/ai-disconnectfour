import java.util.*;
import java.io.*;

public class State
{
	private Board board;
	private int weight;

	private int alpha;
	private int beta;
	private int mainMove;

	private boolean isOpponent;


	public  State() {
		this.board  = new Board();
		this.weight = 0;
		this.isOpponent = false;

		alpha	= -100000;
		beta 	= 100000;

	}

	public State(Board board) {
		this.board 	= new Board(board);
		this.weight = 0;
		this.isOpponent = false;

		alpha	= -100000;
		beta 	= 100000;

		this.computeWeight();
	}

	public State(State state) {
		this.board 	= new Board(state.board);
		this.weight = state.weight;
		this.isOpponent = state.isOpponent;

		alpha 	= state.alpha;
		beta 	= state.beta;
		this.mainMove = state.mainMove;

		this.computeWeight();
	}

	public boolean pushMove(int column, boolean isOpponent) {

		for(int y= this.board.getMatrixLength() - 1; y >= 0; y--) {
			if(!this.board.hasPlacement(column, y)) {
				this.board.addPosition(new Position(column, y, isOpponent));

				this.mainMove = column;

				computeWeight();
				return true;
			}
		}

		return false;
	}

	public int getWeight() {
		return this.weight;
	}

	public boolean isOpponent() {
		return this.isOpponent;
	}

	public void setIsOpponent(boolean isOpponent) {
		this.isOpponent = isOpponent;
	}

	public int getAlpha() {
		return alpha;
	}

	public int getBeta() {
		return beta;
	}

	public int getMainMove() {
		return this.mainMove;
	}

	public void setAplha(int alpha) {
		this.alpha = alpha;
	}

	public void setBeta(int beta) {
		this.beta = beta;
	}

	public ArrayList<State> getChildren() {
		Board tempBoard = this.board;
		ArrayList<State> states = new ArrayList<State>();

		for(int x = 0; x < this.board.getMatrixLength(); x++) {
			State child = new State(tempBoard);
			child.setIsOpponent(!this.isOpponent);

			if(child.pushMove(x, !this.isOpponent)) {
				states.add(child);
			}

		}

		return states;
	}

	public boolean isGameEnding() {
		boolean isFull = this.isFull();

		return isFull;
	}

	public boolean isFull() {
		int placedTiles = 0;
		int matrixLength = this.board.getMatrixLength();
		Position[][] positions = this.board.getPositions();

		for(int y = 0; y < matrixLength; y++) {
			for(int x = 0; x < matrixLength; x++) {

				Position _pos = positions[x][y];

				if(_pos != null && _pos.isPlaced()) {
					placedTiles++;
				}
			}
		}

		return placedTiles == (matrixLength * matrixLength);
	}

	public boolean someoneWon() {
		boolean someoneWon = false;

		return someoneWon;
	}

	public boolean hasFailingPosition() {
		boolean failed = false;

		return failed;
	}

	public int computeWeight() {
		int _weight = -1;
		int max 	= this.board.getMatrixLength();

		Position[][] positions = this.board.getPositions();

		for(int y = 0; y < this.board.getMatrixLength(); y++) {
			for(int x = 0; x < this.board.getMatrixLength(); x++) {
				Position _pos 		= positions[x][y];
				Position _second 	= null;


				if(_pos == null) {
					continue;
				}

				_weight += _pos.getIsOpponent() ? 1 : 0;

				//check left
				if(x != 0) {
					_second = positions[x - 1][y];
					_weight += _second != null ? _second.getWeight() : 0;

					if(_second != null && _second.getIsOpponent() && _pos.getIsOpponent()) {
						_weight += 1;
					}
				}

				//check left-top
				if(x != 0 && y != 0) {
					_second = positions[x - 1][y - 1];
					_weight += _second != null ? _second.getWeight() : 0;

					if(_second != null && _second.getIsOpponent() && _pos.getIsOpponent()) {
						_weight += 1;

					}
				}

				//check top
				if(y != 0) {
					_second = positions[x][y - 1];
					_weight += _second != null ? _second.getWeight() : 0;

					if(_second != null && _second.getIsOpponent() && _pos.getIsOpponent()) {
						_weight += 1;

					}

				}

				//check top-right
				if(y != 0 && x < max - 1) {
					_second = positions[x + 1][y - 1];
					_weight += _second != null ? _second.getWeight() : 0;

					if(_second != null && _second.getIsOpponent() && _pos.getIsOpponent()) {
						_weight += 1;

					}

				}

				//check right
				if(x < max - 1) {
					_second = positions[x + 1][y];
					_weight += _second != null ? _second.getWeight() : 0;

					if(_second != null && _second.getIsOpponent() && _pos.getIsOpponent()) {
						_weight += 1;

					}

				}

				//check bottom-right
				if(x < max - 1 && y < max - 1) {
					_second = positions[x + 1][y + 1];
					_weight += _second != null ? _second.getWeight() : 0;

					if(_second != null && _second.getIsOpponent() && _pos.getIsOpponent()) {
						_weight += 1;

					}

				}

				//check bottom
				if(y < max - 1) {
					_second = positions[x][y + 1];
					_weight += _second != null ? _second.getWeight() : 0;

					if(_second != null && _second.getIsOpponent() && _pos.getIsOpponent()) {
						_weight += 1;

					}

				}

				//check bottom-left
				if(y < max - 1 && x != 0) {
					_second = positions[x - 1][y + 1];
					_weight += _second != null ? _second.getWeight() : 0;

					if(_second != null && _second.getIsOpponent() && _pos.getIsOpponent()) {
						_weight += 1;

					}
				}

			}
		}

		this.weight = _weight;
		return this.weight;

	}

	public String toString() {
		return this.board.toString();
	}
}
