package GuessNumber;

import java.util.Random;
import java.util.Scanner;

public class guessNumberHigher_Lower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // The upper bound for the random number
        int maxRange = 100;
        int numberToGuess = random.nextInt(maxRange) + 1;
        int numberOfAttempts = 0;

        // Maximum number of attempts allowed
        int maxAttempts = 10;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Guessing number game.");
        System.out.println("I have randomly selected a number between 1 and " + maxRange);
        System.out.println("You have only " + maxAttempts + " attempts to guess the number.");

        while (numberOfAttempts < maxAttempts && !hasGuessedCorrectly) {
            System.out.print("Enter the guessed number : ");
            int userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess == numberToGuess) {
                hasGuessedCorrectly = true;
                System.out.println(
                        "Surprise! You guessed the correct number in " + numberOfAttempts + " attempts.");
            } else if (userGuess < numberToGuess) {
                System.out.println("No...it's low. Try again.");
            } else {
                System.out.println("No...it's high. Try again.");
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry! You have no attempts left. The number was: " + numberToGuess);
        }

        scanner.close();
    }
}
