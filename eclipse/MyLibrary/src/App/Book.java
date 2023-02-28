package App;

import java.util.ArrayList;

public class Book {
    private String name;
    private String id;
    private String type;
    private Boolean isGeneral;

    public Book(String name, String type, Boolean isGeneral) {
        this.name = name;
        this.id = generateId();
        this.type = type;
        this.isGeneral = isGeneral;
    }
    public Book(){}

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Boolean getGeneral() {
        return isGeneral;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGeneral(Boolean general) {
        isGeneral = general;
    }


    public String generateId(){
        return "" + ((int) (Math.random()*(99999 - 10000 + 1)) + 10000);
    }

    public void view(ArrayList<Book> books){
        if(books.size() == 0){
            System.out.println("No Books!");
            return;
        }
        for(Book book : books){
            System.out.println(book.getName());
        }
    }

    public void view(ArrayList<Book> books, boolean isGeneral){
        if(books.size() == 0){
            System.out.println("No books!");
            return;
        }
        for(Book book : books){
            if(book.getGeneral() == isGeneral){
                System.out.println(book.getName());
            }
        }
    }
}
