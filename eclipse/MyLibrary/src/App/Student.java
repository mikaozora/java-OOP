package App;

import java.util.ArrayList;

public class Student extends User{
    private String NIM;
    private ArrayList<Borrow> borrows;

    public Student(String name, String password) {
        super(name, password);
        this.NIM = generateId();
        this.borrows = new ArrayList<>();
    }

    public Student(){}

    public String getNIM() {
        return NIM;
    }

    public ArrayList<Borrow> getBorrows() {
        return borrows;
    }

    @Override
    public String generateId() {
        return "Std" + ((int) (Math.random() * (99999 - 10000 + 1)) + 10000);
    }

    public Student checkStudent(String no, String password, ArrayList<Student> students){
        for(Student student : students){
            if(student.getNIM().equals(no) && student.getPassword().equals(password)){
                return student;
            }
        }
        return null;
    }
}
