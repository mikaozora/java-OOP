package Week4;

public class Student {

    private String id;
    private String name;
    private String className;

    private int score;

    Student(String name, String className, int score){
        this.id = "" + ((long)(Math.random() * (2602199999L - 2602100000L + 1)) + 2602100000L);
        this.setName(name);
        this.className = className;
        this.score = score;
    }
    void study() {
        if (score + 10 < 100) {
            score += 10;
        } else {
            score = 100;
        }
    }

//    void show(Student student){
//        System.out.println("NIM: " + student.id);
//        System.out.println("Name: " + student.name);
//        System.out.println("class: " + student.className);
//        System.out.println("score: " + student.score);
//    }

    // or

    void show(){
        System.out.println("NIM: " + id);
        System.out.println("Name: " + name);
        System.out.println("class: " + className);
        System.out.println("score: " + score);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() > 20){
            throw new IllegalArgumentException("character length must less than equal 20");
        }
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    int getScore(){
        return score;
    }

    void setScore(int score){
        if(score > 100 || score < 0){
            throw new IllegalArgumentException("score must be in range 0 - 100");
        }
        this.score = score;
    }



    /** access modifier -> encapsulation
     *                      class   | package   | inheritance   | public
     * public               x       | x         |  x            | x
     * protected            x       | x         |  x            |
     * private              x       |           |               |
     * package/default      x       | x         |               |
     *
     * setter dan getter
     */


    public static void main(String[] args) {
        System.out.println("---------Student 1-------------");
        Student student1 = new Student("mika", "PPTI16", 80);
        System.out.println(student1.score);
        student1.study();
        student1.study();
        student1.show();
        System.out.println("---------Student 2-------------");
        Student student2 = new Student("gata", "PPTI15", 50);
        student2.show();
    }
}

class Test{
    public static void main(String[] args) {
        System.out.println("---------Student 3-------------");
        Student student3 = new Student("ozoraaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "PPTI14", 50);
        student3.setScore(101);
        student3.show();
    }
}
