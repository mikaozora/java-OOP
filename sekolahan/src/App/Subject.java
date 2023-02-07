package App;

import java.util.ArrayList;

public class Subject {
    private String id;
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Task> tasks;
    private ArrayList<Exam> exams;
//    private boolean status;

    public Subject(String name) {
        this.id = generateId();
        this.name = name;
        this.students = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.exams = new ArrayList<>();

//        this.status = false;
    }

    public Subject() {
    }

    public String generateId() {
        return "Sbj" + ((int) (Math.random() * (99999 - 10000 + 1)) + 10000);
    }

    public void viewAll(ArrayList<Subject> subjects) {
        int i = 1;
        if (subjects.size() == 0) {
            System.out.println("No subject!");
        } else {
            System.out.println("============================");
            System.out.printf("| %-3s | %-15s |%n", "No", "Name");
            System.out.println("============================");
            for (Subject subject : subjects) {
                System.out.printf("| %-3d | %-15s |%n", i, subject.getName());
                i++;
            }
            System.out.println("============================");
        }

    }

    public void viewAllStudent() {
        int i = 1;
        if (students.size() == 0) {
            System.out.println("No Student!");
        } else {
            System.out.println("===============================");
            System.out.printf("| %-3s | %-15s |%n", "No", "Name");
            System.out.println("===============================");
            for (Student student : students) {
                System.out.printf("| %-3d | %-15s |%n", i, student.getName());
                i++;
            }
            System.out.println("===============================");
        }

    }

    public void addStudent(Student student) {
        students.add(student);
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void viewTask() {
        int i = 1;
        if (tasks.size() == 0) {
            System.out.println("No task score!");
        } else {
            System.out.println("=============================");
            System.out.printf("%-5s %s %5s%n", "", "Task Score", "");
            System.out.println("=============================");
            System.out.printf("| %-15s | %-6s |%n", "Name", "Score");
            System.out.println("=============================");
            for (Task task : tasks) {
                System.out.printf("| Task %-11d | %-6.2f |%n",  i,  task.getScore());
                i++;
            }
            System.out.println("=============================");
        }

    }

    public void viewExam() {
        int i = 1;
        if (exams.size() == 0) {
            System.out.println("No exam score!");
        } else {
            System.out.println("=============================");
            System.out.printf("%-5s %s %5s%n", "", "Exam Score", "");
            System.out.println("=============================");
            System.out.printf("| %-15s | %-6s |%n", "Name", "Score");
            System.out.println("=============================");
            for (Exam exam : exams) {
                System.out.printf("| Task %-11d | %-6.2f |%n", i,  exam.getScore());
                i++;
            }
            System.out.println("=============================");
        }
    }

    public void viewFinalScore() {
        double scoreTask = 0, scoreExam = 0, scoreFinal = 0;
        if (exams.size() != 0 && tasks.size() != 0) {
            for (Task task : tasks) {
                scoreTask += task.getScore();
            }
            scoreTask /= 3;
            for (Exam exam : exams) {
                scoreExam += exam.getScore();
            }
            scoreExam /= 2;
            scoreFinal = (scoreTask * 0.4) + (scoreExam * 0.6);
            System.out.printf("Final Score: %-2f%n", scoreFinal);
            System.out.println("=============================");
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }
}
