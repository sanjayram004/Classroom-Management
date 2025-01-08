package services;

import models.Feedback;
import models.Staff;
import models.Student;
import utils.CSVUtils;

import java.util.List;
import java.util.Scanner;

public class StaffService extends BaseService {

    public Staff authenticate(String id, String dob) {
        List<Staff> staffs = CSVUtils.readStaffs();
        for (Staff staff : staffs) {
            if (staff.getId().equals(id) && staff.getDob().equals(dob)) {
                return staff;
            }
        }
        return null;
    }

    public void viewAndEditStudentDetails() {
        List<Student> students = CSVUtils.readStudents();
        viewAndEditDetails(students, "student");
    }

    public Student getStudentById(String id) {
        List<Student> students = CSVUtils.readStudents();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(String id) {
        List<Student> students = CSVUtils.readStudents();
        students.removeIf(student -> student.getId().equals(id));
        CSVUtils.writeStudents(students);
        System.out.println("------------------------------------------");
        System.out.println("Student deleted successfully.");
        System.out.println("------------------------------------------");
    }

    public void viewAndResolveFeedback() {
        List<Feedback> feedbackList = CSVUtils.readFeedback();
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------------");
        System.out.println("Feedback from students:");
        for (Feedback feedback : feedbackList) {
            System.out.printf("Student ID: %s, Feedback: %s, Resolved: %s%n",
                    feedback.getStudentId(), feedback.getFeedback(), feedback.isResolved() ? "Yes" : "No");
        }

        System.out.println("------------------------------------------");
        System.out.print("Enter the ID of the student whose feedback you want to resolve (or 0 to cancel): ");
        String id = scanner.nextLine();

        if (id.equals("0")) {
            System.out.println("Operation cancelled.");
            System.out.println("------------------------------------------");
            return;
        }

        for (Feedback feedback : feedbackList) {
            if (feedback.getStudentId().equals(id)) {
                feedback.setResolved(true);
            }
        }
        CSVUtils.writeFeedback(feedbackList);
        System.out.println("------------------------------------------");
        System.out.println("Feedback resolved successfully.");
        System.out.println("------------------------------------------");
    }

}
