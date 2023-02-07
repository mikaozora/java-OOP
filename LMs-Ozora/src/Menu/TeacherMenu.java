package Menu;

import App.Evaluation;
import App.School;
import App.Teacher;
import Enum.EvalEnum;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TeacherMenu {

    public String generateId(){
        return "" + ((int)(Math.random() * (99999 - 10000 + 1)) + 10000);
    }
    public void addEval(Scanner scan, School school, Teacher teacherLogged){
        String name = null, badInput = null;
        int choose = 0;
        EvalEnum type = null;
        do{
            try{
                System.out.print("Name: ");
                name = scan.nextLine();
                if(name.length() <= 2){
                    System.out.println("Minimum character evaluation is 2");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }while(name.length() <= 2);
        do{
            try{
                System.out.println("====Type=====");
                System.out.println("| 1. Task   |");
                System.out.println("| 2. Exam   |");
                System.out.println("=============");
                System.out.print(">> ");
                choose = scan.nextInt();
                scan.nextLine();
                if(choose < 1 || choose > 2){
                    System.out.println("please input a valid number");
                }else if(choose == 1){
                    type = EvalEnum.Task;
                }else if(choose == 2){
                    type = EvalEnum.Exam;
                }
                badInput = null;
            }catch (InputMismatchException e){
                badInput = scan.nextLine();
                System.out.println("Please input a number");
            }
        }while(choose < 1 || choose > 2 || badInput != null);
        Evaluation temp = new Evaluation(generateId(), name, type);
        school.addEvaluation(temp);
        int indexSubject = school.getSubjects().indexOf(teacherLogged.getSubjectId().get(0));
        school.getSubjects().get(indexSubject).getEvaluations().add(temp);
        school.getAllEvaluation();
        school.getAllSubjectTask(school, indexSubject);

    }

    public void addReport(Scanner scan, School school, Teacher teacherLogged){
        int index = teacherLogged.getSubjectId().indexOf(teacherLogged.getSubjectId().get(0));
        school.getStudentBySubject(teacherLogged.getSubjectId().get(index));
    }
    public void teacherMenu(Scanner scan, School school, Teacher teacherLogged){
        int choose = 0;
        do{
            System.out.println("Welcome " + teacherLogged.getName());
            System.out.println("1. Add evaluation");
            System.out.println("2. Add Report");
            System.out.println("3. Logout");
            System.out.print(">> ");
            choose = scan.nextInt();
            scan.nextLine();
            switch (choose){
                case 1:
                    addEval(scan, school, teacherLogged);
                    break;
                case 2:
                    addReport(scan, school, teacherLogged);
                    break;
                case 3:
                    school.loginMenu(school);
                    break;
                default:
                    break;
            }
        }while (choose != 3);
    }
}
