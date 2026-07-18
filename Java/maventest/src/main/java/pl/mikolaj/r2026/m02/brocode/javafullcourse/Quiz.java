package pl.mikolaj.r2026.m02.brocode.javafullcourse;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		String[] questions = 	{"What is the main function of a router?",
				"Which part of a computer is considered the brain?",};

		String[][] options = 	{
				{"1. Storing files", "2. Encrypting data", "3. Directing internet traffic"},
				{"1. CPU", "2. HDD", "3. RAM", "4. GPU"}
		};

		int[] answears = {3, 1};
		int score = 0;
		int guess;

		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < questions.length; i++) {
			System.out.println(questions[i]);
			System.out.println();
			for (String option : options[i]) {
				System.out.println(option);
			}
			System.out.print("Enter your guess: ");
			guess = scanner.nextInt();

			if (guess == answears[i]) {
				score++;
				System.out.println("CORRECT!");
			} else {
				System.out.println("WRONG!");
			}
		}
		scanner.close();

		System.out.println("Your score: " + score + " out of " + answears.length);
	}
}
