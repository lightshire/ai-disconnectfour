import java.util.*;
import java.io.*;

public class Game
{
	private List<State> states;
	private State current;

	private boolean isFirst;

	public Game() {
		this.states 	= new ArrayList<State>();
		this.current 	= new State();
		this.isFirst 	= false;
	}

	public void setIsFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public boolean pushOpponentMove(int row) {
		return this.current.pushMove(row, false);
	}

	public boolean pushMyMove(int row) {
		return this.current.pushMove(row, true);
	}

	public State aiMove() {

		if(current.isGameEnding()) {
			return current;
		}

		State state = Intelligence.move(current, Intelligence.DEPTH);
		this.pushOpponentMove(state.getMainMove());

		return state;
	}

	public State getCurrentState() {
		return this.current;
	}

	public String toString() {
		return this.current.toString();
	}

}
