package jdbs_homework.classes;

public class FullLibrary {

    private int id;
    private String bookName;
    private String authorName;
    private String authorSurname;
    private String authorEmail;
    private double bookPrice;

    public FullLibrary(int id, String bookName, String authorName, String authorSurname, String authorEmail, double bookPrice) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.authorEmail = authorEmail;
        this.bookPrice = bookPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "FullLibrary{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }
}
