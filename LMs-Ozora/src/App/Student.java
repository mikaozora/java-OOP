package App;

import java.util.ArrayList;

public class Student extends User {
    String NISN;
    ArrayList<Subject> subjectId;
    ArrayList<Subject> subjectAvail;


    public Student(String username, String password, String name, String address, int age, String gender, String NISN) {
        super(username, password, name, address, age, gender);
        this.NISN = NISN;
        this.subjectId = new ArrayList<>();
        this.subjectAvail = new ArrayList<>();
    }

    Student() {

    }

    public void viewAll(ArrayList<Student> students) {
        int i = 1;
        System.out.println("===================================================================================================");
        System.out.printf("| %-2s | %-12s | %-10s | %-10s | %-20s | %-2s | %-20s |%n", "No", "NISN", "Username", "Name", "Address", "Age", "Subject");
        System.out.println("===================================================================================================");
        for (Student student : students) {
            System.out.printf("| %-2s | %-12s | %-10s | %-10s | %-20s | %-3d | %-20s |%n", i, student.getNISN(), student.getUsername(), student.getName(), student.getAddress(), student.getAge(), (student.getSubjectId().size() == 0 ? "-" : student.getSubjectId().get(0).getName()));
            i++;
        }
        System.out.println("===================================================================================================");
    }

    public void viewSubjectAvail(ArrayList<Subject> subjects) {
        int i = 1;
        if (subjects.size() == 0) {
            System.out.println("Subjects not found");
        } else {
            System.out.println("===========================");
            System.out.printf("| %-2s | %-18s |%n", "No", "Subject Name");
            System.out.println("===========================");
            for (Subject subject : subjects) {
                if (!subject.isStatus()) {
                    System.out.printf("| %-2d | %-18s |%n", i, subject.getName());
                    i++;
                }
            }
            System.out.println("===========================");
        }
    }

    public void viewSubjectStudent(ArrayList<Subject> subjects) {
        int i = 1;
        if (subjects.size() == 0) {
            System.out.println("Subjects not found");
        } else {
            System.out.println("===========================");
            System.out.printf("| %-2s | %-18s |%n", "No", "Subject Name");
            System.out.println("===========================");
            for (Subject subject : subjects) {
                System.out.printf("| %-2d | %-18s |%n", i, subject.getName());
                i++;

            }
            System.out.println("===========================");
        }
    }

    public void viewSubjectToStudent(ArrayList<Subject> subjects) {
        int i = 1;
        if (subjects.size() == 0) {
            System.out.println("Subjects not found");
        } else {
            System.out.println("===========================");
            System.out.printf("| %-2s | %-18s |%n", "No", "Subject Name");
            System.out.println("===========================");
            for (Subject subject : subjects) {
                System.out.printf("| %-2d | %-18s |%n", i, subject.getName());
                i++;

            }
            System.out.println("===========================");
        }
    }

    public String getNISN() {
        return NISN;
    }

    public void setNISN(String NISN) {
        this.NISN = NISN;
    }

    public ArrayList<Subject> getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(ArrayList<Subject> subjectId) {
        this.subjectId = subjectId;
    }

    public ArrayList<Subject> getSubjectAvail() {
        return subjectAvail;
    }

    public void setSubjectAvail(ArrayList<Subject> subjectAvail) {
        this.subjectAvail = subjectAvail;
    }

    public void addSubject(Subject subject){
        subjectId.add(subject);
        int index = subjectAvail.indexOf(subject);
        subjectAvail.remove(index);
    }

}
