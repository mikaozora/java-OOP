package Menu;

import App.Admin;
import App.Student;
import App.Subject;
import App.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {
    private Scanner scan;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;
    private ArrayList<Admin> admins;
    private ArrayList<Subject> subjectsAvail;
    public void login(ArrayList<Teacher> teachers, ArrayList<Student> students, ArrayList<Subject> subjects, ArrayList<Admin> admins, ArrayList<Subject> subjectsAvail){
        this.scan = new Scanner(System.in);
        this.teachers = teachers;
        this.subjects = subjects;
        this.students = students;
        this.subjectsAvail = subjectsAvail;

        String username = null, password = null;
        boolean res = false;
        do{
            try{
                System.out.println("=======LOGIN======");
                System.out.print("Username: ");
                username = scan.nextLine();
                System.out.print("Password: ");
                password = scan.nextLine();
                Admin currAdmin = new Admin().checkAdmin(username,password,admins);
                Student currStudent = new Student().checkStudent(username,password,students);
                Teacher currTeacher = new Teacher().checkTeacher(username,password,teachers);
                if(currAdmin != null){
                    res = true;
                    new AdminMenu().mainMenu(currAdmin, students, teachers, subjects, subjectsAvail, admins);
                }else if(currStudent != null){
                    res = true;
                    new StudentMenu().mainMenu(currStudent, students, teachers, subjects, subjectsAvail, admins);
                }else if(currTeacher != null){
                    res = true;
                    new TeacherMenu().mainMenu(currTeacher, students, teachers, subjects, subjectsAvail, admins);
                }else{
                    System.out.println("Wrong username or password");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(!res);
    }
}
