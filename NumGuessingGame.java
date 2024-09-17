import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int maxAttempts = 10;
        int score = 0;
        int roundsWon = 0;

        while (true) {
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean won = false;

            System.out.println("Guess a number between " + min + " and " + max + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    won = true;
                    roundsWon++;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high. Try again!");
                } else {
                    System.out.println("Your guess is too low. Try again!");
                }
            }

            if (!won) {
                System.out.println("Sorry, you didn't guess the correct number in " + maxAttempts + " attempts. The correct answer was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your final score is " + roundsWon + " rounds won out of " + (roundsWon + (score / maxAttempts)) + " rounds played.");
                break;
            }

            score += attempts;
        }
    }
}