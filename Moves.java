import java.util.*;
import java.io.*;

public class Moves
{

        public static int count = 4;

        public static Position leftWinningMove(int x, int y, Position node, Position[][] moves) {
            Position move = null;
            boolean isContiniuous   = true;
            int movesRemaining      = Moves.count;

            while(isContiniuous && movesRemaining >= 0) {
                x -= 1;
                if(Moves.isValid(x, y)) {
                    Position position = moves[x][y];

                    if(position == null) {
                        isContiniuous = false;
                        continue;
                    }

                    isContiniuous = position.isTheSame(node);
                }else {
                    isContiniuous = false;
                }

                movesRemaining -= 1;

            }

            if(isContiniuous) {
                move = node;
            }

            return move;
        }

        public static Position topLeftWinningMove(int x, int y, Position node, Position[][] moves) {
            Position move = null;
            boolean isContiniuous   = true;
            int movesRemaining      = Moves.count;

            while(isContiniuous && movesRemaining >= 0) {
                x -= 1;
                y -= 1;
                if(Moves.isValid(x, y)) {

                    Position position = moves[x][y];


                    if(position == null) {
                        isContiniuous = false;
                        continue;
                    }

                    isContiniuous = position.isTheSame(node);
                }else {
                    isContiniuous = false;
                }

                movesRemaining -= 1;

            }

            if(isContiniuous) {
                move = node;
            }

            return move;
        }

        public static Position topWinningMove(int x, int y, Position node, Position[][] moves) {
            Position move = null;
            boolean isContiniuous   = true;
            int movesRemaining      = Moves.count;

            while(isContiniuous && movesRemaining >= 0) {
                y -= 1;
                if(Moves.isValid(x, y)) {

                    Position position = moves[x][y];


                    if(position == null) {
                        isContiniuous = false;
                        continue;
                    }

                    isContiniuous = position.isTheSame(node);
                }else {
                    isContiniuous = false;
                }

                movesRemaining -= 1;

            }

            if(isContiniuous) {
                move = node;
            }

            return move;
        }

        public static Position topRightWinningMove(int x, int y, Position node, Position[][] moves) {
            Position move = null;
            boolean isContiniuous   = true;
            int movesRemaining      = Moves.count;

            while(isContiniuous && movesRemaining >= 0) {
                y -= 1;
                x += 1;
                if(Moves.isValid(x, y)) {

                    Position position = moves[x][y];

                    if(position == null) {
                        isContiniuous = false;
                        continue;
                    }

                    isContiniuous = position.isTheSame(node);
                }else {
                    isContiniuous = false;
                }

                movesRemaining -= 1;

            }

            if(isContiniuous) {
                move = node;
            }

            return move;
        }

        public static Position rightWinningMove(int x, int y, Position node, Position[][] moves) {
            Position move = null;
            boolean isContiniuous   = true;
            int movesRemaining      = Moves.count;

            while(isContiniuous && movesRemaining >= 0) {
                x += 1;
                if(Moves.isValid(x, y)) {

                    Position position = moves[x][y];

                    if(position == null) {
                        isContiniuous = false;
                        continue;
                    }

                    isContiniuous = position.isTheSame(node);
                }else {
                    isContiniuous = false;
                }

                movesRemaining -= 1;

            }

            if(isContiniuous) {
                move = node;
            }

            return move;
        }

        public static Position bottomRightWinningMove(int x, int y, Position node, Position[][] moves) {
            Position move = null;
            boolean isContiniuous   = true;
            int movesRemaining      = Moves.count;

            while(isContiniuous && movesRemaining >= 0) {
                x += 1;
                y += 1;
                if(Moves.isValid(x, y)) {

                    Position position = moves[x][y];

                    if(position == null) {
                        isContiniuous = false;
                        continue;
                    }

                    isContiniuous = position.isTheSame(node);
                }else {
                    isContiniuous = false;
                }

                movesRemaining -= 1;

            }

            if(isContiniuous) {
                move = node;
            }

            return move;
        }

        public static Position bottomWinningMove(int x, int y, Position node, Position[][] moves) {
            Position move = null;
            boolean isContiniuous   = true;
            int movesRemaining      = Moves.count;

            while(isContiniuous && movesRemaining >= 0) {
                y += 1;
                if(Moves.isValid(x, y)) {

                    Position position = moves[x][y];

                    if(position == null) {
                        isContiniuous = false;
                        continue;
                    }

                    isContiniuous = position.isTheSame(node);
                }else {
                    isContiniuous = false;
                }

                movesRemaining -= 1;

            }

            if(isContiniuous) {
                move = node;
            }

            return move;
        }

        public static Position bottomLeftWinningMove(int x, int y, Position node, Position[][] moves) {
            Position move = null;
            boolean isContiniuous   = true;
            int movesRemaining      = Moves.count;

            while(isContiniuous && movesRemaining >= 0) {
                y += 1;
                x -= 1;
                if(Moves.isValid(x, y)) {

                    Position position = moves[x][y];

                    if(position == null) {
                        isContiniuous = false;
                        continue;
                    }


                    isContiniuous = position.isTheSame(node);
                }else {
                    isContiniuous = false;
                }

                movesRemaining -= 1;

            }

            if(isContiniuous) {
                move = node;
            }

            return move;
        }

        public static boolean isValid(int x, int y) {
            return x >= 0 && x < 7 && y >= 0 && y < 7;
        }
}
