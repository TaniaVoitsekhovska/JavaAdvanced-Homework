package jdbs_homework.classes;


public class Book {

    private int id;
    private String book_title;
    private String description;
    private long isbn;
    private double book_price;
    private int category_id;

    public Book(int id, String book_title, String description, long isbn, double book_price,
                int category_id) {
        this.id = id;
        this.book_title = book_title;
        this.description = description;
        this.isbn = isbn;
        this.book_price = book_price;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_title='" + book_title + '\'' +
                ", description='" + description + '\'' +
                ", isbn=" + isbn +
                ", book_price=" + book_price +
                ", category_id=" + category_id +
                '}';
    }
}
