package Classes.Studies;

import Classes.Utilities.Template;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lesson {
    private Scanner scanner;
    private String name;
    private String teacherRelatedID;
    private ArrayList<AssignmentInfo> assignmentList;
    private ArrayList<TestInfo> testList;

    public Lesson(boolean isNotCreateNewObject) {
        if (!isNotCreateNewObject)
            new Lesson();
    }

    public Lesson() {
        scanner = new Scanner(System.in);
        this.name = null;
        this.teacherRelatedID = null;
        assignmentList = new ArrayList<>();
        testList = new ArrayList<>();

        setName();
    }

    public Lesson(String name, String ID) {
        this.name = name;
        this.teacherRelatedID = ID;

        assignmentList = new ArrayList<>();
        testList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getTeacherRelatedID() {
        return teacherRelatedID;
    }

    public void addAssignmentList(AssignmentInfo assignmentInfo) {
        assignmentList.add(assignmentInfo);
    }
    public void addTestList(TestInfo testInfo) {
        testList.add(testInfo);
    }

    public int getAssignmentListSize() {
        return assignmentList.size();
    }
    public int getTestListSize() {
        return testList.size();
    }

    public AssignmentInfo getAssignmentListAt(int index) {
        return assignmentList.get(index);
    }
    public TestInfo getTestListAt(int index) {
        return testList.get(index);
    }

    public ArrayList<AssignmentInfo> getAssignmentList() {
        return assignmentList;
    }

    public ArrayList<TestInfo> getTestList() {
        return testList;
    }
    private void setName() {
        System.out.print("Lesson Name? [Pascal Case for first letter] [At Least 3 Characters] -> ");
        String tmpName = scanner.nextLine();
        if (!Pattern.matches("[A-Z][a-z A-Z]{2,}", tmpName)) {
            System.out.println(new Template().ANSI_RED + "Invalid!" + new Template().ANSI_RESET);
            setName();
            return;
        }

        this.name = tmpName;
    }

    public void lessonViewList(ArrayList<Lesson> lessonArrayList, boolean showContinueStatus) {
        if (lessonArrayList.size() == 0) {
            System.out.println(new Template().ANSI_RED + "No Lessons Yet!" + new Template().ANSI_RESET);
        } else {
            System.out.println(new Template().ANSI_PURPLE + "[AVAILABLE LESSON LIST]" + new Template().ANSI_RESET);
            for (int i = 0; i < lessonArrayList.size(); i++) {
                String currLessonName = lessonArrayList.get(i).name;
                System.out.println(i + 1 + ". " + currLessonName);
            }
        }

        if (showContinueStatus) {
            System.out.println("Press Enter to Continue...");
            new Scanner(System.in).nextLine();
        }
    }
}