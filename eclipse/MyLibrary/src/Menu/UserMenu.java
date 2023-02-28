package Menu;

import App.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Admin> admins;
    private ArrayList<Book> books;
    private Scanner scan;
    private Database db;

    public void startMenu(Database db){
        this.students = db.getStudents();
        this.teachers = db.getTeachers();
        this.scan = db.getScan();
        this.admins = db.getAdmins();
        this.books = db.getBooks();
        this.db = db;

        int choose;
        do{
            System.out.println("Start Menu");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print(">> ");
            choose = scan.nextInt();
            scan.nextLine();
            switch (choose){
                case 1:
                    login();
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }while (choose != 3);
    }

    public void login(){
        String no = null, password = null;
        boolean res = false;
        do{
            System.out.println("login");
            System.out.print("No Induk: ");
            no = scan.nextLine();
            System.out.print("Password: ");
            password = scan.nextLine();
            Admin admin = new Admin().checkAdmin(no, password, admins);
            Student student = new Student().checkStudent(no, password, students);
            Teacher teacher = new Teacher().checkTeacher(no, password, teachers);
            if(admin != null){
                res = true;
                new AdminMenu().mainMenu(db, scan);
            }else if(student != null){
                res = true;
                new BorrowMenu().mainMenu(student, null, db, scan);
            }else if(teacher != null){
                res = true;
                new BorrowMenu().mainMenu(null, teacher, db, scan);
            }else{
                System.out.println("Wrong username or password");
            }
        }while(!res);

    }
}
