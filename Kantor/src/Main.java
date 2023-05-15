import App.Data;
import App.Employee;
import App.Manager;
import App.VicePresident;
import Menu.MainMenu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private Data<Manager> managerData;
    private Data<VicePresident> vpData;
    public static void initClasses(){
//        ArrayList<Data<? extends Employee>> database = new ArrayList<>();
//        database.add(new Data<>(managers));
//        database.add(new Data<>(vicePresidents));
//        database.get(0).push(new Manager("jason", 20, "manager", 300000, 3));
//        database.get(0).viewData();
//        database.get(1).viewData();
    }
    public Main(){
        ArrayList<Manager> managers = new ArrayList<>();
        this.managerData = new Data<>(managers);
        ArrayList<VicePresident> vicePresidents = new ArrayList<>();
        this.vpData = new Data<>(vicePresidents);
    }
    public void startMenu(){
        managerData.push(new Manager("mika", 20, "manager", 10000, 1));
        vpData.push(new VicePresident("yoga", 40, "vp", 500000, "3"));
        vpData.push(new VicePresident("abdi", 30, "vp", 123456, "3"));
        new MainMenu().menu(managerData, vpData);
    }
    public static void main(String[] args) {
        new Main().startMenu();
    }
}