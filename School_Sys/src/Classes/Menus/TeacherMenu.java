package Classes.Menus;

import Classes.Actors.Student;
import Classes.Actors.Teacher;
import Classes.Studies.AssignmentInfo;
import Classes.Studies.Lesson;
import Classes.Studies.TestInfo;
import Classes.Utilities.SystemRelated;
import Classes.Utilities.Template;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherMenu {
    private Scanner scanner;
    private ArrayList<Student> studentArrayList;
    private ArrayList<Lesson> lessonArrayList;

    public void teacherLoginMenu(ArrayList<Student> studentArrayList, ArrayList<Lesson> lessonArrayList, ArrayList<Teacher> teacherArrayList) {
        this.scanner = new Scanner(System.in);
        this.lessonArrayList = lessonArrayList;
        this.studentArrayList = studentArrayList;
        new SystemRelated().SystemCls();
        System.out.println(new Template().ANSI_PURPLE + "[LOG IN MENU TEACHER]" + new Template().ANSI_RESET);
        System.out.println("1. Log In as Teacher\n2. Sign Up as Teacher\n" + new Template().ANSI_RED + "[0. BACK]" + new Template().ANSI_RESET);
        switch (new SystemRelated().chooseMenuInput(0, 2)) {
            case 1 -> loginAsTeacher(teacherArrayList);
            case 2 -> signupAsTeacher(teacherArrayList);
            default -> {
                return;
            }
        }
        teacherLoginMenu(studentArrayList, lessonArrayList, teacherArrayList);
    }

    private void teacherMainMenu(Teacher currActiveTeacher) {
        new SystemRelated().SystemCls();

        System.out.println(new Template().ANSI_PURPLE + "[TEACHER MAIN MENU]" + new Template().ANSI_RESET);
        System.out.println(new Template().ANSI_PURPLE + "[YOUR TEACHER ID: " + currActiveTeacher.getID() + "]" + new Template().ANSI_RESET);
        System.out.println("1. Add Lesson Choice\n2. Delete Lesson\n3. Add Grades\n4. Remove Student Lesson\n" + new Template().ANSI_RED + "[0. BACK]" + new Template().ANSI_RESET);
        switch (new SystemRelated().chooseMenuInput(0, 4)) {
            case 1 -> addLessonChoice();
            case 2 -> deleteLessonChoice();
            case 3 -> addGradeToStudent(currActiveTeacher);
            case 4 -> removeLessonFromStudent(currActiveTeacher);
            default -> {
                return;
            }
        }

        teacherMainMenu(currActiveTeacher);
    }

    private void addLessonChoice() {
        new SystemRelated().SystemCls();

        Lesson newLesson = new Lesson();
        lessonArrayList.add(newLesson);

        new SystemRelated().SystemCls();

        System.out.println(new Template().ANSI_GREEN + "Successfully Created Lesson!" + new Template().ANSI_RESET);
        System.out.println("Press Enter to Continue...");
        scanner.nextLine();
    }

    private void deleteLessonChoice() {
        new SystemRelated().SystemCls();

        if (lessonArrayList.size() == 0) {
            System.out.println(new Template().ANSI_RED + "No Data!\nAsk Your Teacher to Provide Lessons!" + new Template().ANSI_RESET);

        } else {
            new Lesson(true).lessonViewList(lessonArrayList, false);

            System.out.printf("Which Lesson to Delete? [1-%d] -> ", lessonArrayList.size());
            int lessonIndex = new SystemRelated().chooseNumber(1, lessonArrayList.size()) - 1;

            lessonArrayList.remove(lessonIndex);

            new SystemRelated().SystemCls();

            System.out.println(new Template().ANSI_GREEN + "Successfully Deleted!\n" + new Template().ANSI_RESET + "Student Won't Longer Be Able To Take This Course");
        }

        System.out.println("Press Enter to Continue...");
        scanner.nextLine();
    }

    private void addGradeToStudent(Teacher currActiveTeacher) {
        new SystemRelated().SystemCls();

        if (studentArrayList.size() == 0) {
            System.out.println(new Template().ANSI_RED + "No Students Yet!" + new Template().ANSI_RESET);

            System.out.println("Press Enter to Continue...");
            scanner.nextLine();
        } else {
            new Student().studentViewList(studentArrayList, false);
            System.out.printf("Which Student? [1-%d] -> ", studentArrayList.size());

            int studentIndex = new SystemRelated().chooseNumber(1, studentArrayList.size()) - 1;
            new SystemRelated().SystemCls();
            ArrayList<Lesson> lessonOfCurrStudent = studentArrayList.get(studentIndex).getLessonArrayList();

            ArrayList<Lesson> lessonOfCurrStudentWithCurrTeacher = new ArrayList<>();

            int index = 0;
            for (int i = 0; i < lessonOfCurrStudent.size(); i++) {
                Lesson currLesson = lessonOfCurrStudent.get(i);
                if (currLesson.getTeacherRelatedID().compareTo(currActiveTeacher.getID()) == 0) {
                    System.out.printf("%d. %s\n", ++index, currLesson.getName());
                    lessonOfCurrStudentWithCurrTeacher.add(currLesson);
                }
            }

            if (lessonOfCurrStudentWithCurrTeacher.size() == 0) {
                System.out.println(new Template().ANSI_RED + "No Suitable Lesson Found!" + new Template().ANSI_RESET);

                System.out.println("Press Enter to Continue...");
                scanner.nextLine();
            } else {

                System.out.printf("Which Lesson? [1-%d] -> ", lessonOfCurrStudentWithCurrTeacher.size());
                int lessonIndex = new SystemRelated().chooseNumber(1, lessonOfCurrStudentWithCurrTeacher.size()) - 1;

                new SystemRelated().SystemCls();

                System.out.println("1. Assignment\n2. Test");
                System.out.print("? [1-2] -> ");
                int choice = new SystemRelated().chooseNumber(1, 2);

                System.out.print("Score? [0-100] -> ");
                int score = new SystemRelated().chooseNumber(0, 100);

                switch (choice) {
                    case 1 ->
                            lessonOfCurrStudentWithCurrTeacher.get(lessonIndex).addAssignmentList(new AssignmentInfo(score));
                    case 2 -> lessonOfCurrStudentWithCurrTeacher.get(lessonIndex).addTestList(new TestInfo(score));
                }

                new SystemRelated().SystemCls();

                System.out.print(new Template().ANSI_GREEN + "Successfully Added!" + new Template().ANSI_RESET + "\nAdd Again? [Yes ; No] -> ");
                String input = scanner.nextLine();
                if (input.compareTo("Yes") == 0) {
                    addGradeToStudent(currActiveTeacher);
                }
            }
        }

    }

    private void removeLessonFromStudent(Teacher currActiveTeacher) {
        new SystemRelated().SystemCls();

        if (studentArrayList.size() == 0) {
            System.out.println(new Template().ANSI_RED + "No Students Yet!" + new Template().ANSI_RESET);

        } else {
            new Student().studentViewList(studentArrayList, false);
            System.out.printf("Which Student? [1-%d] -> ", studentArrayList.size());

            int studentIndex = new SystemRelated().chooseNumber(1, studentArrayList.size()) - 1;
            ArrayList<Lesson> lessonOfCurrStudent = studentArrayList.get(studentIndex).getLessonArrayList();

            new SystemRelated().SystemCls();

            ArrayList<Lesson> lessonOfCurrStudentWithCurrTeacher = new ArrayList<>();
            int index = 0;
            for (int i = 0; i < lessonOfCurrStudent.size(); i++) {
                Lesson currLesson = lessonOfCurrStudent.get(i);
                if (currLesson.getTeacherRelatedID().compareTo(currActiveTeacher.getID()) == 0) {
                    System.out.printf("%d. %s\n", ++index, currLesson.getName());
                    lessonOfCurrStudentWithCurrTeacher.add(currLesson);
                }
            }

            if (lessonOfCurrStudentWithCurrTeacher.size() == 0) {
                System.out.println(new Template().ANSI_RED + "No Suitable Lesson Found!" + new Template().ANSI_RESET);

            } else {
                System.out.printf("Which Lesson? [1-%d] -> ", lessonOfCurrStudentWithCurrTeacher.size());
                int lessonIndex = new SystemRelated().chooseNumber(1, lessonOfCurrStudentWithCurrTeacher.size()) - 1;

                lessonOfCurrStudent.remove(lessonOfCurrStudentWithCurrTeacher.get(lessonIndex));

                new SystemRelated().SystemCls();
                System.out.println(new Template().ANSI_GREEN + "Successfully Deleted!" + new Template().ANSI_RESET);
            }

        }

        System.out.println("Press Enter to Continue...");
        scanner.nextLine();

    }

    private void loginAsTeacher(ArrayList<Teacher> teacherArrayList) {
        new SystemRelated().SystemCls();
        Scanner scanner = new Scanner(System.in);

        System.out.print(new Template().ANSI_PURPLE + "[LOG IN AS TEACHER]" + new Template().ANSI_RESET + "\nName? ");
        String name = scanner.nextLine();

        System.out.print("Password? ");
        String password = scanner.nextLine();

        Teacher currActiveTeacher = new Teacher().logInForTeacher(name, password, teacherArrayList);
        new SystemRelated().SystemCls();
        if (currActiveTeacher != null) {
            System.out.println(new Template().ANSI_GREEN + "Successfully Logged In!" + new Template().ANSI_RESET);
            System.out.println("Press Enter to Continue...");
            scanner.nextLine();

            teacherMainMenu(currActiveTeacher);
        } else {
            System.out.println(new Template().ANSI_RED + "No Such Account Found!" + new Template().ANSI_RESET);
            System.out.println("Press Enter to Continue...");
            scanner.nextLine();
        }
    }

    private void signupAsTeacher(ArrayList<Teacher> teacherArrayList) {
        Teacher currActiveTeacher = new Teacher(teacherArrayList);
        teacherArrayList.add(currActiveTeacher);

        teacherMainMenu(currActiveTeacher);
    }

}
