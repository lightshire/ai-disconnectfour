import java.util.*;

public class Position
{
	private int x;
	private int y;
	private boolean isOpponent;
	private boolean isPlaced;

	public  Position() {
		this.x = -1;
		this.y = -1;
		this.isOpponent = false;
		this.isPlaced 	= false;
	}

	public  Position(int x, int y, boolean isOpponent) {
		this.x = x;
		this.y = y;
		this.isOpponent = isOpponent;
		this.isPlaced 	= true;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getWeight() {
		if(this.isOpponent) {
			return 1;
		}

		return 0;
	}

	public boolean getIsOpponent() {
		return this.isOpponent;
	}

	public boolean isPlaced() {
		// return this.x == x && this.y == y;
		return this.isPlaced;
	}

	public boolean isTheSame(Position pos) {
		return pos.isOpponent == this.isOpponent;
	}

	public String toString() {
		return "("+this.x+", "+this.y+") opponent: "+this.isOpponent;
	}

}
