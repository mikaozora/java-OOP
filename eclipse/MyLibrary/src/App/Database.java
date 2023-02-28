package App;

import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Borrow> borrows;
    private ArrayList<Book> books;
    private ArrayList<Admin> admins;
    private Scanner scan;

    public Database(){
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.borrows = new ArrayList<>();
        this.scan = new Scanner(System.in);
        this.books = new ArrayList<>();
        this.admins = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Borrow> getBorrows() {
        return borrows;
    }

    public Scanner getScan() {
        return scan;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }
}
