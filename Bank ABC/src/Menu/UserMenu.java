package Menu;

import App.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class UserMenu {

    private ArrayList<Nasabah> nasabahs;
    private ArrayList<Rekening> rekenings;

    private Scanner scan;

    public void startMenu(ArrayList<Nasabah> nasabahs, ArrayList<Rekening> rekenings) {
        this.scan = new Scanner(System.in);
        this.nasabahs = nasabahs;
        this.rekenings = rekenings;

        String choice = null;
        boolean res;
        do {
            res = false;
            System.out.println("==== Welcome to Bank ABC ====");
            System.out.print("Do you have an account? [yes or no]: ");
            choice = scan.nextLine();
            if (choice.equals("yes")) {
                res = true;
                login();
            } else if (choice.equals("no")) {
                register();
                res = true;
            }
        } while (!res);
    }

    public void login() {
        String pin = null, norek = null;
        Rekening rekening = null;
        do{
            System.out.println("==== Login ====");
            System.out.print("No rekening: ");
            norek = scan.nextLine();
            System.out.print("Pin: ");
            pin = scan.nextLine();
            rekening = new Rekening().checkUser(norek, pin, rekenings);
            if(rekening == null){
                System.out.println("Wrong username or password!");
            }
        }while(rekening == null);
        new NasabahMenu().mainMenu(rekening, nasabahs, rekenings);
    }

    public void register() {
        String name = null, address = null, badInput = null, pin = null;
        int age = 0, choose = 0;
        Rekening rekeningLogged = null;
        System.out.println("====== Register ======");
        do {
            System.out.print("Name: ");
            name = scan.nextLine();
            if (name.length() < 1) {
                System.out.println("Name is required");
            }
        } while (name.length() < 1);
        do {
            try{
                System.out.print("Age: ");
                age = scan.nextInt();
                scan.nextLine();
                if (age < 18) {
                    System.out.println("Minimum age is 18 years old");
                }
                badInput = null;
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }

        } while (age < 18 || badInput != null);
        do {
            System.out.print("Address: ");
            address = scan.nextLine();
            if (address.length() < 1) {
                System.out.println("Address is required");
            }
        } while (address.length() < 1);
        do {
            System.out.print("PIN [6 digit]: ");
            pin = scan.nextLine();
            if (!pin.matches("\\d{6}")) {
                System.out.println("PIN must be 6 digit number");
            }
        } while (!pin.matches("\\d{6}"));
        Nasabah nasabahTemp = new Nasabah(name, age, address);
        nasabahs.add(nasabahTemp);

        do {
            try {
                System.out.println("====== Choose First Account =====");
                System.out.println("1. Saving");
                System.out.println("2. Deposit");
                System.out.print(">> ");
                choose = scan.nextInt();
                scan.nextLine();
                if (choose < 1 || choose > 2) {
                    System.out.println("Please input a valid number");
                }
                badInput = null;
                switch (choose) {
                    case 1:
                        rekeningLogged = firstSaving(nasabahTemp, pin);
                        break;
                    case 2:
                        rekeningLogged = firstDeposit(nasabahTemp, pin);
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
        } while (badInput != null || choose < 1 || choose > 2);
        new NasabahMenu().mainMenu(rekeningLogged, nasabahs, rekenings);
    }

    public Rekening firstSaving(Nasabah nasabahTemp, String pin) {
        double balance = 0;
        String badInput = null;
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

        Saving savingTemp = new Saving(balance);
        savingTemp.getReport().getDebit().add(balance);

        Rekening rekeningTemp = new Rekening(pin, nasabahTemp, savingTemp);
        nasabahTemp.getRekenings().add(rekeningTemp);

        rekenings.add(rekeningTemp);
        System.out.println("This is your rekening number: " + rekeningTemp.getNoRekening());
        return rekeningTemp;
//      nasabahTemp.getRekenings().get(0).viewRekeningDetails();
    }

    public Rekening firstDeposit(Nasabah nasabahTemp, String pin) {
        String badInput = null;
        double balance = 0;
        int period = 0;
        Deposit deposit = new Deposit();
        do {
            try {
                System.out.print("Balance [min 100.000]: ");
                balance = scan.nextDouble();
                scan.nextLine();
                if (balance < 100000) {
                    System.out.println("Minimum beginning balance is 100.000");
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
        } while (balance < 100000);

        do {
            try {
                System.out.println("===== Time period & interest =====");
                System.out.println("1. 3 Month with interest 3%");
                System.out.println("2. 6 month with interest 3.25%");
                System.out.println("3. 1 year with interest 3.5%");
                System.out.print(">> ");
                period = scan.nextInt();
                scan.nextLine();
                if (period < 1 || period > 3) {
                    System.out.println("Please input a valid number");
                }
                if (period == 1) {
                    deposit = new Deposit(balance, 3, 3);
                } else if (period == 2) {
                    deposit = new Deposit(balance, 6, 3.25);
                } else if (period == 3) {
                    deposit = new Deposit(balance, 12, 3.5);
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
        } while (badInput != null || period < 1 || period > 3);
        deposit.getReport().getDebit().add(balance);
        Rekening rekeningTemp = new Rekening(pin, nasabahTemp, deposit);
        nasabahTemp.getRekenings().add(rekeningTemp);
        rekenings.add(rekeningTemp);

        System.out.println("This is your rekening number: " + rekeningTemp.getNoRekening());
        return rekeningTemp;
//        nasabahTemp.getRekenings().get(0).getDeposit().viewDeposit();
    }
}
