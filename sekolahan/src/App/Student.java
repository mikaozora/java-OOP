package App;

import java.util.ArrayList;

public class Student extends User{
    private ArrayList<Subject> subjects;
    private String NISN;
    private ArrayList<Subject> subjectsAvail;

    private ArrayList<Subject> allSUbjects;
    private ArrayList<Task> tasks;
    private ArrayList<Exam> exams;


    public Student(String username, String password, String name, ArrayList<Subject> allSUbjects) {
        super(username, password, name);
        this.subjects = new ArrayList<>();
        this.subjectsAvail = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.exams = new ArrayList<>();
        this.allSUbjects = allSUbjects;
        this.NISN = generateId();
        subjectsAvail.addAll(allSUbjects);
    }

    public Student(){
        super();
    }

    public String generateId(){
        return "std" + ((int) (Math.random() * (99999 - 10000 + 1)) + 10000);
    }

    public Student checkStudent(String username, String password, ArrayList<Student> students){
        for(Student student : students){
            if(student.getUsername().equals(username) && student.getPassword().equals(password)){
                return student;
            }
        }
        return null;
    }

    public boolean checkUsernameStudent(String username, ArrayList<Student> students){
        for(Student student : students){
            if(student.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public void viewAll(ArrayList<Student> students){
        for(Student student : students){
            System.out.println(student.getName());
        }
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public void viewSubjectsAvail(){
        int i = 1;
        if (subjectsAvail.size() == 0) {
            System.out.println("No subject!");
        } else {
            System.out.println("============================");
            System.out.printf("| %-3s | %-15s |%n", "No", "Name");
            System.out.println("============================");
            for (Subject subject : subjectsAvail) {
                System.out.printf("| %-3d | %-15s |%n", i, subject.getName());
                i++;
            }
            System.out.println("============================");
        }
    }
    public void viewSubjects(){
        int i = 1;
        if (subjects.size() == 0) {
            System.out.println("No subject!");
        } else {
            System.out.println("============================");
            System.out.printf("| %-3s | %-15s |%n", "No", "Name");
            System.out.println("============================");
            for (Subject subject : subjects) {
                System.out.printf("| %-3d | %-15s |%n", i, subject.getName());
                i++;
            }
            System.out.println("============================");
        }
    }

    public ArrayList<Subject> getSubjectsAvail() {
        return subjectsAvail;
    }

    public void viewTask(){
        int i = 1;
        for(Task task : tasks){
            System.out.printf("Task %d: %d\n", i, task.getScore());
            i++;
        }
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void addExam(Exam exam){
        exams.add(exam);
    }


    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
