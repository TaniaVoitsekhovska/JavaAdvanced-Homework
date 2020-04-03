package jdbs_homework.classes;


import java.time.LocalDate;

public class Author {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String adress;
    private LocalDate birthday;

    public Author(int id, String name, String surname, String email, String adress, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.adress = adress;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Id : " + this.id + ", author : " + this.name + " " + this.surname + ", email: " + this.email
                + ", adress: " + this.adress + ", birthday; " + this.birthday;
    }
}
