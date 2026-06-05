import java.util.Scanner;

class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

public class BasicCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("\nChoose Operation:");
        System.out.println("+  Addition");
        System.out.println("-  Subtraction");
        System.out.println("*  Multiplication");
        System.out.println("/  Division");

        System.out.print("Enter operation: ");
        char op = sc.next().charAt(0);

        try {
            double result;

            switch (op) {
                case '+':
                    result = calc.add(num1, num2);
                    System.out.println("Result = " + result);
                    break;

                case '-':
                    result = calc.subtract(num1, num2);
                    System.out.println("Result = " + result);
                    break;

                case '*':
                    result = calc.multiply(num1, num2);
                    System.out.println("Result = " + result);
                    break;

                case '/':
                    result = calc.divide(num1, num2);
                    System.out.println("Result = " + result);
                    break;

                default:
                    System.out.println("Invalid operation selected.");
            }

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}