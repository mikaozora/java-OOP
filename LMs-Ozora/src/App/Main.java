package App;

import Menu.UserMenu;

import java.util.ArrayList;
import java.util.Scanner;

import Enum.EvalEnum;

public class Main {

    private Scanner scan = new Scanner(System.in);
//    private School8 school;

    public Main(Scanner scan){
        this.scan = scan;
    }
    public static void main(String[] args) {
        School school = new School();

        school.addAdmin(new Admin("admin", "admin", "admin1", "bogor", 20, "male", "1234"));
//        school.addSubject(new Subject("1234", "Math"));
//        school.addSubject(new Subject("3456", "Science"));
//        ArrayList<Subject> subjectsTemp = new ArrayList<>();
//        subjectsTemp.add(new Subject("1234", "Math"));
//        Student temp = new Student("mika", "mika", "mika", "sentul", 18, "male", "890", subjectsTemp);
//        school.addStudent(temp);
////        school.addTeacher(new Teacher("hero", "hero", "hero", "depok", 35, "Male", "678", 100000, subjectsTemp));
////        school.addEvaluation(new Evaluation("467", "Tugas1", EvalEnum.Task));
//        school.addReport(new Report("345", 90, temp, "467"));


        UserMenu userMenu = new UserMenu();
        school.loginMenu(school);
    }
}
