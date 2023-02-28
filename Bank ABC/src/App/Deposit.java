package App;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deposit {
    private double balance;
    private String idDeposit;
    private Report report;
    private int period;
    private double interest;
    private LocalDate dueDate;

    public Deposit(double balance, int period, double interest) {
        LocalDate currDate = LocalDate.now();
        this.balance = balance;
        this.period = period;
        this.interest = interest;
        this.idDeposit = generateId();
        this.report = new Report();
        this.dueDate = currDate.plusMonths(period);
    }
    public Deposit(Report report){
        this.balance = 0;
        this.report = report;
    }
    public Deposit(){
        this.balance = 0;
    }

    public String generateId(){
        return "DEPO" + ((long) (Math.random() * (99999999L - 10000000L + 1)) + 10000000L);
    }

    public void viewDeposit(){
        System.out.println(idDeposit);
        System.out.println(period);
        System.out.println(interest);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public double getInterest() {
        return interest;
    }

    public int getPeriod() {
        return period;
    }
}

