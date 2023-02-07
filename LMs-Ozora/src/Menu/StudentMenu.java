package Menu;

import App.School;
import App.Student;
import App.Subject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMenu {

    public void enrollSubject(Scanner scan, School school, Student studentLogged) {
        int choose = 0;
        String badInput = null;
        studentLogged.viewSubjectToStudent(studentLogged.getSubjectAvail());
        if (studentLogged.getSubjectAvail().size() != 0) {
            do {
                try {
                    System.out.print("Choose Subject: ");
                    choose = scan.nextInt();
                    scan.nextLine();
                    badInput = null;
                    if (choose <= 0 || choose > studentLogged.getSubjectAvail().size()) {
                        System.out.println("Please input a valid number");
                    }
                } catch (InputMismatchException e) {
                    badInput = scan.nextLine();
                    System.out.println("Please input a number");
                }
            } while (badInput != null || choose <= 0 || choose > studentLogged.getSubjectAvail().size());
//            school.addStudentSubject(studentLogged, studentLogged.getSubjectAvail().get(choose - 1));
            studentLogged.addSubject(studentLogged.getSubjectAvail().get(choose-1));
        }
    }

    public void viewScore(School school, Student studentLogged) {
//        school.getSubjectStudent(studentLogged);
        studentLogged.viewSubjectStudent(studentLogged.getSubjectId());
    }

    public void studentMenu(Scanner scan, School school, Student studentLogged) {
        int choose = 0;
        do {
            System.out.println("Welcome " + studentLogged.getName());
            System.out.println("1. Enroll Subject");
            System.out.println("2. View Score");
            System.out.println("3. Logout");
            System.out.print(">> ");
            choose = scan.nextInt();
            scan.nextLine();
            switch (choose) {
                case 1:
                    enrollSubject(scan, school, studentLogged);
                    break;
                case 2:
                    viewScore(school, studentLogged);
                    break;
                case 3:
                    school.loginMenu(school);
                    break;
                default:
                    break;
            }
        } while (choose != 3);


    }
}
