package App;

import java.time.LocalDate;
import java.util.ArrayList;

public class Saving {

    private double balance;
    private double dayLimit;
    private Report report;
    private LocalDate createdAt;
    private boolean status;

    public Saving(double balance) {
        this.balance = balance;
        this.report = new Report();
        this.dayLimit = 10000000;
        this.createdAt = LocalDate.now();
        this.status = true;
    }
    public Saving(){
        this.status = false;
    }

    public double getBalance() {
        return balance;
    }

    public Report getReport() {
        return report;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDayLimit() {
        return dayLimit;
    }

    public void setDayLimit(double dayLimit) {
        this.dayLimit = dayLimit;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
