package jdbs_homework.classes;

public class Library {

    private int id;
    private int book_id;
    private int author_id;

    public Library(int id, int book_id, int author_id) {
        this.id = id;
        this.book_id = book_id;
        this.author_id = author_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", book_id=" + book_id +
                ", author_id=" + author_id +
                '}';
    }
}
