import services.AdminService;
import services.StudentService;
import utils.CSVUtils;
import ui.AdminUI;
import ui.StaffUI;
import ui.StudentUI;
import models.Admin;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    // private static AdminService adminService = new AdminService();
    // private static StudentService studentService = new StudentService();

    public static void main(String[] args) {
        // Initialize admin if not already present
        initializeAdmin();
        System.out.println("------------------------------------------");
        System.out.println("-------Welcome To ClassRoom Management System App------");
        System.out.println("------------------------------------------");

        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("Select User Type:");
            System.out.println("1. Admin Login");
            System.out.println("2. Staff Login");
            System.out.println("3. Student Login");
            System.out.println("4. Quit");
            System.out.println("------------------------------------------");

            System.out.print("Enter your choice from (1 to 4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("------------------------------------------");

            switch (choice) {
                case 1:
                    new AdminUI().showMenu();
                    break;
                case 2:
                    new StaffUI().showMenu();
                    break;
                case 3:
                    new StudentUI().showMenu();
                    break;
                case 4:
                    System.out.print("Are You Sure Want to Quit the Application (yes/no): ");
                    String str = scanner.next();
                    if (str.toLowerCase().equals("yes")) {
                        System.out.println("Exiting Application...");
                        return;
                    } else {
                        System.out.println("Cancelled!...");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void initializeAdmin() {
        List<Admin> admins = CSVUtils.readAdmins();
        if (admins.isEmpty()) {
            System.out.println("------------------------------------------");
            System.out.println("No admins found. Adding the first admin.");
            System.out.println("------------------------------------------");
            addAdmin();
        }
    }

    private static void addAdmin() {
        System.out.println("------------------------------------------");
        System.out.print("Enter Admin ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Admin Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        Admin newAdmin = new Admin(id, name, password);
        List<Admin> admins = CSVUtils.readAdmins();
        admins.add(newAdmin);
        CSVUtils.writeAdmins(admins);

        System.out.println("------------------------------------------");
        System.out.println("Admin added successfully.");
        System.out.println("------------------------------------------");
    }
}
