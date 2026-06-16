// CODSOFT Java Development Internship
// Task 5 - Student Management System

import java.util.ArrayList;
import java.util.Scanner;

class Student
{
    int rollNo;
    String name;
    String grade;

    Student(int rollNo, String name, String grade)
    {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }

    void display()
    {
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Grade       : " + grade);
        System.out.println("----------------------------");
    }
}

public class StudentManagementSystem
{
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void addStudent(Scanner sc)
    {
        System.out.print("Enter Roll Number : ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Grade : ");
        String grade = sc.nextLine();

        Student s = new Student(roll, name, grade);
        studentList.add(s);

        System.out.println("Student Added Successfully");
    }

    public static void displayStudents()
    {
        if(studentList.isEmpty())
        {
            System.out.println("No Students Available");
            return;
        }

        System.out.println("\n----- Student Records -----");

        for(Student s : studentList)
        {
            s.display();
        }
    }

    public static void searchStudent(Scanner sc)
    {
        System.out.print("Enter Roll Number to Search : ");
        int roll = sc.nextInt();

        boolean found = false;

        for(Student s : studentList)
        {
            if(s.rollNo == roll)
            {
                System.out.println("\nStudent Found");
                s.display();
                found = true;
                break;
            }
        }

        if(!found)
        {
            System.out.println("Student Not Found");
        }
    }

    public static void removeStudent(Scanner sc)
    {
        System.out.print("Enter Roll Number to Remove : ");
        int roll = sc.nextInt();

        Student removeStudent = null;

        for(Student s : studentList)
        {
            if(s.rollNo == roll)
            {
                removeStudent = s;
                break;
            }
        }

        if(removeStudent != null)
        {
            studentList.remove(removeStudent);
            System.out.println("Student Removed Successfully");
        }
        else
        {
            System.out.println("Student Not Found");
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int choice;

        System.out.println("=================================");
        System.out.println("   STUDENT MANAGEMENT SYSTEM");
        System.out.println("=================================");

        do
        {
            System.out.println("\n1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    searchStudent(sc);
                    break;

                case 3:
                    removeStudent(sc);
                    break;

                case 4:
                    displayStudents();
                    break;

                case 5:
                    System.out.println("Thank You For Using Student Management System");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        }while(choice != 5);

        sc.close();
    }
}