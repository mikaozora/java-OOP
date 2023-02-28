package Classes.Actors;

import Classes.Utilities.SystemRelated;
import Classes.Utilities.Template;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Teacher extends User {
    private Scanner scanner;

    public Teacher(ArrayList<Teacher> teacherArrayList) {
        scanner = new Scanner(System.in);

        new SystemRelated().SystemCls();
        System.out.println(new Template().ANSI_PURPLE + "[SIGN UP AS TEACHER]" + new Template().ANSI_RESET);
        setName();
        generateID(teacherArrayList.size());
        setPassword();

        System.out.println(new Template().ANSI_GREEN + "Successfully Created Account!" + new Template().ANSI_RESET);
        System.out.println("Press Enter to Continue...");
        scanner.nextLine();
    }

    public Teacher() {

    }

    public Teacher logInForTeacher(String name, String password, ArrayList<Teacher> teacherArrayList) {
        for (Teacher currTeacher : teacherArrayList) {
            if (name.compareTo(currTeacher.getName()) == 0) {
                return (password.compareTo(currTeacher.getPassword()) == 0) ? currTeacher : null;
            }
        }
        return null;
    }

    public void teacherViewList(ArrayList<Teacher> teacherArrayList, boolean showContinueStatus) {
        if (teacherArrayList.size() == 0) {
            System.out.println("No Teachers Yet!");
        } else {
            for (int i = 0; i < teacherArrayList.size(); i++) {
                String currTeacherName = teacherArrayList.get(i).getName();
                System.out.println(i + 1 + ". " + currTeacherName);
            }
        }

        if (showContinueStatus) {
            System.out.println(new Template().ANSI_GREEN + "Press Enter to Continue..." + new Template().ANSI_RESET);
            new Scanner(System.in).nextLine();
        }
    }

    @Override
    void generateID(int count) {
        this.ID = ("LEC" + this.getName().substring(0, 3) + String.format("%03d", count));
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
        System.out.print("School Secret Password? [XaveSch0608] -> ");
        String tmpPass2 = scanner.nextLine();
        if (!Pattern.matches(".{8,}", tmpPass) || tmpPass2.compareTo("XaveSch0608") != 0) {
            System.out.println(new Template().ANSI_RED + "Invalid!" + new Template().ANSI_RESET);
            setPassword();
            return;
        }

        this.password = tmpPass;
        new SystemRelated().SystemCls();
    }


}
