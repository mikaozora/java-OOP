package Week5;

import java.util.zip.Adler32;

public class Main {
    public static void main(String[] args) {
        Staff budi = new Staff("Budi", "budi123", "budi@gmail.com", roleStaff.manager, 100000);
        boolean res = budi.login("budi@gmail.com", "budi123");
        if(res){
            System.out.println("Success login");
        }else{
            System.out.println("Wrong username or password");
        }
    }
}

class User{
    protected String name;
    protected String password;
    protected String email;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
    public boolean login(String email, String password){
        if(this.email.equals(email) && this.password.equals(password)){
            return true;
        }
        return false;
    }
}

class Customer extends User {
    private int point;
    private String membership;

    public Customer(String name, String password, String email, int point, String membership) {
        super(name, password, email);
        this.point = point;
        this.membership = membership;
    }
}
