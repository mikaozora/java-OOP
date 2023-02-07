package Menu;

import App.Admin;
import App.Student;
import App.Teacher;
import App.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {

    public User loginMenu(Scanner scan, ArrayList<Student> students, ArrayList<Teacher> teachers, ArrayList<Admin> admins) {
        String username, password;
        boolean res = false;
        User temp = new User();
        do {
            System.out.println("===Login====");
            System.out.print("Username: ");
            username = scan.nextLine();
            System.out.print("Password: ");
            password = scan.nextLine();
            // check admin
            for (Admin admin : admins) {
                if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                    res = true;
                    temp = admin;
                }
            }

            // check student
            for (Student student : students) {
                if (student.getUsername().equals(username) && student.getPassword().equals(password)) {
                    res = true;
                    temp = student;
                }
            }

            // check teacher
            for (Teacher teacher : teachers) {
                if (teacher.getUsername().equals(username) && teacher.getPassword().equals(password)) {
                    res = true;
                    temp = teacher;
                }
            }
            if(!res){
                System.out.println("Wrong username or password");
            }
        } while (!res);
        return temp;
    }
}
