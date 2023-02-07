package App;

import java.util.ArrayList;

public class Teacher extends User{
    String NIP;
    int salary;
    ArrayList<Subject> subjectId;

    public Teacher(String username, String password, String name, String address, int age, String gender, String NIP, int salary, ArrayList<Subject> subjectId) {
        super(username, password, name, address, age, gender);
        this.NIP = NIP;
        this.salary = salary;
        this.subjectId = subjectId;
    }
    Teacher(){

    }

    public void viewAll(ArrayList<Teacher> teachers){
        int i = 1;
        System.out.println("===================================================================================================");
        System.out.printf("| %-2s | %-12s | %-10s | %-10s | %-20s | %-2s | %-20s |%n", "No", "NIP", "Username", "Name", "Address", "Age", "Subject");
        System.out.println("===================================================================================================");
        for(Teacher teacher : teachers){
            System.out.printf("| %-2s | %-12s | %-10s | %-10s | %-20s | %-3d | %-20s |%n", i, teacher.getNIP(), teacher.getUsername(), teacher.getName(), teacher.getAddress(), teacher.getAge(), teacher.getSubjectId().get(0).getName());
            i++;
        }
        System.out.println("===================================================================================================");
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public ArrayList<Subject> getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(ArrayList<Subject> subjectId) {
        this.subjectId = subjectId;
    }
}
