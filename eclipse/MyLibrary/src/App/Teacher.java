package App;

import java.util.ArrayList;

public class Teacher extends User{
    private String NIP;
    ArrayList<Borrow> borrows;

    public Teacher(String name, String password) {
        super(name, password);
        this.NIP = generateId();
        this.borrows = new ArrayList<>();
    }

    public Teacher(){}
    public String generateId(){
        return "Tch" + ((int) (Math.random() * (99999 - 10000 + 1)) + 10000);
    }

    public String getNIP() {
        return NIP;
    }

    public ArrayList<Borrow> getBorrows() {
        return borrows;
    }

    public Teacher checkTeacher(String no, String password, ArrayList<Teacher> teachers){
        for(Teacher teacher : teachers){
            if(teacher.getNIP().equals(no) && teacher.getPassword().equals(password)){
                return teacher;
            }
        }
        return null;
    }
}
