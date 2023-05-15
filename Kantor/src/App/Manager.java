package App;

public class Manager extends Employee implements IWork, ISalary{
    private int diffManager;
    public Manager(String name, int age, String role, int salary, int diffManager) {
        super(name, age, role, salary);
        this.diffManager = diffManager;
    }

    public int getDiffManager() {
        return diffManager;
    }

    public void setDiffManager(int diffManager) {
        this.diffManager = diffManager;
    }

    @Override
    public void naikGaji(int salary) {
        this.setSalary(this.getSalary() + salary);
    }

    @Override
    public void resign() {
        System.out.println("resign");
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
