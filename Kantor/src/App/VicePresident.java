package App;

public class VicePresident extends Employee implements IWork{
    private String diffVP;
    public VicePresident(String name, int age, String role, int salary, String diffVP) {
        super(name, age, role, salary);
        this.diffVP = diffVP;
    }

    public String getDiffVP() {
        return diffVP;
    }

    public void setDiffVP(String diffVP) {
        this.diffVP = diffVP;
    }

    @Override
    public void izin() {
        System.out.println("izin");
    }

    @Override
    public void alpha() {
        System.out.println("alpha");
    }

    @Override
    public void sakit() {
        System.out.println("sakit");
    }
}
