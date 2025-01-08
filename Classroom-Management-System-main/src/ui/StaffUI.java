package ui;

import services.StaffService;
import services.StudentService;

import java.util.Scanner;

import models.Student;

public class StaffUI {
    private StaffService staffService = new StaffService();
    private StudentService studentService = new StudentService();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.print("Enter your ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter your DOB (yyyy-mm-dd): ");
        String dob = scanner.nextLine();

        if (staffService.authenticate(id, dob) == null) {
            System.out.println("Invalid ID or DOB. Access denied.");
            System.out.println("------------------------------------------");
            return;
        }

        System.out.println("Login Successful");
        System.out.println("------------------------------------------");

        while (true) {
            System.out.println("1. View and Edit Student Details");
            System.out.println("2. Resolve Feedback");
            System.out.println("3. Admit New Student");
            System.out.println("4. Remove a Student");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("------------------------------------------");

            switch (choice) {
                case 1:
                    staffService.viewAndEditStudentDetails();
                    break;
                case 2:
                    staffService.viewAndResolveFeedback();
                    break;
                case 3:
                    studentService.admitStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.out.println("------------------------------------------");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    System.out.println("------------------------------------------");
            }
        }
    }

    private void deleteStudent() {
        System.out.println("------------------------------------------");
        System.out.print("Enter Student ID to delete: ");
        String studentId = scanner.nextLine();

        Student student = staffService.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            System.out.println("------------------------------------------");
            return;
        }

        System.out.print("Are you sure you want to delete Student ID: " + studentId + ", Name: " + student.getName()
                + "? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            staffService.deleteStudent(studentId);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Deletion cancelled.");
        }
        System.out.println("------------------------------------------");
    }
}
