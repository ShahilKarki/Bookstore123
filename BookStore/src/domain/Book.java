package domain;

public class Book {
    public Book() {
    }

    public Book(String id, String name, String author, String isbn, String price, String purchased_date, String category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.purchased_date = purchased_date;
        this.category = category;
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
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPurchased_date() {
        return purchased_date;
    }

    public void setPurchased_date(String purchased_date) {
        this.purchased_date = purchased_date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private  String id;
    private  String name;
    private  String author;
    private  String isbn;
    private  String price;
    private  String purchased_date;
    private  String category;

}
