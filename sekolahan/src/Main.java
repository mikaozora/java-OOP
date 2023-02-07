import App.*;
import Menu.UserMenu;

import java.util.ArrayList;

public class Main {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Subject> subjects;
    private ArrayList<Admin> admins;
    private ArrayList<Subject> subjectsAvail;

    public Main(){
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.subjectsAvail = new ArrayList<>();
    }

    public void startMenu()
    {
        admins.add(new Admin("admin", "admin", "admin"));
        teachers.add(new Teacher("nur", "nur", "nur"));
        subjects.add(new Subject("Kalkulus"));
        subjects.add(new Subject("HCI"));
        subjects.add(new Subject("Science"));
        subjectsAvail.addAll(subjects);
//        subjectsAvail.add(new Subject("Kalkulus"));
//        subjectsAvail.add(new Subject("HCI"));
//        subjectsAvail.add(new Subject("Science"));
        students.add(new Student("mika", "mika", "mika", subjects));
        students.add(new Student("abdi", "abdi", "abdi", subjects));
        new UserMenu().login(teachers, students, subjects, admins, subjectsAvail);
    }
    public static void main(String[] args) {
        new Main().startMenu();
    }
}