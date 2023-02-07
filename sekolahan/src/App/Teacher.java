package App;

import java.util.ArrayList;

public class Teacher extends User{
    private ArrayList<Subject> subjects;
    private ArrayList<Student> students;

    private String NIP;

    public Teacher(String username, String password, String name) {
        super(username, password, name);
        this.subjects = new ArrayList<>();
        this.students = new ArrayList<>();
        this.NIP = generateId();
    }
    public Teacher(){
        super();
        this.subjects = new ArrayList<>();
    }

    public String generateId(){
        return "tch" + ((int) (Math.random() * (99999 - 10000 + 1)) + 10000);
    }

    public Teacher checkTeacher(String username, String password, ArrayList<Teacher> teachers){
        for(Teacher teacher : teachers){
            if(teacher.getUsername().equals(username) && teacher.getPassword().equals(password)){
                return teacher;
            }
        }
        return null;
    }

    public boolean checkUsernameTeacher(String username, ArrayList<Teacher> teachers){
        for(Teacher teacher : teachers){
            if(teacher.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public void viewAll(ArrayList<Teacher> teachers){
        for (Teacher teacher : teachers){
            System.out.println(teacher.getName() +" " + teacher.getSubjects().size());
        }
    }

    public void viewAllStudent(){
        System.out.println(subjects.get(0).getName());
        subjects.get(0).viewAllStudent();
    }


    public void addSubjectTeacher(Subject subject){
        subjects.add(subject);
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public String getNIP() {
        return NIP;
    }
}
