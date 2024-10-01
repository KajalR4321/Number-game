import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        int totalScore = 0;
        int round = 1;

        while (playAgain) {
            System.out.println("Round " + round);
            int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            int maxAttempts = 7; // Limit the number of attempts to 7

            System.out.println("I have chosen a number between 1 and 100. Try to guess it!");
            
            // Game loop for guessing
            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    hasGuessedCorrectly = true;
                    totalScore += (maxAttempts - attempts) + 1; // Score based on remaining attempts
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts! The correct number was: " + randomNumber);
            }
            
            System.out.println("Your score for this round: " + ((maxAttempts - attempts) + 1));
            System.out.println("Total score: " + totalScore);
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
            round++;
        }
        
        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
