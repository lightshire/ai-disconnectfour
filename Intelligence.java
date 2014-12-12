import java.util.*;
import java.io.*;

public class Intelligence
{

	public static int DEPTH = 8;

	public static State move(State node, int depth) {
		node.computeWeight();
		State state = null;
		if(depth == 0 || node.isGameEnding()) {
			return node;
		}else {
			ArrayList<State> children = node.getChildren();

			//@TODO: check if node is game ending

			if(node.isOpponent()) {


				for(State child : children) {

					State _temp = Intelligence.move(child, depth - 1);
					_temp.computeWeight();

					if(state == null) {
						state  = new State(_temp);
					}else {
						if(state.getWeight() > _temp.getWeight()) {
							state = new State(_temp);
						}
					}
				}

			}else {

				for(State child : children) {

					State _temp = Intelligence.move(child, depth - 1);
					_temp.computeWeight();

					if(state == null) {
						state = new State(_temp);
					}else {
						if(state.getWeight() <= _temp.getWeight()) {
							state = new State(_temp);
						}
					}


				}

			}

		}


		return state;

	}

}
