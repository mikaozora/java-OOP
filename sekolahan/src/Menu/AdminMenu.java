package Menu;

import App.Admin;
import App.Student;
import App.Subject;
import App.Teacher;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenu {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Subject> subjects;
    private ArrayList<Subject> subjectsAvail;
    private ArrayList<Admin> admins;
    private Scanner scan;
    public void mainMenu(Admin adminLogged, ArrayList<Student> students, ArrayList<Teacher> teachers, ArrayList<Subject> subjects, ArrayList<Subject> subjectsAvail, ArrayList<Admin> admins){
        this.students = students;
        this.teachers = teachers;
        this.subjects = subjects;
        this.subjectsAvail = subjectsAvail;
        this.admins = admins;
        this.scan = new Scanner(System.in);

        int choose = 0;
        String badInput = null;
        System.out.println("============================");
        System.out.println("Welcome " + adminLogged.getName());
        System.out.println("============================");
        do{
            try{
                System.out.println("1. Add teacher");
                System.out.println("2. Add Student");
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
                    addTeacher();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    new UserMenu().login(teachers,students,subjects,admins, subjectsAvail);
                    break;
                default:
                    break;
            }
        }while (choose != 3);
    }

    public void addTeacher(){
        String username = null, password = null, name = null, badInput = null;
        boolean res;
        int choose = 0;
        System.out.println("==========ADD TEACHER=========");
        do{
            res = false;
            try{
                System.out.print("Username: ");
                username = scan.nextLine();
                if(username.equals("admin")){
                    res = true;
                    System.out.println("Username Already Exist");
                }else if(new Student().checkUsernameStudent(username, students)){
                    res = true;
                    System.out.println("Username Already Exist");
                }else if(new Teacher().checkUsernameTeacher(username, teachers)){
                    res = true;
                    System.out.println("Username Already Exist");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(res);
        do{
            try{
                System.out.print("Password: ");
                password = scan.nextLine();
                if(password.length() < 8){
                    System.out.println("Please input password 8 Character length");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(password.length() < 8);
        do{
            try{
                System.out.print("Name: ");
                name = scan.nextLine();
                if(name.length() < 1){
                    System.out.println("Please input name");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(name.length() < 1);

        new Subject().viewAll(subjectsAvail);
        do{
            try{
                System.out.print("choose subject: ");
                choose = scan.nextInt();
                scan.nextLine();
                if(choose <= 0 || choose > subjectsAvail.size()){
                    System.out.println("please input a valid number");
                }
                badInput = null;
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("please input a number");
            }
        }while(badInput != null || choose <= 0 || choose > subjectsAvail.size());
        Teacher teacher = new Teacher(username, password, name);
        teachers.add(teacher);
        teacher.addSubjectTeacher(subjectsAvail.get(choose-1));
        subjectsAvail.remove(choose-1);
        System.out.println("Succesfully add Teacher!");
        System.out.print("Press enter to continue....");
        scan.nextLine();
    }

    public void addStudent(){
        String username = null, password = null, name = null, badInput = null;
        boolean res;
        int choose = 0;
        System.out.println("==========ADD STUDENT=========");
        do{
            res = false;
            try{
                System.out.print("Username: ");
                username = scan.nextLine();
                if(username.equals("admin")){
                    res = true;
                    System.out.println("Username Already Exist");
                }else if(new Student().checkUsernameStudent(username, students)){
                    res = true;
                    System.out.println("Username Already Exist");
                }else if(new Teacher().checkUsernameTeacher(username, teachers)){
                    res = true;
                    System.out.println("Username Already Exist");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(res);
        do{
            try{
                System.out.print("Password: ");
                password = scan.nextLine();
                if(password.length() < 8){
                    System.out.println("Please input password 8 Character length");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(password.length() < 8);
        do{
            try{
                System.out.print("Name: ");
                name = scan.nextLine();
                if(name.length() < 1){
                    System.out.println("Please input name");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(name.length() < 1);
        students.add(new Student(username, password, name, subjects));
        System.out.println("Succesfully add Student!");
        System.out.print("Press enter to continue....");
        scan.nextLine();
    }
}
