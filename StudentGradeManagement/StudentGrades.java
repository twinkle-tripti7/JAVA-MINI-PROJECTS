package StudentGradeManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentGrades {
    private List<Student> students;
    private Scanner scanner;

    public StudentGrades() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        StudentGrades system = new StudentGrades();
        system.run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGrade();
                    break;
                case 3:
                    generateReport();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\nStudent Grades Management System");
        System.out.println("1. Add name of the student: ");
        System.out.println("2. Add their grades :");
        System.out.println("3. Generate their Report Card: ");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return choice;
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        students.add(new Student(name));
        System.out.println("Student added successfully.");
    }

    private void addGrade() {
        if (students.isEmpty()) {
            System.out.println("No students available. Please add a student first.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.next();
        Student student = findStudentByName(name);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter grade: ");
        try {
            int grade = scanner.nextInt();
            student.addGrade(grade);
            System.out.println("Grade added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid grade.");
            scanner.next(); // Clear the invalid input
        }
    }

    private Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    private void generateReport() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\nStudent Grades Report:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("Average Grade: " + student.getAverageGrade());
            System.out.println();
        }
    }
}
