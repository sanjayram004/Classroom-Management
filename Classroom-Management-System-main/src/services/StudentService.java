package services;

import java.util.List;
import java.util.Scanner;
import models.Feedback;
import models.Student;
import utils.CSVUtils;

public class StudentService {

    public Student authenticate(String id, String dob) {
        List<Student> students = CSVUtils.readStudents();
        for (Student student : students) {
            if (student.getId().equals(id) && student.getDob().equals(dob)) {
                return student;
            }
        }
        return null;
    }

    public void viewPersonalDetails(String studentId) {
        List<Student> students = CSVUtils.readStudents();
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                System.out.printf("%-5s %-20s%n", "ID", "Name");
                System.out.printf("%-5s %-20s%n", student.getId(), student.getName());

            }
        }
    }
    public void admitStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student DOB (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        String age = scanner.nextLine();
        System.out.print("Enter Student Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Student Blood Group: ");
        String bloodGroup = scanner.nextLine();

        Student newStudent = new Student(id, name, dob, age, address, bloodGroup);
        List<Student> students = CSVUtils.readStudents();
        students.add(newStudent);
        CSVUtils.writeStudents(students);

        System.out.println("Student admitted successfully.");
    }

   public void provideFeedback(String studentId) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your feedback: ");
        String feedback = scanner.nextLine();

        Feedback newFeedback = new Feedback(studentId, feedback, false);
        List<Feedback> feedbackList = CSVUtils.readFeedback();
        feedbackList.add(newFeedback);
        CSVUtils.writeFeedback(feedbackList);

        System.out.println("Feedback submitted successfully.");
    }

    public void markAttendance(String studentId) {
    }

    public void newAdmission(Student student) {
        List<Student> students = CSVUtils.readStudents();
        students.add(student);
        CSVUtils.writeStudents(students);
    }

    public void scheduleClassForStaff() {
    }
}
