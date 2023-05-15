package Menu;

import App.Data;
import App.Manager;
import App.VicePresident;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    private Scanner scan;
    public void menu(Data<Manager> managerData, Data<VicePresident> vpData){
        this.scan = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("==Welcome==");
            System.out.println("1. manager");
            System.out.println("2. vice president");
            System.out.println("3. exit");
            try{
                System.out.print(">> ");
                n = scan.nextInt();
                scan.nextLine();
            }catch (InputMismatchException e){
                scan.nextLine();
                System.out.println("Please input number");
            }
            switch (n){
                case 1:
                    new ManagerMenu().menu(managerData);
                    break;
                case 2:
                    new VpMenu().menu(vpData);
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }while(n != 3);

    }
}
