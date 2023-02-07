package App;

import java.util.ArrayList;

public class Report {
    String reportId;
    int score;
    Student student;
    String evalId;

    public Report(String reportId, int score, Student student, String evalId) {
        this.reportId = reportId;
        this.score = score;
        this.student = student;
        this.evalId = evalId;
    }
    Report(){

    }

    public void viewAll(ArrayList<Report> reports){
        for(Report report : reports){
            System.out.println(report.getScore());
        }
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getEvalId() {
        return evalId;
    }

    public void setEvalId(String evalId) {
        this.evalId = evalId;
    }
}
