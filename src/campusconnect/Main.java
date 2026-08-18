package campusconnect;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt(scanner, "Enter choice: ");

            switch (choice) {
                case 1:
                    addStudent(scanner, students);
                    break;
                case 2:
                    viewStudents(students);
                    break;
                case 3:
                    searchStudent(scanner, students);
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using CampusConnect.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n================================");
        System.out.println("        CAMPUS CONNECT");
        System.out.println("================================");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Exit");
    }

    private static void addStudent(Scanner scanner, ArrayList<Student> students) {
        int id = readInt(scanner, "Enter student ID: ");

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        Student student = new Student(id, name, email);
        students.add(student);

        System.out.println("Student added successfully.");
    }

    private static void viewStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Students ---");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent(Scanner scanner, ArrayList<Student> students) {
        int id = readInt(scanner, "Enter student ID to search: ");

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student found:");
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }

            System.out.println("Please enter a valid number.");
            scanner.nextLine();
        }
    }
}
