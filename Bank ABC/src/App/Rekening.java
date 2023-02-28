package App;

import java.util.ArrayList;

public class Rekening {
    private String noRekening;
    private String pin;

    private Nasabah nasabah;
    private Saving saving;
    private Deposit deposit;

    public Rekening(String pin, Nasabah nasabah, Saving saving) {
        this.noRekening = generateRekening();
        this.pin = pin;
        this.nasabah = nasabah;
        this.saving = saving;
        this.deposit = new Deposit();
    }
    public Rekening(String pin, Nasabah nasabah, Deposit deposit) {
        this.noRekening = generateRekening();
        this.pin = pin;
        this.nasabah = nasabah;
        this.deposit = deposit;
        this.saving = new Saving();
    }

    public Rekening(){}

    public String generateRekening(){
        return "" + ((long) (Math.random() * (9999999999L - 1000000000L + 1)) + 1000000000L);
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Nasabah getNasabah() {
        return nasabah;
    }

    public Saving getSaving() {
        return saving;
    }

    public void setSaving(Saving saving) {
        this.saving = saving;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public void viewRekeningDetails(){
        System.out.println(noRekening);
        System.out.println(pin);
        System.out.println(nasabah.getName());
        System.out.println(saving.getBalance());
    }

    public Rekening checkUser(String norek, String pin, ArrayList<Rekening> rekenings){
        for(Rekening rekening : rekenings){
            if(rekening.getNoRekening().equals(norek) && rekening.getPin().equals(pin)){
                return rekening;
            }
        }
        return null;
    }


}
