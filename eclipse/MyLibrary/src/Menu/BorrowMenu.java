package Menu;

import App.*;

import javax.xml.stream.events.StartDocument;
import java.time.LocalDate;
import java.util.Scanner;

public class BorrowMenu {

    private User userLogged;
    private Student studentLogged;
    private Scanner scan;
    private Database db;
    public void mainMenu(Student student, Teacher teacher, Database db, Scanner scan){
        this.db = db;
        this.scan = scan;

        int choose = 0;

        if(student != null){
            this.userLogged = student;
            System.out.println("hello student");
            this.studentLogged = (Student) userLogged;
        }else if(teacher != null){
            System.out.println("hello ticer");
            this.userLogged = teacher;
        }

        do{
            System.out.println("Menu");
            System.out.println("1. View Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print(">> ");
            choose = scan.nextInt();
            scan.nextLine();
            switch (choose){
                case 1:
                    viewBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }while(choose != 4);
    }

    public void viewBook(){
        if(userLogged instanceof Student){
            new Book().view(db.getBooks(), true);
        }else{
            new Book().view(db.getBooks());
        }
    }

    public void borrowBook(){
        int choose = 0;
        viewBook();
        System.out.print("choose book you want to borrow: ");
        choose = scan.nextInt();
        scan.nextLine();
        LocalDate dueDate = LocalDate.now().plusDays(14);
        studentLogged.getBorrows().add(new Borrow(studentLogged, dueDate, db.getBooks().get(choose-1)));
        System.out.println(studentLogged.getBorrows().get(0).getDueDate());
        System.out.println(studentLogged.getBorrows().get(0).getBook().getName());
    }
}
