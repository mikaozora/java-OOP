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

public class StudentMenu {
    private Scanner scanner;
    private ArrayList<Lesson> lessonArrayList;
    private ArrayList<Teacher> teacherArrayList;

    public void studentLoginMenu(ArrayList<Student> studentArrayList, ArrayList<Lesson> lessonArrayList, ArrayList<Teacher> teacherArrayList) {
        this.scanner = new Scanner(System.in);
        this.lessonArrayList = lessonArrayList;
        this.teacherArrayList = teacherArrayList;

        new SystemRelated().SystemCls();
        System.out.println(new Template().ANSI_PURPLE + "[LOG IN MENU STUDENT]" + new Template().ANSI_RESET);
        System.out.println("1. Log In as Student\n2. Sign Up as Student\n" + new Template().ANSI_RED + "[0. BACK]" + new Template().ANSI_RESET);
        switch (new SystemRelated().chooseMenuInput(0, 2)) {
            case 1 -> loginAsStudent(studentArrayList);
            case 2 -> signupAsStudent(studentArrayList);
            default -> {
                return;
            }
        }
        studentLoginMenu(studentArrayList, lessonArrayList, teacherArrayList);
    }

    private void studentMainMenu(Student currActiveStudent) {
        new SystemRelated().SystemCls();
        System.out.println(new Template().ANSI_PURPLE + "[STUDENT MAIN MENU]" + new Template().ANSI_RESET);
        System.out.println(new Template().ANSI_PURPLE + "[YOUR STUDENT ID: " + currActiveStudent.getID() + "]" + new Template().ANSI_RESET);
        System.out.println("1. View My Lessons Data\n2. View Grades per Lesson\n3. View All Final Grades\n4. Add Lesson\n" + new Template().ANSI_RED + "[0. BACK]" + new Template().ANSI_RESET);
        switch (new SystemRelated().chooseMenuInput(0, 4)) {
            case 1 -> viewStudentLessonData(currActiveStudent, true);
            case 2 -> viewGradesPerLesson(currActiveStudent);
            case 3 -> viewAllFinalGrades(currActiveStudent);
            case 4 -> addLesson(currActiveStudent);
            default -> {
                return;
            }
        }
        studentMainMenu(currActiveStudent);
    }

    private void viewStudentLessonData(Student currActiveStudent, boolean showContinueStatus) {
        new SystemRelated().SystemCls();

        if (currActiveStudent.getLessonArrayListSize() == 0) {
            System.out.println(new Template().ANSI_RED + "You Have No Active Lessons!" + new Template().ANSI_RESET);
            System.out.println("Press Enter to Continue...");
            scanner.nextLine();
        } else {
            System.out.println(new Template().ANSI_PURPLE + "[YOUR LESSONS LIST]" + new Template().ANSI_RESET);
            for (int i = 0; i < currActiveStudent.getLessonArrayListSize(); i++) {
                Lesson currLesson = currActiveStudent.getLessonArrayListAt(i);
                System.out.printf("%d. %s\n", i + 1, currLesson.getName());
            }

            if (showContinueStatus) {
                System.out.println("Press Enter to Continue...");
                scanner.nextLine();
            }
        }

    }

    private void viewGradesPerLesson(Student currActiveStudent) {
        new SystemRelated().SystemCls();

        if (currActiveStudent.getLessonArrayListSize() == 0) {
            System.out.println(new Template().ANSI_RED + "You Have No Active Lessons!" + new Template().ANSI_RESET);
        } else {
            viewStudentLessonData(currActiveStudent, false);
            System.out.printf("Which Lesson? [1-%d] -> ", currActiveStudent.getLessonArrayListSize());
            int lessonIndex = new SystemRelated().chooseNumber(1, currActiveStudent.getLessonArrayListSize()) - 1;

            Lesson lessonForCurrStudent = currActiveStudent.getLessonArrayListAt(lessonIndex);

            new SystemRelated().SystemCls();
            System.out.println(new Template().ANSI_PURPLE + "[" + lessonForCurrStudent.getName().toUpperCase() + "]" + new Template().ANSI_RESET);

            System.out.println(new Template().ANSI_PURPLE + "[Teacher Related ID: " + lessonForCurrStudent.getTeacherRelatedID() + "]" + new Template().ANSI_RESET);
            System.out.println();
            if (lessonForCurrStudent.getAssignmentListSize() == 0) {
                System.out.println(new Template().ANSI_RED + "No Assignments Found!" + new Template().ANSI_RESET);
            } else {
                System.out.println("ASG INFO");
                for (int i = 0; i < lessonForCurrStudent.getAssignmentListSize(); i++) {
                    System.out.printf("   Assignment #%d: %d\n", i + 1, lessonForCurrStudent.getAssignmentListAt(i).score());
                }
            }
            System.out.println();
            if (lessonForCurrStudent.getTestListSize() == 0) {
                System.out.println(new Template().ANSI_RED + "No Tests Found!" + new Template().ANSI_RESET);
            } else {
                System.out.println("TEST INFO");
                for (int i = 0; i < lessonForCurrStudent.getTestListSize(); i++) {
                    System.out.printf("   Test #%d: %d\n", i + 1, lessonForCurrStudent.getTestListAt(i).score());
                }
            }

        }

        System.out.println("\nPress Enter to Continue...");
        scanner.nextLine();
    }

