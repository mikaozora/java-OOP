package Menu;

import App.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TeacherMenu {

    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Subject> subjects;
    private ArrayList<Subject> subjectsAvail;
    private ArrayList<Admin> admins;
    private Scanner scan;
    public void mainMenu(Teacher teacherLogged, ArrayList<Student> students, ArrayList<Teacher> teachers, ArrayList<Subject> subjects, ArrayList<Subject> subjectsAvail, ArrayList<Admin> admins){
        this.students = students;
        this.teachers = teachers;
        this.subjects = subjects;
        this.subjectsAvail = subjectsAvail;
        this.admins = admins;
        this.scan = new Scanner(System.in);

        int choose = 0;
        String badInput = null;
        System.out.println("===========================");
        System.out.println("Hello " + teacherLogged.getName());
        System.out.println("===========================");
        do{
            try{
                System.out.println("1. View Students");
                System.out.println("2. Add Score");
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
                    viewStudent(teacherLogged);
                    break;
                case 2:
                    addScore(teacherLogged);
                    break;
                case 3:
                    new UserMenu().login(teachers,students,subjects,admins, subjectsAvail);
                    break;
                default:
                    break;
            }
        }while (choose != 3);
    }

    public void viewStudent(Teacher teacherLogged){
        teacherLogged.getSubjects().get(0).viewAllStudent();
    }

    public void addScore(Teacher teacherLogged){
        int choose = 0;
        double score = 0;
        String badInput = null;

        viewStudent(teacherLogged);
        do{
            try{
                System.out.print("choose student: ");
                choose = scan.nextInt();
                scan.nextLine();
                if(choose <= 0 || choose > teacherLogged.getSubjects().get(0).getStudents().size()){
                    System.out.println("please input a valid number");
                }
                badInput = null;
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("please input a number");
            }
        }while(badInput != null || choose <= 0 || choose > teacherLogged.getSubjects().get(0).getStudents().size());

        int indexSubj = -1;
        Student studentChoose = teacherLogged.getSubjects().get(0).getStudents().get(choose-1);
        for(Student student : students){
            for(Subject subject : student.getSubjects()){
                if(subject.getName().equals(teacherLogged.getSubjects().get(0).getName())){
                    indexSubj = student.getSubjects().indexOf(subject);
                }
            }
        }
//        indexSubj = studentChoose.getSubjects().indexOf(teacherLogged.getSubjects().get(0));
        for (int i = 1; i <= 3; i++) {
            do{
                try {
                    System.out.printf("Task %d: ", i);
                    score = scan.nextDouble();
                    scan.nextLine();
                    badInput = null;
                    if(score < 0 || score > 100){
                        System.out.println("score must be between 0 - 100");
                    }
                }catch (InputMismatchException e){
                    badInput = scan.nextLine();
                    System.out.println("please input a number");
                }
            }while(score < 0 || score > 100 || badInput != null);
            studentChoose.getSubjects().get(indexSubj).addTask(new Task(score));
        }
        for (int i = 1; i <= 2; i++) {
            do{
                try {
                    System.out.printf("Exam %d: ", i);
                    score = scan.nextDouble();
                    scan.nextLine();
                    badInput = null;
                    if(score < 0 || score > 100){
                        System.out.println("score must be between 0 - 100");
                    }
                }catch (InputMismatchException e){
                    badInput = scan.nextLine();
                    System.out.println("please input a number");
                }
            }while(score < 0 || score > 100 || badInput != null);
            studentChoose.getSubjects().get(indexSubj).addExam(new Exam(score));
        }
    }
}
