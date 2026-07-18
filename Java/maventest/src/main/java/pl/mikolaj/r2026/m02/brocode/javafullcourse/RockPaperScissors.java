package pl.mikolaj.r2026.m02.brocode.javafullcourse;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	private static final String[] moves = {"rock", "paper", "scissors"};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String playerMove = getPlayerMove(scanner);
			String computerMove = getComputerMove();
			System.out.println("Computer choice: " + computerMove);

			if (playerMove.equals(computerMove)) {
				System.out.println("It's a draw!");
			} else if (
						(playerMove.equals("rock") && (computerMove.equals("scissors"))) ||
						(playerMove.equals("paper") && (computerMove.equals("rock"))) ||
						(playerMove.equals("scissors") && (computerMove.equals("paper")))
			) {
				System.out.println("You win!");
			} else {
				System.out.println("Computer wins!");
			}

			System.out.print("Play again yes/no: ");
			String playAgain = scanner.nextLine().toLowerCase();
			if (!"yes".equals(playAgain)){
				break;
			}
		}
		scanner.close();
	}

	private static String getComputerMove() {
		Random rand = new Random();
		int move = rand.nextInt(3);
		return moves[move];
	}

	private static String getPlayerMove(Scanner scanner) {
		String playerMove;

		while (true) {
			System.out.print("Enter your move (rock, paper, scissors): ");
			playerMove = scanner.nextLine();
			if (Arrays.asList(moves).contains(playerMove)) {
				break;
			} else {
				System.out.println("Incorrect move. Try again");
			}
		}
		return playerMove;
	}
}