    private void viewAllFinalGrades(Student currActiveStudent) {
        new SystemRelated().SystemCls();

        if (currActiveStudent.getLessonArrayListSize() == 0) {
            System.out.println(new Template().ANSI_RED + "You Have No Active Lessons!" + new Template().ANSI_RESET);
        } else {
            System.out.println(new Template().ANSI_PURPLE + "[FINAL GRADES REPORT]" + new Template().ANSI_RESET);
            for (int i = 0; i < currActiveStudent.getLessonArrayListSize(); i++) {
                Lesson currLesson = currActiveStudent.getLessonArrayListAt(i);
                float totalAssignment = 0;
                float totalTest = 0;
                for (AssignmentInfo currAsg : currLesson.getAssignmentList()
                ) {
                    totalAssignment += (float) currAsg.score();
                }
                for (TestInfo currTst : currLesson.getTestList()
                ) {
                    totalTest += (float) currTst.score();
                }

                if (currLesson.getAssignmentListSize() == 0)
                    totalAssignment = 0;
                else
                    totalAssignment /= (float) currLesson.getAssignmentListSize();

                if (currLesson.getTestListSize() == 0)
                    totalTest = 0;
                else
                    totalTest /= (float) currLesson.getTestListSize();

                float finalRes = (float) ((0.6 * totalTest) + (0.4 * totalAssignment));
                System.out.printf("   %d. %s: %.2f\n", i + 1, currLesson.getName(), finalRes);
            }
        }

        System.out.println("Press Enter to Continue...");
        scanner.nextLine();
    }

    private void addLesson(Student currActiveStudent) {
        new SystemRelated().SystemCls();

        if (lessonArrayList.size() == 0) {
            System.out.println(new Template().ANSI_RED + "No Data!\nAsk Your Teacher to Provide Lessons!" + new Template().ANSI_RESET);

        } else {
            new Lesson(true).lessonViewList(lessonArrayList, false);

            System.out.printf("Which Lesson? [1-%d] -> ", lessonArrayList.size());
            int lessonIndex = new SystemRelated().chooseNumber(1, lessonArrayList.size()) - 1;

            new SystemRelated().SystemCls();

            new Teacher().teacherViewList(teacherArrayList, false);
            System.out.printf("Which Teacher? [1-%d] -> ", teacherArrayList.size());
            int teacherIndex = new SystemRelated().chooseNumber(1, teacherArrayList.size()) - 1;

            Lesson chosenLesson = lessonArrayList.get(lessonIndex);
            Teacher chosenTeacher = teacherArrayList.get(teacherIndex);

            Lesson newLesson = new Lesson(chosenLesson.getName(), chosenTeacher.getID());
            currActiveStudent.addLessonArrayList(newLesson);

            new SystemRelated().SystemCls();
            System.out.println(new Template().ANSI_GREEN + "Successfully Added!" + new Template().ANSI_RESET);
        }

        System.out.println("Press Enter to Continue...");
        scanner.nextLine();
    }

    private void loginAsStudent(ArrayList<Student> studentArrayList) {
        new SystemRelated().SystemCls();
        Scanner scanner = new Scanner(System.in);

        System.out.print(new Template().ANSI_PURPLE + "[LOG IN AS STUDENT]" + new Template().ANSI_RESET + "\nName? ");
        String name = scanner.nextLine();

        System.out.print("Password? ");
        String password = scanner.nextLine();

        Student currActiveStudent = new Student().logInForStudent(name, password, studentArrayList);
        new SystemRelated().SystemCls();
        if (currActiveStudent != null) {
            System.out.println(new Template().ANSI_GREEN + "Successfully Logged In!" + new Template().ANSI_RESET);
            System.out.println("Press Enter to Continue...");
            scanner.nextLine();

            studentMainMenu(currActiveStudent);
        } else {
            System.out.println(new Template().ANSI_RED + "No Such Account Found!" + new Template().ANSI_RESET);
            System.out.println("Press Enter to Continue...");
            scanner.nextLine();
        }


    }

    private void signupAsStudent(ArrayList<Student> studentArrayList) {
        Student currActiveStudent = new Student(studentArrayList);
        studentArrayList.add(currActiveStudent);

        studentMainMenu(currActiveStudent);
    }
}
