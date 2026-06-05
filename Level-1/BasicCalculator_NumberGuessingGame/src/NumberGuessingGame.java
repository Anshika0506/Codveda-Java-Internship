import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int secretNumber = random.nextInt(100) + 1; // 1-100
        int maxAttempts = 5;
        int attempts = 0;

        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have " + maxAttempts + " attempts.\n");

        while (attempts < maxAttempts) {

            System.out.print("Enter your guess: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            int guess = sc.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the number.");
                System.out.println("Attempts used: " + attempts);
                break;
            } else if (guess > secretNumber) {
                System.out.println("Too High!");
            } else {
                System.out.println("Too Low!");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (attempts == maxAttempts) {
            System.out.println("\nGame Over!");
            System.out.println("The correct number was: " + secretNumber);
        }

        sc.close();
    }
}