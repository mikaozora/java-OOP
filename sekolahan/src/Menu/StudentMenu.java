package Menu;

import App.Admin;
import App.Student;
import App.Subject;
import App.Teacher;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMenu {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Subject> subjects;
    private ArrayList<Subject> subjectsAvail;
    private ArrayList<Admin> admins;
    private Scanner scan;

    public void mainMenu(Student studentLogged, ArrayList<Student> students, ArrayList<Teacher> teachers, ArrayList<Subject> subjects, ArrayList<Subject> subjectsAvail, ArrayList<Admin> admins){
        this.students = students;
        this.teachers = teachers;
        this.subjects = subjects;
        this.subjectsAvail = subjectsAvail;
        this.admins = admins;
        this.scan = new Scanner(System.in);

        int choose = 0;
        String badInput = null;
        System.out.println("=============================");
        System.out.println("Hello " + studentLogged.getName());
        System.out.println("=============================");
        do{
            try{
                System.out.println("1. Enroll Subject");
                System.out.println("2. View Score");
                System.out.println("3. Logout");
                System.out.print(">> ");
                choose = scan.nextInt();
                scan.nextLine();
                if(choose <= 0 || choose > 3){
                    System.out.println("Please input number between 1 - 3");
                }
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
            switch (choose){
                case 1:
                    enrollSubject(studentLogged);
                    break;
                case 2:
                    viewScore(studentLogged);
                    break;
                case 3:
                    new UserMenu().login(teachers,students,subjects,admins, subjectsAvail);
                    break;
                default:
                    break;
            }
        }while (choose != 3);

    }

    public void enrollSubject(Student studentLogged){
        studentLogged.viewSubjectsAvail();
        int choose = 0;
        String badInput = null;
        do{
            try{
                System.out.print("choose subject: ");
                choose = scan.nextInt();
                scan.nextLine();
                if(choose <= 0 || choose > studentLogged.getSubjectsAvail().size()){
                    System.out.println("please input a valid number");
                }
                badInput = null;
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("please input a number");
            }
        }while(badInput != null || choose <= 0 || choose > studentLogged.getSubjectsAvail().size());

        int index = subjects.indexOf(studentLogged.getSubjectsAvail().get(choose-1));
        String name = studentLogged.getSubjectsAvail().get(choose-1).getName();
        studentLogged.addSubject(new Subject(name));
        subjects.get(index).addStudent(studentLogged);
        studentLogged.getSubjectsAvail().remove(choose-1);
    }

    public void viewScore(Student studentLogged){
        studentLogged.viewSubjects();
        int choose = 0;
        String badInput = null;
        do{
            try{
                System.out.print("choose subject: ");
                choose = scan.nextInt();
                scan.nextLine();
                if(choose <= 0 || choose > studentLogged.getSubjects().size()){
                    System.out.println("please input a valid number");
                }
                badInput = null;
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("please input a number");
            }
        }while(badInput != null || choose <= 0 || choose > studentLogged.getSubjects().size());
        studentLogged.getSubjects().get(choose-1).viewTask();
        studentLogged.getSubjects().get(choose-1).viewExam();
        studentLogged.getSubjects().get(choose-1).viewFinalScore();

    }
}
