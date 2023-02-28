package Classes.Actors;

public abstract class User {
    String name;
    String password;
    String ID;

    public User() {

    }

    abstract void generateID(int count);

    abstract void setName();

    abstract void setPassword();

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getID() {
        return ID;
    }
}
