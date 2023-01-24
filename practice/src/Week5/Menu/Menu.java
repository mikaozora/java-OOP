package Week5.Menu;


import Week5.Staff;
import Week5.roleStaff;

public class Menu {
    public static void main(String[] args) {
        Staff john = new Staff("john doe", "johndoe123", "johndoe@gmail.com", roleStaff.supervisor, 10000);
        john.login("johndoe@gmail.com", "johndoe123");
    }
}
