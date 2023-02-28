package App;

import java.util.ArrayList;

public class Admin extends User{
    private String id;

    private String NIL;

    public Admin(String name, String password) {
        super(name, password);
        this.id = generateId();
        this.NIL = "admin";
    }

    public Admin(){
        super();
    }

    @Override
    public String generateId()  {
        return "Std" + ((int) (Math.random() * (99999 - 10000 + 1)) + 10000);
    }

    public String getId() {
        return id;
    }

    public String getNIL() {
        return NIL;
    }

    public Admin checkAdmin(String no, String password, ArrayList<Admin> admins){
        for(Admin admin : admins){
            if(admin.getNIL().equals(no) && admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }
}
