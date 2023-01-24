package Week5;

public class Staff extends User {

    protected roleStaff role;
    protected int salary;

    public Staff(String name, String password, String email, roleStaff role, int salary) {
        super(name, password, email);
        this.role = role;
        this.salary = salary;
    }
}
