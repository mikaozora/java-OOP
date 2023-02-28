import Classes.Actors.Student;
import Classes.Actors.Teacher;
import Classes.Menus.StudentMenu;
import Classes.Menus.TeacherMenu;
import Classes.Studies.Lesson;
import Classes.Utilities.SystemRelated;
import Classes.Utilities.Template;

import java.util.ArrayList;
public class Main {
    private ArrayList<Teacher> teacherArrayList;
    private ArrayList<Student> studentArrayList;

    private ArrayList<Lesson> lessonArrayList;

    public static void main(String[] args) {
        new Main().runProgram();
    }
    private Main()
    {
        teacherArrayList = new ArrayList<>();
        studentArrayList = new ArrayList<>();
        lessonArrayList = new ArrayList<>();
    }
    private void runProgram() {
        mainMenu();
    }

    private void mainMenu() {
        new SystemRelated().SystemCls();
        System.out.println(new Template().ANSI_PURPLE+"\n" +
                "███████████████████████████████████████████████████████████████████████████████████████████████████████████\n" +
                "█▄─▀─▄██▀▄─██▄─█─▄█▄─▄▄─█▄─▄▄▀█▄─▄██▀▄─██▄─▀█▄─▄███─▄▄▄▄█─▄▄▄─█─█─███─▄▄▄▄█▄─█─▄█─▄▄▄▄█─▄─▄─█▄─▄▄─█▄─▀█▀─▄█\n" +
                "██▀─▀███─▀─███▄▀▄███─▄█▀██─▄─▄██─███─▀─███─█▄▀─████▄▄▄▄─█─███▀█─▄─███▄▄▄▄─██▄─▄██▄▄▄▄─███─████─▄█▀██─█▄█─██\n" +
                "▀▄▄█▄▄▀▄▄▀▄▄▀▀▀▄▀▀▀▄▄▄▄▄▀▄▄▀▄▄▀▄▄▄▀▄▄▀▄▄▀▄▄▄▀▀▄▄▀▀▀▄▄▄▄▄▀▄▄▄▄▄▀▄▀▄▀▀▀▄▄▄▄▄▀▀▄▄▄▀▀▄▄▄▄▄▀▀▄▄▄▀▀▄▄▄▄▄▀▄▄▄▀▄▄▄▀"+new Template().ANSI_RESET);
        System.out.println(new Template().ANSI_PURPLE+"[XAVERIAN SCHOOL SYSTEM DATABASE]"+new Template().ANSI_RESET);
        System.out.println("1. Student\n2. Teacher\n"+new Template().ANSI_RED+"[0. EXIT]"+new Template().ANSI_RESET);
        switch (new SystemRelated().chooseMenuInput(0, 2)) {
            case 1 -> new StudentMenu().studentLoginMenu(studentArrayList, lessonArrayList, teacherArrayList);
            case 2 -> new TeacherMenu().teacherLoginMenu(studentArrayList, lessonArrayList, teacherArrayList);
            default -> {
                exitProgram();
                return;
            }
        }

        mainMenu();
    }

    private void exitProgram() {
        new SystemRelated().SystemCls();
        System.out.println("System Logged Out!\n");
    }
}