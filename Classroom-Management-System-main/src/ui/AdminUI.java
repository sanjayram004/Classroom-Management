package ui;

import services.AdminService;
import services.StudentService;

import java.util.Scanner;

import models.Staff;
import models.Student;

public class AdminUI {
    private AdminService adminService = new AdminService();
    private StudentService studentService = new StudentService();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (!adminService.authenticate(password)) {
            System.out.println("Invalid password. Access denied.");
            System.out.println("------------------------------------------");
            return;
        } else {
            System.out.println("Login Successful");
        }

        System.out.println("------------------------------------------");

        while (true) {
            System.out.println("----------------Admin Menu----------------");
            System.out.println("------------------------------------------");
            System.out.println("1. Staff Details");
            System.out.println("2. Student Details");
            System.out.println("4. Hire New Staff");
            System.out.println("5. Admit New Student");
            System.out.println("6. Remove a Staff");
            System.out.println("7. Remove a Student");
            System.out.println("8. Logout");
            System.out.println("------------------------------------------");

            System.out.print("Enter your choice from (1 to 8): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("------------------------------------------");

            switch (choice) {
                case 1:
                    adminService.viewAndEditStaffDetails();
                    break;
                case 2:
                    adminService.viewAndEditStudentDetails();
                    break;
                case 3:
                    adminService.editSchedules();
                    break;
                case 4:
                    adminService.hireStaff();
                    break;
                case 5:
                    studentService.admitStudent();
                    break;
                case 6:
                    deleteStaff();
                    break;
                case 7:
                    deleteStudent();
                    break;
                case 8:
                    System.out.println("Logging out...");
                    System.out.println("------------------------------------------");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    System.out.println("------------------------------------------");
            }
        }
    }

    private void deleteStaff() {
        System.out.println("------------------------------------------");
        System.out.print("Enter Staff ID to delete: ");
        String staffId = scanner.nextLine();

        Staff staff = adminService.getStaffById(staffId);
        if (staff == null) {
            System.out.println("Staff not found.");
            System.out.println("------------------------------------------");
            return;
        }

        System.out.print(
                "Are you sure you want to delete Staff ID: " + staffId + ", Name: " + staff.getName() + "? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            adminService.deleteStaff(staffId);
            System.out.println("Staff deleted successfully.");
        } else {
            System.out.println("Deletion cancelled.");
        }
        System.out.println("------------------------------------------");
    }

    private void deleteStudent() {
        System.out.println("------------------------------------------");
        System.out.print("Enter Student ID to delete: ");
        String studentId = scanner.nextLine();

        Student student = adminService.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            System.out.println("------------------------------------------");
            return;
        }

        System.out.print("Are you sure you want to delete Student ID: " + studentId + ", Name: " + student.getName()
                + "? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            adminService.deleteStudent(studentId);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Deletion cancelled.");
        }
        System.out.println("------------------------------------------");
    }
}
