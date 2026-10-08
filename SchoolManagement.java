package schoolmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        System.out.println("======================================");
        System.out.println("       SCHOOL MANAGEMENT SYSTEM");
        System.out.println("======================================");

        do {
            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");

            }

        } while (choice != 5);

        input.close();
    }

    // Add Student
    public static void addStudent() {

        System.out.println();
        System.out.println("------ ADD STUDENT ------");

        System.out.print("Enter student ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter student age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Enter student class: ");
        String studentClass = input.nextLine();

        Student student = new Student(id, name, age, studentClass);

        students.add(student);

        System.out.println("Student added successfully! 🎉");
    }

    // View Students
    public static void viewStudents() {

        System.out.println();
        System.out.println("------ ALL STUDENTS ------");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println("--------------------------");
            System.out.println("ID: " + student.id);
            System.out.println("Name: " + student.name);
            System.out.println("Age: " + student.age);
            System.out.println("Class: " + student.studentClass);
        }
    }

    // Search Student
    public static void searchStudent() {

        System.out.println();
        System.out.println("------ SEARCH STUDENT ------");

        System.out.print("Enter student ID: ");
        int id = input.nextInt();

        boolean found = false;

        for (Student student : students) {

            if (student.id == id) {

                System.out.println("Student found!");
                System.out.println("ID: " + student.id);
                System.out.println("Name: " + student.name);
                System.out.println("Age: " + student.age);
                System.out.println("Class: " + student.studentClass);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Delete Student
    public static void deleteStudent() {

        System.out.println();
        System.out.println("------ DELETE STUDENT ------");

        System.out.print("Enter student ID: ");
        int id = input.nextInt();

        boolean found = false;

        for (Student student : students) {

            if (student.id == id) {

                students.remove(student);

                System.out.println("Student deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
}

// Student Class
class Student {

    int id;
    String name;
    int age;
    String studentClass;

    Student(int id, String name, int age, String studentClass) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.studentClass = studentClass;
    }
}