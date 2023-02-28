package Menu;

import App.Deposit;
import App.Nasabah;
import App.Rekening;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DepositMenu {
    private ArrayList<Nasabah> nasabahs;
    private ArrayList<Rekening> rekenings;
    private Scanner scan;
    private Nasabah nasabahLogged;

    public void mainMenu(ArrayList<Nasabah> nasabahs, ArrayList<Rekening> rekenings, Rekening rekeningLogged) {
        this.nasabahs = nasabahs;
        this.rekenings = rekenings;
        this.nasabahLogged = rekeningLogged.getNasabah();
        this.scan = new Scanner(System.in);

        int choose = 0;
        String badInput = null;
        do {
            try {
                System.out.println("===== Deposit Menu =====");
                System.out.println("1. View Saldo");
                System.out.println("2. Cash Deposit");
                System.out.println("3. Deposit Withdrawal");
                System.out.println("4. Create New Deposit (Rekening)");
                System.out.println("5. View Report");
                System.out.println("6. Exit");
                System.out.print(">> ");
                choose = scan.nextInt();
                scan.nextLine();
                if (choose < 1 || choose > 6) {
                    System.out.println("Please input a valid number");
                }
                badInput = null;
            } catch (InputMismatchException e) {
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
            switch (choose) {
                case 1:
                    viewSaldo(rekeningLogged);
                    break;
                case 2:
                    cashDeposit(rekeningLogged);
                    break;
                case 3:
                    depositWithdraw(rekeningLogged);
                    break;
                case 4:
                    createNewDeposit(rekeningLogged);
                    break;
                case 5:
                    viewReport(rekeningLogged);
                    break;
                case 6:
                    new NasabahMenu().mainMenu(rekeningLogged, nasabahs, rekenings);
                    break;
                default:
                    break;
            }
        } while (badInput != null || choose != 6);
    }

    public void viewSaldo(Rekening rekeningLogged) {
        DecimalFormat df = new DecimalFormat("#");
        System.out.println("Your Deposit: " + df.format(rekeningLogged.getDeposit().getBalance()));
    }

    public void cashDeposit(Rekening rekeningLogged) {
        if (rekeningLogged.getDeposit().getBalance() == 0) {
            String badInput = null, pin = null;
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
                    System.out.println("==Time period & interest==");
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
            rekeningLogged.setDeposit(deposit);
        } else {
            System.out.println("You have made deposit");
            System.out.print("Please enter...");
            scan.nextLine();
        }
    }

    public void depositWithdraw(Rekening rekeningLogged) {
        String badInput = null, choose = null;
        boolean res;
        double penalty = 0;
        double currBalance = rekeningLogged.getDeposit().getBalance();
        LocalDate dueDate = rekeningLogged.getDeposit().getDueDate();
        LocalDate currDate = LocalDate.now();
//        LocalDate currDate = LocalDate.of(2023, 12, 10); //buat ngetes curr date melebihi due date
        long betweenDays = ChronoUnit.DAYS.between(currDate, dueDate);
        do {
            res = false;
            System.out.print("Are you sure want to withdraw your deposit? [yes or no]: ");
            choose = scan.nextLine();
            if (choose.equals("yes")) {
                res = true;
                if (betweenDays > 0) {
                    penalty = (currBalance * 0.01) + 50000;
                    currBalance -= penalty;
                    System.out.println("You get a penalty fee of " + penalty);
                }else{
                    currBalance += currBalance * ((rekeningLogged.getDeposit().getInterest()/100) * ((double) rekeningLogged.getDeposit().getPeriod()/12));
                }
                rekeningLogged.getDeposit().getReport().getCredit().add(currBalance);
                rekeningLogged.setDeposit(new Deposit(rekeningLogged.getDeposit().getReport()));
                System.out.println("The total balance withdraw: " + currBalance);
                System.out.println("Successfully withdraw deposit");
                System.out.print("Press enter...");
                scan.next();
            } else if (choose.equals("no")) {
                res = true;
            }
        } while (!res);
    }

    public void createNewDeposit(Rekening rekeningLogged) {
        String badInput = null, pin = null;
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
            System.out.print("PIN [6 digit]: ");
            pin = scan.nextLine();
            if (!pin.matches("\\d{6}")) {
                System.out.println("PIN must be 6 digit number");
            }
        } while (!pin.matches("\\d{6}"));

        do {
            try {
                System.out.println("==TIme period & interest==");
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
        Rekening rekeningTemp = new Rekening(pin, nasabahLogged, deposit);
        nasabahLogged.getRekenings().add(rekeningTemp);
        rekenings.add(rekeningTemp);

        System.out.println("This is your rekening number: " + rekeningTemp.getNoRekening());
        System.out.print("Please enter...");
        scan.nextLine();
    }

    public void viewReport(Rekening rekeningLogged) {
        rekeningLogged.getDeposit().getReport().viewMutasi();
    }
}
