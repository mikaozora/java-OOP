package App;

public abstract class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User(){}

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public abstract String generateId();
}
