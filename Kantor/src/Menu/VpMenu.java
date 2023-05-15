package Menu;

import App.Data;
import App.VicePresident;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VpMenu {
    private Data<VicePresident> vpData;
    private Scanner scan;
    public void menu(Data<VicePresident> vpData){
        this.vpData = vpData;
        this.scan = new Scanner(System.in);
        int n = 0;
        String tes = null;
        do{
            view();
            System.out.println("==Vice President Menu==");
            System.out.println("1. add");
            System.out.println("2. update");
            System.out.println("3. delete");
            System.out.println("4. search");
            System.out.println("5. update age");
            System.out.println("6. exit");
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
                    search();
                    break;
                case 5:
                    updateAge();
                default:
                    break;
            }
        }while(n != 6);
    }
    public void add(){
        String name = null, diff = "diff";
        int age = 0, salary = 0;
        System.out.println("==add manager==");
        System.out.print("name: ");
        name = scan.nextLine();
        System.out.print("Age: ");
        age = scan.nextInt(); scan.nextLine();
        System.out.print("Salary: ");
        salary = scan.nextInt(); scan.nextLine();
        vpData.push(new VicePresident(name, age, "vp", salary, diff));
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
        }while (choose < 1 || choose > vpData.getData().size());
        String name = null, diff = "diff";
        int age = 0, salary = 0;
        System.out.println("==update vp==");
        System.out.print("name: ");
        name = scan.nextLine();
        System.out.print("Age: ");
        age = scan.nextInt(); scan.nextLine();
        System.out.print("Salary: ");
        salary = scan.nextInt(); scan.nextLine();
        VicePresident vp = new VicePresident(name, age, "vp", salary, diff);
        vpData.update(choose-1, vp);
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
        }while (choose < 1 || choose > vpData.getData().size());
        vpData.delete(choose-1);
    }
    public void view(){
        vpData.viewData();
    }
    public void search(){
        String name = null;
        int salary = 0;
        System.out.print("Search name: ");
        name = scan.nextLine();
        VicePresident vp = null;
        vp = vpData.find(name);
        if(vp == null){
            System.out.println("Data not found");
        }else{
            System.out.println("Name: "+ vp.getName() + ", Salary: " + vp.getSalary());
            System.out.print("edit salary: ");
            salary = scan.nextInt(); scan.nextLine();
            vpData.updateSalary(salary, vp);
            System.out.print("Press enter to continue...");
            scan.nextLine();
        }
    }
    public void updateAge(){
        view();
        int choose = 0, age = 0;
        System.out.print("Choose data you want to update: ");
        choose = scan.nextInt(); scan.nextLine();
        System.out.print("edit age: ");
        age = scan.nextInt(); scan.nextLine();
        vpData.getData().get(choose-1).setAge(age);
    }
}
