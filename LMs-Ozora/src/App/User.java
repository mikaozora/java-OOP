package App;

import java.util.ArrayList;

public class User {
    String username;
    String password;
    String name;
    String address;
    int age;
    String gender;

    public User(){

    }

    public User(String username, String password, String name, String address, int age, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }

    public void login(ArrayList<User> users){

    }

    public void dummyUser(ArrayList<User> users){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
