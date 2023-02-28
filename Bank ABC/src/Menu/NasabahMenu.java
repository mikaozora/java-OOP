package Menu;

import App.Nasabah;
import App.Rekening;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NasabahMenu {
    private ArrayList<Nasabah> nasabahs;
    private ArrayList<Rekening> rekenings;
    private Scanner scan;
    private Nasabah nasabahLogged;

    public void mainMenu(Rekening rekeningLogged, ArrayList<Nasabah> nasabahs, ArrayList<Rekening> rekenings){
        this.nasabahs = nasabahs;
        this.rekenings = rekenings;
        this.scan = new Scanner(System.in);
        this.nasabahLogged = rekeningLogged.getNasabah();

        System.out.println("Welcome " + rekeningLogged.getNasabah().getName());
        int choose = 0;
        String badInput = null;
        do{
            try{
                System.out.println("====== Main Menu =====");
                System.out.println("1. Saving");
                System.out.println("2. Deposit");
                System.out.println("3. Logout");
                System.out.print(">> ");
                choose = scan.nextInt();
                scan.nextLine();
                if (choose < 1 || choose > 3) {
                    System.out.println("Please input a valid number");
                }
                switch (choose){
                    case 1:
                        new SavingMenu().mainMenu(nasabahs, rekenings, rekeningLogged);
                        break;
                    case 2:
                        new DepositMenu().mainMenu(nasabahs, rekenings, rekeningLogged);
                        break;
                    case 3:
                        new UserMenu().startMenu(nasabahs, rekenings);
                        break;
                    default:
                        break;
                }
                badInput = null;
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
        }while(badInput != null || choose < 1 || choose > 3);

    }
}
