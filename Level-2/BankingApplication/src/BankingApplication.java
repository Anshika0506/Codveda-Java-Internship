import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account =
                new BankAccount(1001, "Anshika", 5000);

        while (true) {

            System.out.println("\n===== Banking System =====");
            System.out.println("1. Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Choose Option: ");

            if (!sc.hasNextInt()) {
                System.out.println("Error: Enter a valid number!");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    account.displayAccountDetails();
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid Amount!");
                        sc.nextLine();
                        break;
                    }

                    account.deposit(sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter Withdrawal Amount: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid Amount!");
                        sc.nextLine();
                        break;
                    }

                    account.withdraw(sc.nextDouble());
                    break;

                case 4:
                    account.checkBalance();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}