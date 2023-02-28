package App;

import java.time.LocalDate;

public class Borrow {
    private User user;
    private Student student;
    private Teacher teacher;
    private LocalDate dueDate;
    private Book book;

    public Borrow(User user, LocalDate dueDate, Book book) {
        if(user instanceof Student){
            this.student = (Student) user;
        }else{
            this.teacher = (Teacher) user;
        }
        this.dueDate = dueDate;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
