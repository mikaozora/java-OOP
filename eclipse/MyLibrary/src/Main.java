import App.Admin;
import App.Database;
import App.Student;
import App.Teacher;
import Menu.UserMenu;

public class Main {
    public static void dummy(Database db){
        db.getAdmins().add(new Admin("admin", "admin"));
        Student student = new Student("mika", "mika");
        System.out.println(student.getNIM());
        db.getStudents().add(student);
        Teacher teacher = new Teacher("abdi", "abdi");
        System.out.println(teacher.getNIP());
        db.getTeachers().add(teacher);
    }
    public static void main(String[] args) {
        Database db = new Database();
        dummy(db);
        new UserMenu().startMenu(db);
    }
}