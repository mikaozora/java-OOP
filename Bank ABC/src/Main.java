import App.Deposit;
import App.Nasabah;
import App.Rekening;
import App.Saving;
import Menu.UserMenu;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Main {

    private ArrayList<Nasabah> nasabahs;
    private ArrayList<Rekening> rekenings;

    public Main() {
        this.nasabahs = new ArrayList<>();
        this.rekenings = new ArrayList<>();
    }

    public void payInterest() {
        LocalDate currDate = LocalDate.now();
//        LocalDate currDate = LocalDate.of(2023, 3, 1); // buat ngetest setiap bulan berhasil memberi bunga atau tidak
        long betweenMonth, createdMonth, currMonth;
        for (Rekening rekening : rekenings) {
            if (rekening.getSaving().isStatus()) {
                double currBalance = rekening.getSaving().getBalance();
                createdMonth = rekening.getSaving().getCreatedAt().getMonthValue();
                currMonth = currDate.getMonthValue();
//                betweenMonth = ChronoUnit.MONTHS.between(rekening.getSaving().getCreatedAt(), currDate);
                betweenMonth = currMonth - createdMonth;
                System.out.println(betweenMonth);
                if (currDate.getDayOfMonth() == 1) {
                    currBalance += currBalance * ((2.5 / 100) / 12) * betweenMonth;
                    rekening.getSaving().setBalance(currBalance);
                }
            }
        }
    }

    public void startMenu() {
        // dummy
        Nasabah dummy1 = new Nasabah("mika", 20, "sentul");
        nasabahs.add(dummy1);
        Saving savingTemp = new Saving(100000000);
        savingTemp.getReport().getDebit().add(100000000.0);
        Rekening rekeningTemp = new Rekening("123456", dummy1, savingTemp);
        dummy1.getRekenings().add(rekeningTemp);
        rekenings.add(rekeningTemp);
        System.out.println(rekeningTemp.getNoRekening());

        Nasabah dummy2 = new Nasabah("abdi", 23, "sentul");
        nasabahs.add(dummy2);
        Deposit deposit = new Deposit(5000000, 6, 3.25);
        deposit.getReport().getDebit().add(5000000.0);
        Rekening rekeningTemp2 = new Rekening("123456", dummy2, deposit);
        dummy2.getRekenings().add(rekeningTemp);
        rekenings.add(rekeningTemp2);
        System.out.println(rekeningTemp2.getNoRekening());

        payInterest();
        new UserMenu().startMenu(nasabahs, rekenings);
    }

    public static void main(String[] args) {
        new Main().startMenu();
    }
}