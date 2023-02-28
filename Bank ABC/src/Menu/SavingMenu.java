package Menu;

import App.Nasabah;
import App.Rekening;
import App.Saving;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SavingMenu {
    private ArrayList<Nasabah> nasabahs;
    private ArrayList<Rekening> rekenings;
    private Scanner scan;
    private Nasabah nasabahLogged;

    public void mainMenu(ArrayList<Nasabah> nasabahs, ArrayList<Rekening> rekenings, Rekening rekeningLogged){
        this.nasabahs = nasabahs;
        this.rekenings = rekenings;
        this.scan = new Scanner(System.in);
        this.nasabahLogged = rekeningLogged.getNasabah();

        int choose = 0;
        String badInput = null;
        do{
            try{
                System.out.println("===== Saving Menu =====");
                System.out.println("1. View Saldo");
                System.out.println("2. Cash Save");
                System.out.println("3. Cash Withdrawal");
                System.out.println("4. Create New Rekening");
                System.out.println("5. View Report");
                System.out.println("6. Exit");
                System.out.print(">> ");
                choose = scan.nextInt();
                scan.nextLine();
                if(choose < 1 || choose > 6){
                    System.out.println("Please input a valid number");
                }
                badInput = null;
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
            switch (choose){
                case 1:
                    viewSaldo(rekeningLogged);
                    break;
                case 2:
                    cashSave(rekeningLogged);
                    break;
                case 3:
                    cashWithdrawal(rekeningLogged);
                    break;
                case 4:
                    createNewRekening(rekeningLogged);
                    break;
                case 5:
                    viewReport(rekeningLogged);
                    break;
                case 6:
                    new NasabahMenu().mainMenu(rekeningLogged, nasabahs,rekenings);
                    break;
                default:
                    break;
            }
        }while (badInput != null || choose != 6);
    }

    public void viewSaldo(Rekening rekeningLogged){
        DecimalFormat df = new DecimalFormat("#");
        System.out.println("Your Balance: " + df.format(rekeningLogged.getSaving().getBalance()));
    }

    public void cashSave(Rekening rekeningLogged){
        double balance = 0;
        double currBalance = rekeningLogged.getSaving().getBalance();
        String badInput = null;

        do{
            try{
                System.out.print("How much money do you want to save: ");
                balance = scan.nextDouble();
                scan.nextLine();
                if(balance < 1){
                    System.out.println("Required");
                }
                badInput = null;
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
        }while (badInput != null || balance < 1);
        balance += currBalance;
        rekeningLogged.getSaving().setBalance(balance);
        rekeningLogged.getSaving().getReport().getDebit().add(balance);
        if(!rekeningLogged.getSaving().isStatus()){
            rekeningLogged.getSaving().setStatus(true);
            rekeningLogged.getSaving().setDayLimit(10000000);
        }
        System.out.println("Successfully Save Your Money");
        System.out.print("Please enter...");
        scan.nextLine();
    }

    public void cashWithdrawal(Rekening rekeningLogged){
        String badInput = null;
        double balance = 0;
        double currBalance = rekeningLogged.getSaving().getBalance();
        double dayLimit = rekeningLogged.getSaving().getDayLimit();

        if(dayLimit <= 0){
            System.out.println("You have reached the maximum withdrawal limit per day!");
            System.out.println("Please enter...");
            scan.nextLine();
        }else{
            do{
                try{
                    System.out.print("How much money do you want to withdraw: ");
                    balance = scan.nextDouble();
                    scan.nextLine();
                    if(balance < 1){
                        System.out.println("Required");
                    }
                    else if(balance > currBalance){
                        System.out.println("You exceed the balance amount");
                    }
                    else if(dayLimit - balance < 0){
                        System.out.println("You have reached the maximum withdrawal limit per day");
                    }
                    badInput = null;
                }catch (InputMismatchException e){
                    badInput = scan.nextLine();
                    System.out.println("Please input a number");
                }
            }while (badInput != null || balance < 1 || balance > currBalance || dayLimit - balance < 0);
            dayLimit -= balance;
            currBalance -= balance;
            rekeningLogged.getSaving().setBalance(currBalance);
            rekeningLogged.getSaving().setDayLimit(dayLimit);
            rekeningLogged.getSaving().getReport().getCredit().add(balance);
//            System.out.println(rekeningLogged.getSaving().getDayLimit());
            System.out.println("Successfully withdraw");
            System.out.println("Please enter...");
            scan.nextLine();

        }
    }

    public void createNewRekening(Rekening rekeningLogged){
        double balance = 0;
        String badInput = null, pin = null;
        do {
            try {
                System.out.print("Balance [min 10.000]: ");
                balance = scan.nextDouble();
                scan.nextLine();
                if (balance < 10000) {
                    System.out.println("Minimum beginning balance is 10.000");
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
        } while (balance < 10000);
        do {
            System.out.print("PIN [6 digit]: ");
            pin = scan.nextLine();
            if (!pin.matches("\\d{6}")) {
                System.out.println("PIN must be 6 digit number");
            }
        } while (!pin.matches("\\d{6}"));

        Saving savingTemp = new Saving(balance);
        savingTemp.getReport().getDebit().add(balance);

        Rekening rekeningTemp = new Rekening(pin, nasabahLogged, savingTemp);
        nasabahLogged.getRekenings().add(rekeningTemp);

//        nasabahLogged.getRekenings().get(nasabahLogged.getRekenings().size()-1).viewRekeningDetails();
        rekenings.add(rekeningTemp);
        System.out.println("Successfully create new rekening");
        System.out.println("This is your new rekening number: " + rekeningTemp.getNoRekening());
        System.out.print("Please enter...");
        scan.nextLine();
    }

    public void viewReport(Rekening rekeningLogged){
        rekeningLogged.getSaving().getReport().viewMutasi();
    }
}
