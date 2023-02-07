package App;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.Vector;

public class Subject {
    String subjectId;
    String name;

    boolean status;
    ArrayList<Student> studentId;
    ArrayList<Evaluation> evaluations;

    public Subject(String subjectId, String name) {
        this.subjectId = subjectId;
        this.name = name;
        this.status = false;
        this.studentId = new ArrayList<>();
        this.evaluations = new ArrayList<>();
    }

    public Subject(ArrayList<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    Subject() {

    }


    public void viewAll(ArrayList<Subject> subjects) {
        int i = 1;
        if (subjects.size() == 0) {
            System.out.println("Subjects not found");
        } else {
            System.out.println("====================================");
            System.out.printf("| %-2s | %-18s | %-7s |%n", "No", "Subject Name", "Status");
            System.out.println("====================================");
            for (Subject subject : subjects) {
                if (!subject.isStatus()) {
                    System.out.printf("| %-2d | %-18s | %-7s |%n", i, subject.getName(), subject.isStatus());
                    i++;
                }
            }
            System.out.println("====================================");
        }

    }
    public void viewAllToStudent(ArrayList<Subject> subjects) {
        int i = 1;
        if (subjects.size() == 0) {
            System.out.println("Subjects not found");
        } else {
            System.out.println("====================================");
            System.out.printf("| %-2s | %-18s | %-7s |%n", "No", "Subject Name", "Status");
            System.out.println("====================================");
            for (Subject subject : subjects) {
                if (!subject.isStatus()) {
                    System.out.printf("| %-2d | %-18s | %-7s |%n", i, subject.getName(), subject.isStatus());
                    i++;
                }
            }
            System.out.println("====================================");
        }

    }

    public void viewAllTask(School school, int index) {
        int i = 1;
        if (school.getSubjects().size() == 0) {
            System.out.println("Please add a new subject");
        } else {
            System.out.println("===========================");
            System.out.printf("| %-2s | %-10s | %-5s |%n", "No", "Name", "Type");
            System.out.println("===========================");
            for (Evaluation evaluation : school.getSubjects().get(index).getEvaluations()) {
                System.out.printf("| %-2s | %-10s | %-5s |%n", i, evaluation.getName(), evaluation.getType());
                i++;
            }
            System.out.println("===========================");
        }

    }

    public void viewStudent(ArrayList<Student> students){
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

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Student> getStudentId() {
        return studentId;
    }

    public void setStudentId(ArrayList<Student> studentId) {
        this.studentId = studentId;
    }

    public ArrayList<Evaluation> getEvaluations() {
        return evaluations;
    }


    public void setEvaluations(ArrayList<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public void studentEnroll(Student student){
        studentId.add(student);
    }

    //    public ArrayList<Student> getStudentId() {
//        return studentId;
//    }

//    public void setStudentId(ArrayList<Student> studentId) {
//        this.studentId = studentId;
//    }
}
