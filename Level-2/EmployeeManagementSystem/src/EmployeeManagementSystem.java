
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");

            if (!sc.hasNextInt()) {
                System.out.println("Error: Enter a valid number!");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    updateEmployee();
                    break;

                case 4:
                    deleteEmployee();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addEmployee() {

        int id;

        while (true) {

            System.out.print("Enter ID: ");

            if (!sc.hasNextInt()) {
                System.out.println("Error: ID must be numeric!");
                sc.nextLine();
                continue;
            }

            id = sc.nextInt();
            sc.nextLine();

            if (id <= 0) {
                System.out.println("Error: ID must be greater than 0!");
                continue;
            }

            boolean exists = false;

            for (Employee emp : employees) {
                if (emp.getId() == id) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                System.out.println("Error: Employee ID already exists!");
                continue;
            }

            break;
        }

        String name;

        while (true) {

            System.out.print("Enter Name: ");
            name = sc.nextLine().trim();

            if (name.matches("[a-zA-Z ]+") && name.length() >= 2) {
                break;
            }

            System.out.println("Error: Name should contain only letters!");
        }

        double salary;

        while (true) {

            System.out.print("Enter Salary: ");

            if (!sc.hasNextDouble()) {
                System.out.println("Error: Salary must be numeric!");
                sc.nextLine();
                continue;
            }

            salary = sc.nextDouble();

            if (salary < 0) {
                System.out.println("Error: Salary cannot be negative!");
                continue;
            }

            break;
        }

        employees.add(new Employee(id, name, salary));
        System.out.println("Employee Added Successfully!");
    }

    static void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No Employees Found.");
            return;
        }

        System.out.println("\n===== Employee List =====");

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    static void updateEmployee() {

        System.out.print("Enter Employee ID: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID!");
            sc.nextLine();
            return;
        }

        int id = sc.nextInt();
        sc.nextLine();

        for (Employee emp : employees) {

            if (emp.getId() == id) {

                String newName;

                while (true) {

                    System.out.print("Enter New Name: ");
                    newName = sc.nextLine();

                    if (newName.matches("[a-zA-Z ]+")) {
                        break;
                    }

                    System.out.println("Error: Name can contain only letters!");
                }

                double newSalary;

                while (true) {

                    System.out.print("Enter New Salary: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Error: Salary must be numeric!");
                        sc.nextLine();
                        continue;
                    }

                    newSalary = sc.nextDouble();

                    if (newSalary < 0) {
                        System.out.println("Error: Salary cannot be negative!");
                        continue;
                    }

                    break;
                }

                emp.setName(newName);
                emp.setSalary(newSalary);

                System.out.println("Employee Updated Successfully!");
                return;
            }
        }

        System.out.println("Employee Not Found!");
    }

    static void deleteEmployee() {

        System.out.print("Enter Employee ID: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID!");
            sc.nextLine();
            return;
        }

        int id = sc.nextInt();

        Employee employeeToDelete = null;

        for (Employee emp : employees) {

            if (emp.getId() == id) {
                employeeToDelete = emp;
                break;
            }
        }

        if (employeeToDelete != null) {
            employees.remove(employeeToDelete);
            System.out.println("Employee Deleted Successfully!");
        } else {
            System.out.println("Employee Not Found!");
        }
    }
}
