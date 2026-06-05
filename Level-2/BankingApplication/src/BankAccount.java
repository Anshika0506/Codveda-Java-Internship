public class BankAccount {

    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be greater than 0.");
            return;
        }

        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be greater than 0.");
            return;
        }

        if (amount > balance) {
            System.out.println("Error: Insufficient Funds!");
            return;
        }

        balance -= amount;
        System.out.println("₹" + amount + " withdrawn successfully.");
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void displayAccountDetails() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
    }
}