package Menu;

import App.Admin;
import App.Book;
import App.Database;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu {

    private ArrayList<Book> books;
    private Scanner scan;
    public void mainMenu(Database db, Scanner scan){
        this.books = db.getBooks();
        this.scan = scan;

        int choose = 0;
        String badInput = null;
        System.out.println("Hello admin");
        do{
            try{
                System.out.println("Menu");
                System.out.println("1. View Book");
                System.out.println("2. Add book");
                System.out.println("3. update book");
                System.out.println("4. delete book");
                System.out.println("5. Exit");
                System.out.print(">> ");
                choose = scan.nextInt();
                scan.nextLine();
                if(choose < 1 || choose > 5){
                    System.out.println("input a valid number");
                }
                switch (choose){
                    case 1:
                        viewBook();
                        break;
                    case 2:
                        addBook();
                        break;
                    case 3:
                        updateBook();
                        break;
                    case 4:
                        deleteBook();
                        break;
                    case 5:
                        new UserMenu().startMenu(db);
                        break;
                    default:
                        break;
                }
                badInput = null;
            }catch (Exception e){
                badInput = scan.nextLine();
                System.out.println("please input a number");
            }
        }while(badInput != null || choose != 5);
    }

    public void viewBook(){
        new Book().view(books);
    }

    public void addBook(){
        String name = null, type = null, general = null;
        int chooseType = 0;
        boolean isGeneral = true;
        do {
            System.out.println("name: ");
            name = scan.nextLine();
        }while(name.length() < 1);
        do{
            System.out.println("choose type");
            System.out.println("1. Social");
            System.out.println("2. Language");
            System.out.println("3. Science");
            System.out.print(">> ");
            chooseType = scan.nextInt();
            scan.nextLine();
            if(chooseType == 1){
                type = "Social";
            }else if(chooseType == 2){
                type = "Language";
            }else{
                type = "Science";
            }
        }while(chooseType < 1 || chooseType > 3);
        do{
            System.out.print("For general? [yes | no]: ");
            general = scan.nextLine();
            if(general.equals("yes")){
                isGeneral = true;
            }else if(general.equals("no")){
                isGeneral = false;
            }
        }while(!general.equals("yes") && !general.equals("no"));
        books.add(new Book(name, type, isGeneral));
    }

    public void updateBook(){
        String name = null, type = null, general = null;
        int chooseType = 0, choose = 0;
        boolean isGeneral = true;

        viewBook();
        do{
            System.out.println("choose data you want to update");
            choose = scan.nextInt();
            scan.nextLine();
        }while(choose < 1 || choose > books.size());
        do {
            System.out.println("name: ");
            name = scan.nextLine();
        }while(name.length() < 1);
        do{
            System.out.println("choose type");
            System.out.println("1. Social");
            System.out.println("2. Language");
            System.out.println("3. Science");
            System.out.print(">> ");
            chooseType = scan.nextInt();
            scan.nextLine();
            if(chooseType == 1){
                type = "Social";
            }else if(chooseType == 2){
                type = "Language";
            }else{
                type = "Science";
            }
        }while(chooseType < 1 || chooseType > 3);
        do{
            System.out.print("For general? [yes | no]: ");
            general = scan.nextLine();
            if(general.equals("yes")){
                isGeneral = true;
            }else if(general.equals("no")){
                isGeneral = false;
            }
        }while(!general.equals("yes") && !general.equals("no"));
        books.get(choose-1).setName(name);
        books.get(choose-1).setGeneral(isGeneral);
        books.get(choose-1).setType(type);
    }

    public void deleteBook(){
        int choose = 0;
        viewBook();
        System.out.printf("Choose data you want to delete: ");
        choose = scan.nextInt();
        scan.nextLine();
        books.remove(choose-1);
    }
}
