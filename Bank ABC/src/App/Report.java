package App;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Report {
    private ArrayList<Double> debit;
    private ArrayList<Double> credit;

    public Report(){
        this.debit = new ArrayList<>();
        this.credit = new ArrayList<>();
    }

    public ArrayList<Double> getDebit() {
        return debit;
    }

    public ArrayList<Double> getCredit() {
        return credit;
    }

    public void viewMutasi(){
        DecimalFormat df = new DecimalFormat("#");
        int no = 1;
        System.out.println("===== Debit =====");
        for(Double i : debit){
            System.out.printf("| %d. ", no);
            System.out.println(df.format(i) + " |");
        }
        no = 1;
        System.out.println("===== Credit =====");
        for(Double i : credit){
            System.out.printf("| %d. ", no);
            System.out.println(df.format(i) + " |");
        }
    }
}
