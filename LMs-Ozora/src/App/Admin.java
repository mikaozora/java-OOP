package App;

import java.util.ArrayList;

public class Admin extends User{
    String adminId;


    Admin(String username, String password, String name, String address, int age, String gender, String adminId) {
        super(username, password, name, address, age, gender);
        this.adminId = adminId;
    }
    Admin(){
    }


    public void viewAll(ArrayList<Admin> admins){
        for(Admin admin : admins){
            System.out.println(admin.getUsername());
        }
    }


    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }


}
