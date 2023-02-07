package App;

import Menu.AdminMenu;
import Menu.StudentMenu;
import Menu.TeacherMenu;
import Menu.UserMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class School {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Admin> admins = new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Subject> subjects = new ArrayList<>();
    ArrayList<Evaluation> evaluations = new ArrayList<>();
    ArrayList<Report> reports = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Subject> subjectsAvail = new ArrayList<>();
    ArrayList<Subject> subjectAvailStudent = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    Admin admin = new Admin();
    Evaluation evaluation = new Evaluation();
    Report report = new Report();
    Student student = new Student();
    Subject subject = new Subject();
    Teacher teacher = new Teacher();
    User user = new User();

    //menu
    UserMenu userMenu = new UserMenu();
    StudentMenu studentMenu = new StudentMenu();
    TeacherMenu teacherMenu = new TeacherMenu();
    AdminMenu adminMenu = new AdminMenu();


    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Subject> getSubjectsAvail() {
        return subjectsAvail;
    }

    public ArrayList<Subject> getSubjectAvailStudent() {
        return subjectAvailStudent;
    }

    public void setSubjectAvailStudent(ArrayList<Subject> subjectAvailStudent) {
        this.subjectAvailStudent = subjectAvailStudent;
    }

    public void setSubjectsAvail(ArrayList<Subject> subjectsAvail) {
        this.subjectsAvail = subjectsAvail;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(ArrayList<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subjectsAvail.add(subject);
        subjectAvailStudent.add(subject);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        int index = subjects.indexOf(teacher.subjectId.get(teacher.subjectId.size()-1));
        int indexAvail = subjectsAvail.indexOf(teacher.subjectId.get(teacher.subjectId.size()-1));
        subjectsAvail.remove(indexAvail);
        subjects.get(index).setStatus(true);
    }

    public void addEvaluation(Evaluation evaluation) {
        evaluations.add(evaluation);
    }


    public void addReport(Report report) {
        reports.add(report);
    }

    public void addEnrollSubject(Subject subject, Student student){
        System.out.println(subject.getName());
        subject.getStudentId().add(student);
    }

    public void addStudentSubject(Student student, Subject subject){
        student.getSubjectId().add(subject);
        int index = student.getSubjectAvail().indexOf(subject);
        student.getSubjectAvail().remove(index);
        addEnrollSubject(subject, student);
    }


    public void getAllAdmin() {
        admin.viewAll(admins);
    }

    public void getAllSubject() {
        subject.viewAll(subjectsAvail);
    }
    public void getAllSubjectTask(School school, int index){
        subject.viewAllTask(school, index);
    }
    public void getAllSubjectToStudent(){
        subject.viewAllToStudent(subjects);
    }

    public void getAllStudent() {
        student.viewAll(students);
    }

    public void getAllTeacher() {
        teacher.viewAll(teachers);
    }

    public void getAllEvaluation() {
        evaluation.viewAll(evaluations);
    }

    public void getAllReport() {
        report.viewAll(reports);
    }

    public void getAllAvailSubject(Student student){
        student.viewSubjectToStudent(student.getSubjectAvail());
    }

    public void getSubjectStudent(Student student){
        student.viewSubjectStudent(student.getSubjectId());
    }

    public void getStudentBySubject(Subject subject){
        subject.viewStudent(subject.getStudentId());
    }


    public void loginMenu(School school) {
        User temp = userMenu.loginMenu(scan, students, teachers, admins);
        if (temp instanceof Admin) {
            System.out.println("admin login");
            adminMenu.adminMenu(scan, (Admin) temp, school);
        } else if (temp instanceof Student) {
            System.out.println("student login");
            studentMenu.studentMenu(scan, school, (Student) temp);
        } else if (temp instanceof Teacher) {
            System.out.println("teacher login");
            teacherMenu.teacherMenu(scan, school, (Teacher) temp);
        } else {
            return;
        }
    }
}
