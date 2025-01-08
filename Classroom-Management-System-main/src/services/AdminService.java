package services;

import models.Admin;
import models.Staff;
import models.Student;
import utils.CSVUtils;

import java.util.List;
import java.util.Scanner;

public class AdminService extends BaseService{

    // Authenticate an admin by checking password against the list of admins
    public boolean authenticate(String password) {
        List<Admin> admins = CSVUtils.readAdmins();
        for (Admin admin : admins) {
            if (admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Staff getStaffById(String id) {
        List<Staff> staffs = CSVUtils.readStaffs();
        for (Staff staff : staffs) {
            if (staff.getId().equals(id)) {
                return staff;
            }
        }
        return null;
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

    public void deleteStaff(String id) {
        List<Staff> staffs = CSVUtils.readStaffs();
        staffs.removeIf(staff -> staff.getId().equals(id));
        CSVUtils.writeStaffs(staffs);
        System.out.println("Staff deleted successfully.");
    }

    public void deleteStudent(String id) {
        List<Student> students = CSVUtils.readStudents();
        students.removeIf(student -> student.getId().equals(id));
        CSVUtils.writeStudents(students);
        System.out.println("Student deleted successfully.");
    }

    // View and edit staff details
    public void viewAndEditStaffDetails() {
        List<Staff> staffs = CSVUtils.readStaffs();
        viewAndEditDetails(staffs, "staff");
    }

    // View and edit student details
    public void viewAndEditStudentDetails() {
        List<Student> students = CSVUtils.readStudents();
        viewAndEditDetails(students, "student");
    }

    // Hire a new staff member
    public void hireStaff() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Staff ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Staff DOB (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Staff Age: ");
        String age = scanner.nextLine();
        System.out.print("Enter Staff Address: ");
        String address = scanner.nextLine();

        Staff newStaff = new Staff(id, name, dob, age, address);
        List<Staff> staffs = CSVUtils.readStaffs();
        staffs.add(newStaff);
        CSVUtils.writeStaffs(staffs);

        System.out.println("Staff hired successfully.");
    }

    // Edit schedules (method implementation needed)
    public void editSchedules() {
        System.out.println("Edit schedules functionality not implemented.");
    }
}
