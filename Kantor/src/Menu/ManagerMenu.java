package Menu;

import App.Data;
import App.Manager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerMenu{
    private Data<Manager> managerData;
    private Scanner scan;
    public void menu(Data<Manager> managerData){
        this.managerData = managerData;
        this.scan = new Scanner(System.in);
        int n = 0;
        do{
            view();
            System.out.println("==Manager Menu==");
            System.out.println("1. add");
            System.out.println("2. update");
            System.out.println("3. delete");
            System.out.println("4. exit");
            try{
                System.out.print(">> ");
                n = scan.nextInt();
                scan.nextLine();
            }catch (InputMismatchException e){
                scan.nextLine();
            }
            switch (n){
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }while(n != 4);
    }

    public void add(){
        String name = null;
        int age = 0, salary = 0, diff = 0;
        System.out.println("==add manager==");
        System.out.print("name: ");
        name = scan.nextLine();
        System.out.print("Age: ");
        age = scan.nextInt(); scan.nextLine();
        System.out.print("Salary: ");
        salary = scan.nextInt(); scan.nextLine();
        managerData.push(new Manager(name, age, "manager", salary, diff));
    }
    public void view(){
        managerData.viewData();
    }

    public void update(){
        view();
        int choose = 0;
        do{
            System.out.print("choose data you want to update: ");
            try{
                choose = scan.nextInt(); scan.nextLine();
            }catch (InputMismatchException e){
                scan.nextLine();
            }
        }while (choose < 1 || choose > managerData.getData().size());
        String name = null;
        int age = 0, salary = 0, diff = 0;
        System.out.println("==update manager==");
        System.out.print("name: ");
        name = scan.nextLine();
        System.out.print("Age: ");
        age = scan.nextInt(); scan.nextLine();
        System.out.print("Salary: ");
        salary = scan.nextInt(); scan.nextLine();
        Manager manager = new Manager(name, age, "manager", salary, diff);
        managerData.update(choose-1, manager);
    }

    public void delete(){
        view();
        int choose = 0;
        do{
            System.out.print("choose data you want to delete: ");
            try{
                choose = scan.nextInt(); scan.nextLine();
            }catch (InputMismatchException e){
                scan.nextLine();
            }
        }while (choose < 1 || choose > managerData.getData().size());
        managerData.delete(choose-1);
    }
}
