package Menu;

import App.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenu {
//    School school = new School();
    public String generateId(){
        return "" + ((int)(Math.random() * (99999 - 10000 + 1)) + 10000);
    }
    public boolean checkAdminUsername(String username, ArrayList<Admin> admins){
        for(Admin admin : admins){
            if(admin.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public boolean checkStudentUsername(String username, ArrayList<Student> students){
        for(Student student : students){
            if(student.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public boolean checkTeacherUsername(String username, ArrayList<Teacher> teachers){
        for(Teacher teacher : teachers){
            if(teacher.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkGender(String str){
        String []arr = {"Male", "Female"};
        for (int i = 0; i < arr.length; i++) {
            if(str.contains(arr[i])){
                return true;
            }
        }
        return false;
    }
    public void addSubject(Scanner scan, School school){
        String name = null;
        do{
            try{
                System.out.print("Input Subject Name: ");
                name = scan.nextLine();
                if(name.length() > 20 || name.length() < 3){
                    System.out.println("Character must be between 3 to 20");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(name.length() > 20 || name.length() < 3);
        school.addSubject(new Subject(generateId(), name));
//        school.getAllSubject();
    }

    public void addteacher(Scanner scan, School school){
        String username = null, password = null, name = null, address = null, badInput = null, gender = null;
        int age = 0, salary = 0, choose = 0;
        do{
            try{
                System.out.print("Username: ");
                username = scan.nextLine();
                if(checkAdminUsername(username, school.getAdmins())){
                    System.out.println("Username Already Exist");
                }else if(checkStudentUsername(username, school.getStudents())){
                    System.out.println("Username Already Exist");
                }else if(checkTeacherUsername(username, school.getTeachers())){
                    System.out.println("Username Already Exist");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(checkAdminUsername(username, school.getAdmins()) || checkStudentUsername(username, school.getStudents()) || checkTeacherUsername(username, school.getTeachers()));
        do{
            try{
                System.out.print("Password: ");
                password = scan.nextLine();
                if(password.length() < 8){
                    System.out.println("Please input password 8 Character length");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(password.length() < 8);
        do{
            try{
                System.out.print("Name: ");
                name = scan.nextLine();
                if(name.length() < 1){
                    System.out.println("Please input name");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(name.length() < 1);
        do{
            try{
                System.out.print("Address: ");
                address = scan.nextLine();
                if(address.length() <= 10){
                    System.out.println("Minimum address length is 10 character");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(address.length() <= 10);
        do{
            try{
                System.out.print("Gender: ");
                gender = scan.nextLine();
                if(!checkGender(gender)){
                    System.out.println("Please input a valid gender [Male/Female]");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while (!checkGender(gender));
        do{
            try{
                System.out.print("Age: ");
                age = scan.nextInt();
                scan.nextLine();
                badInput = null;
                if(age < 20 || age > 50){
                    System.out.println("Teacher age must be between 20 to 50");
                }
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
        }while (badInput != null || age < 20 || age > 50);
        do{
            try{
                System.out.print("Salary: ");
                salary = scan.nextInt();
                scan.nextLine();
                badInput = null;
                if(salary < 50000){
                    System.out.println("Teacher salary minimum is 50000");
                }
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
        }while (badInput != null || salary < 50000);
        school.getAllSubject();
        do{
            try{
                System.out.print("Choose Subject: ");
                choose = scan.nextInt();
                scan.nextLine();
                badInput = null;
                if(choose <= 0 || choose > school.getSubjects().size()){
                    System.out.println("Please input a valid number");
                }
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
        }while(choose <= 0 || choose > school.getSubjects().size());
        ArrayList<Subject> temp = new ArrayList<>();
        temp.add(school.getSubjectsAvail().get(choose-1));
        school.addTeacher(new Teacher(username, password, name, address, age, gender, generateId(), salary, temp));
        school.getAllTeacher();
    }

    public void addStudent(Scanner scan, School school){
        String username = null, password = null, name = null, address = null, badInput = null, gender = null;
        int age = 0, choose = 0;
        do{
            try{
                System.out.print("Username: ");
                username = scan.nextLine();
                if(checkAdminUsername(username, school.getAdmins())){
                    System.out.println("Username Already Exist");
                }else if(checkStudentUsername(username, school.getStudents())){
                    System.out.println("Username Already Exist");
                }else if(checkTeacherUsername(username, school.getTeachers())){
                    System.out.println("Username Already Exist");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(checkAdminUsername(username, school.getAdmins()) || checkStudentUsername(username, school.getStudents()) || checkTeacherUsername(username, school.getTeachers()));
        do{
            try{
                System.out.print("Password: ");
                password = scan.nextLine();
                if(password.length() < 8){
                    System.out.println("Please input password 8 Character length");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(password.length() < 8);
        do{
            try{
                System.out.print("Name: ");
                name = scan.nextLine();
                if(name.length() < 1){
                    System.out.println("Please input name");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(name.length() < 1);
        do{
            try{
                System.out.print("Address: ");
                address = scan.nextLine();
                if(address.length() <= 10){
                    System.out.println("Minimum address length is 10 character");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(address.length() <= 10);
        do{
            try{
                System.out.print("Gender: ");
                gender = scan.nextLine();
                if(!checkGender(gender)){
                    System.out.println("Please input a valid gender [Male/Female]");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while (!checkGender(gender));
        do{
            try{
                System.out.print("Age: ");
                age = scan.nextInt();
                scan.nextLine();
                badInput = null;
                if(age < 20 || age > 50){
                    System.out.println("Teacher age must be between 20 to 50");
                }
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
        }while (badInput != null || age < 20 || age > 50);
        school.addStudent(new Student(username, password, name, address, age, gender, generateId()));
        school.getAllStudent();
    }
    public void adminMenu(Scanner scan, Admin adminLogged, School school){
        int choose = 0;
        do{
            System.out.println("Welcome " + adminLogged.getName());
            System.out.println("1. Add Subject");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Student");
            System.out.println("4. Logout");
            System.out.print(">> ");
            choose = scan.nextInt();
            scan.nextLine();
            switch (choose){
                case 1:
                    addSubject(scan, school);
                    break;
                case 2:
                    addteacher(scan, school);
                    break;
                case 3:
                    addStudent(scan, school);
                    break;
                case 4:
                    school.loginMenu(school);
                default:
                    break;
            }
        }while (choose != 4);

    }
}
