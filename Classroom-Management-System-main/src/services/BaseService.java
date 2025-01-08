package services;

import models.Staff;
import models.Student;
import utils.CSVUtils;

import java.util.List;
import java.util.Scanner;

public abstract class BaseService {


    // Method to delete a student by ID
    public void deleteStudentById(String studentId) {
        List<Student> students = CSVUtils.readStudents();
        students.removeIf(student -> student.getId().equals(studentId));
        CSVUtils.writeStudents(students);
    }

    // Method to delete a staff by ID
    public void deleteStaffById(String staffId) {
        List<Staff> staffs = CSVUtils.readStaffs();
        staffs.removeIf(staff -> staff.getId().equals(staffId));
        CSVUtils.writeStaffs(staffs);
    }
    
    // Common method to view and edit details
    public <T> void viewAndEditDetails(List<T> items, String type) {
        if (items.isEmpty()) {
            System.out.println("No " + type + " found.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        // Display header
        if (type.equals("staff")) {
            System.out.printf("%-5s %-20s%n", "ID", "Name");
        } else if (type.equals("student")) {
            System.out.printf("%-5s %-20s%n", "ID", "Name");
        }
        System.out.println("--------------------------------");

        // Display ID and Name
        for (T item : items) {
            if (item instanceof Staff) {
                Staff staff = (Staff) item;
                System.out.printf("%-5s %-20s%n", staff.getId(), staff.getName());
            } else if (item instanceof Student) {
                Student student = (Student) item;
                System.out.printf("%-5s %-20s%n", student.getId(), student.getName());
            }
        }

        System.out.print("Enter the ID to view details (or 0 to cancel): ");
        String id = scanner.nextLine();

        if (id.equals("0")) {
            System.out.println("Operation cancelled.");
            return;
        }

        T selectedItem = null;
        for (T item : items) {
            if (item instanceof Staff && ((Staff) item).getId().equals(id)) {
                selectedItem = item;
                break;
            } else if (item instanceof Student && ((Student) item).getId().equals(id)) {
                selectedItem = item;
                break;
            }
        }

        if (selectedItem != null) {
            if (selectedItem instanceof Staff) {
                Staff staff = (Staff) selectedItem;
                System.out.printf("ID: %-5s Name: %-20s DOB: %-10s Age: %-5s Address: %-30s%n",
                        staff.getId(), staff.getName(), staff.getDob(),
                        staff.getAge(), staff.getAddress());
            } else if (selectedItem instanceof Student) {
                Student student = (Student) selectedItem;
                System.out.printf("ID: %-5s Name: %-20s DOB: %-10s Age: %-5s Address: %-30s Blood Group: %-10s%n",
                        student.getId(), student.getName(), student.getDob(),
                        student.getAge(), student.getAddress(), student.getBloodGroup());
            }

            System.out.print("Do you want to edit this " + type + "'s details? (yes/no): ");
            String editChoice = scanner.nextLine();

            if (editChoice.equalsIgnoreCase("yes")) {
                while (true) {
                    System.out.println("What would you like to edit?");
                    if (type.equals("staff")) {
                        System.out.println("1. Name");
                        System.out.println("2. DOB");
                        System.out.println("3. Age");
                        System.out.println("4. Address");
                        System.out.println("5. Done");
                    } else if (type.equals("student")) {
                        System.out.println("1. Name");
                        System.out.println("2. DOB");
                        System.out.println("3. Age");
                        System.out.println("4. Address");
                        System.out.println("5. Blood Group");
                        System.out.println("6. Done");
                    }

                    System.out.print("Enter your choice: ");
                    int editOption = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (editOption) {
                        case 1:
                            System.out.print("Enter new Name: ");
                            String name = scanner.nextLine();
                            if (selectedItem instanceof Staff) {
                                ((Staff) selectedItem).setName(name);
                            } else if (selectedItem instanceof Student) {
                                ((Student) selectedItem).setName(name);
                            }
                            break;
                        case 2:
                            System.out.print("Enter new DOB: ");
                            String dob = scanner.nextLine();
                            if (selectedItem instanceof Staff) {
                                ((Staff) selectedItem).setDob(dob);
                            } else if (selectedItem instanceof Student) {
                                ((Student) selectedItem).setDob(dob);
                            }
                            break;
                        case 3:
                            System.out.print("Enter new Age: ");
                            String age = scanner.nextLine();
                            if (selectedItem instanceof Staff) {
                                ((Staff) selectedItem).setAge(age);
                            } else if (selectedItem instanceof Student) {
                                ((Student) selectedItem).setAge(age);
                            }
                            break;
                        case 4:
                            System.out.print("Enter new Address: ");
                            String address = scanner.nextLine();
                            if (selectedItem instanceof Staff) {
                                ((Staff) selectedItem).setAddress(address);
                            } else if (selectedItem instanceof Student) {
                                ((Student) selectedItem).setAddress(address);
                            }
                            break;
                        case 5:
                            if (type.equals("student")) {
                                System.out.print("Enter new Blood Group: ");
                                String bloodGroup = scanner.nextLine();
                                ((Student) selectedItem).setBloodGroup(bloodGroup);
                                break;
                            }else{
                                CSVUtils.writeStaffs((List<Staff>) items);
                                System.out.println("Staff details updated successfully.");
                                return;
                            }
                            // Fall through to default case if not student
                        case 6:
                            if (type.equals("student")) {
                                CSVUtils.writeStudents((List<Student>) items);
                                System.out.println("Student details updated successfully.");
                                return;
                            }
                        
                        default:
                            System.out.println("Invalid choice. Please select a valid option.");
                    }
                }
            } else {
                System.out.println("Edit operation cancelled.");
            }
        } else {
            System.out.println("Invalid ID.");
        }
    }
}
