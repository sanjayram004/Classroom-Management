package utils;

import models.Admin;
import models.Staff;
import models.Student;
import models.Feedback;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    private static final String ADMIN_CSV_FILE = "data/admin.csv";
    private static final String STUDENTS_CSV_FILE = "data/students.csv";
    private static final String STAFFS_CSV_FILE = "data/staffs.csv";
    private static final String FEEDBACK_CSV_FILE = "data/feedback.csv";

    // Read a list of Admins from the CSV file
    public static List<Admin> readAdmins() {
        List<Admin> admins = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ADMIN_CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    admins.add(new Admin(values[0], values[1], values[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admins;
    }

    // Write a list of Admins to the CSV file
    public static void writeAdmins(List<Admin> admins) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ADMIN_CSV_FILE))) {
            for (Admin admin : admins) {
                bw.write(String.join(",", admin.getId(), admin.getName(), admin.getPassword()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Read a list of Students from the CSV file
    public static List<Student> readStudents() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(STUDENTS_CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 6) {
                    students.add(new Student(values[0], values[1], values[2], values[3], values[4], values[5]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Write a list of Students to the CSV file
    public static void writeStudents(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STUDENTS_CSV_FILE))) {
            for (Student student : students) {
                bw.write(String.join(",", student.getId(), student.getName(), student.getDob(), student.getAge(),
                        student.getAddress(), student.getBloodGroup()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read a list of Staffs from the CSV file
    public static List<Staff> readStaffs() {
        List<Staff> staffs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(STAFFS_CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 5) {
                    staffs.add(new Staff(values[0], values[1], values[2], values[3], values[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staffs;
    }

    // Write a list of Staffs to the CSV file
    public static void writeStaffs(List<Staff> staffs) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STAFFS_CSV_FILE))) {
            for (Staff staff : staffs) {
                bw.write(String.join(",", staff.getId(), staff.getName(), staff.getDob(), staff.getAge(),
                        staff.getAddress()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Feedback> readFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FEEDBACK_CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    feedbackList.add(new Feedback(values[0], values[1], Boolean.parseBoolean(values[2])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return feedbackList;
    }

    // Write a list of Feedback to the CSV file
    public static void writeFeedback(List<Feedback> feedbackList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FEEDBACK_CSV_FILE))) {
            for (Feedback feedback : feedbackList) {
                bw.write(String.join(",", feedback.getStudentId(), feedback.getFeedback(),
                        String.valueOf(feedback.isResolved())));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
