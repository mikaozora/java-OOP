package App;

import java.util.ArrayList;

public class Admin extends User{
    public Admin(String username, String password, String name) {
        super(username, password, name);
    }
    public Admin(){
        super();
    }

    public Admin checkAdmin(String username,String password, ArrayList<Admin> admins){
        for(Admin admin : admins){
            if(admin.getUsername().equals(username) && admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }




}
