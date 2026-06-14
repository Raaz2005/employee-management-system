import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeApp {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Department");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateDepartment();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        Employee emp = new Employee(id, name, department);

        employees.add(emp);

        System.out.println("Employee Added Successfully!");
    }

    static void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No Employees Found.");
            return;
        }

        System.out.println("\nEmployee Records:");

        for (Employee emp : employees) {

            System.out.println(
                    "ID: " + emp.id +
                    " | Name: " + emp.name +
                    " | Department: " + emp.department);
        }
    }

    static void searchEmployee() {

        System.out.print("Enter Employee ID to Search: ");
        int searchId = sc.nextInt();

        for (Employee emp : employees) {

            if (emp.id == searchId) {

                System.out.println("Employee Found");
                System.out.println(
                        "ID: " + emp.id +
                        " | Name: " + emp.name +
                        " | Department: " + emp.department);

                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    static void updateDepartment() {

        System.out.print("Enter Employee ID: ");
        int searchId = sc.nextInt();
        sc.nextLine();

        for (Employee emp : employees) {

            if (emp.id == searchId) {

                System.out.print("Enter New Department: ");
                String newDepartment = sc.nextLine();

                emp.department = newDepartment;

                System.out.println("Department Updated Successfully!");
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }
}