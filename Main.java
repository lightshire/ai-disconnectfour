import java.io.*;
import java.util.*;

public class Main
{
	static Scanner sc 			= new Scanner(System.in);
	static boolean isAI 		= false;
	static boolean isFirst 		= false;

	static Game game;

	public static void main(String [] args) {
		System.out.println("Initiate game..");

		bootGame();

	}

	public static void enterPlayer() {
		System.out.println("Enter the column of your move: ");
		int column = -1;

		try {
			column = Integer.parseInt(sc.nextLine());
		}catch(Exception exs) {
			System.out.println("you have entered an invalid number please try again: ");
			enterPlayer();
			return;
		}

		if(column == -1) {
			System.out.println("you have entered an invalid number please try again: ");
			enterPlayer();
			return;
		}

		if(game.pushMyMove(column)) {
			System.out.println(game);
			System.out.println("AI Computing move..");
			bootAI();
		}else {
			System.out.println("Move is invalid please try again.");
			enterPlayer();
		}
	}

	public static void bootGame() {
		game = new Game();
		checkAI();
		checkPlayer();

		if(!isFirst) {
			bootAI();
		}else {
			enterPlayer();
		}
	}

	public static void bootAI() {
		game.aiMove();
		System.out.println(game);

		enterPlayer();


	}

	public static void checkAI() {
		String aiAnswer = "";

		System.out.println("Uses AI (y/n): ");

		aiAnswer = sc.nextLine();

		if(aiAnswer.equals("y")) {
			isAI = true;
		}
	}

	public static void checkPlayer() {
		String answer = "";

		System.out.println("First Player (y/n): ");

		answer = sc.nextLine();

		if(answer.equals("y")) {
			isFirst = true;
		}

		game.setIsFirst(isFirst);

	}
}
