package Classes.Actors;

import Classes.Studies.Lesson;
import Classes.Utilities.SystemRelated;
import Classes.Utilities.Template;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Student extends User {
    private ArrayList<Lesson> lessonArrayListCurrStudent;
    private Scanner scanner;

    public Student() {

    }

    public int getLessonArrayListSize() {
        return this.lessonArrayListCurrStudent.size();
    }

    public Lesson getLessonArrayListAt(int index) {
        return this.lessonArrayListCurrStudent.get(index);
    }

    public ArrayList<Lesson> getLessonArrayList() {
        return this.lessonArrayListCurrStudent;
    }

    public void addLessonArrayList(Lesson lesson) {
        this.lessonArrayListCurrStudent.add(lesson);
    }

    public Student(ArrayList<Student> studentArrayList) {
        lessonArrayListCurrStudent = new ArrayList<>();
        scanner = new Scanner(System.in);

        new SystemRelated().SystemCls();
        System.out.println(new Template().ANSI_PURPLE + "[SIGN UP AS STUDENT]" + new Template().ANSI_RESET);
        setName();
        generateID(studentArrayList.size());
        setPassword();

        new SystemRelated().SystemCls();

        System.out.println(new Template().ANSI_GREEN + "Successfully Created Account!" + new Template().ANSI_RESET);
        System.out.println("Press Enter to Continue...");
        scanner.nextLine();
    }

    public void studentViewList(ArrayList<Student> studentArrayList, boolean showContinueStatus) {
        if (studentArrayList.size() == 0) {
            System.out.println("No Students Yet!");
        } else {
            System.out.println(new Template().ANSI_PURPLE + "[AVAILABLE STUDENT LIST]" + new Template().ANSI_RESET);
            for (int i = 0; i < studentArrayList.size(); i++) {
                String currStudentName = studentArrayList.get(i).getName();
                System.out.println(i + 1 + ". " + currStudentName);
            }
        }

        if (showContinueStatus) {
            System.out.println(new Template().ANSI_GREEN + "Press Enter to Continue..." + new Template().ANSI_RESET);
            new Scanner(System.in).nextLine();
        }
    }


    public Student logInForStudent(String name, String password, ArrayList<Student> studentArrayList) {
        for (Student currStudent : studentArrayList) {
            if (name.compareTo(currStudent.getName()) == 0) {
                return (password.compareTo(currStudent.getPassword()) == 0) ? currStudent : null;
            }
        }
        return null;
    }

    @Override
    void generateID(int count) {
        this.ID = ("STU" + this.getName().substring(0, 3) + String.format("%03d", count));
    }

    @Override
    void setName() {
        System.out.print("Your Full Name? [Pascal Case for first letter (Ziven Ziven)] [At Least 3 Characters] -> ");
        String tmpName = scanner.nextLine();
        if (!Pattern.matches("(\\b[A-Z]{1}[a-z]+)( )([A-Z]{1}[a-z]+\\b)", tmpName)) {
            System.out.println(new Template().ANSI_RED + "Invalid!" + new Template().ANSI_RESET);
            setName();
            return;
        }

        this.name = tmpName;
    }

    @Override
    void setPassword() {

        System.out.print("Your Password? [min. 8 Characters] -> ");
        String tmpPass = scanner.nextLine();
        if (!Pattern.matches(".{8,}", tmpPass)) {
            System.out.println(new Template().ANSI_RED + "Invalid!" + new Template().ANSI_RESET);
            setPassword();
            return;
        }

        this.password = tmpPass;
        new SystemRelated().SystemCls();
    }
}
