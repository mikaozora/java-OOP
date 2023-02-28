package App;

import java.util.ArrayList;

public class Nasabah extends User{

    private String name;
    private String Id;
    private int age;
    private String address;
    private ArrayList<Rekening> rekenings;

    public Nasabah(String name, int age, String address) {
        super();
        this.rekenings = new ArrayList<>();
        this.name = name;
        this.age = age;
        this.address = address;
        this.Id = generateId();
    }

    @Override
    String generateId() {
        return "NAS" + ((long) (Math.random() * (99999999L - 10000000L + 1)) + 10000000L);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }


    public ArrayList<Rekening> getRekenings() {
        return rekenings;
    }
}
