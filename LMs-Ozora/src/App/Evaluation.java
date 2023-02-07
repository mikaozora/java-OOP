package App;
import Enum.EvalEnum;

import java.util.ArrayList;

public class Evaluation {
    String evalID;
    String name;
    EvalEnum type;
    ArrayList<Report> reports;

    public Evaluation(String evalID, String name, EvalEnum type) {
        this.evalID = evalID;
        this.name = name;
        this.type = type;
        this.reports = new ArrayList<>();
    }
    Evaluation(){

    }

    public void viewAll(ArrayList<Evaluation> evaluations){
        int i = 1;
        System.out.println("===========================");
        System.out.printf("| %-2s | %-10s | %-5s |%n", "No", "Name", "Type");
        System.out.println("===========================");
        for(Evaluation evaluation : evaluations){
            System.out.printf("| %-2s | %-10s | %-5s |%n", i, evaluation.getName(), evaluation.getType());
            i++;
        }
        System.out.println("===========================");
    }



    public String getEvalID() {
        return evalID;
    }


    public void setEvalID(String evalID) {
        this.evalID = evalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EvalEnum getType() {
        return type;
    }

    public void setType(EvalEnum type) {
        this.type = type;
    }
}
