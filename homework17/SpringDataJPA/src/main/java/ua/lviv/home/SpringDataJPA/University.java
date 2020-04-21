package ua.lviv.home.SpringDataJPA;

import javax.persistence.*;

@Entity
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "university_name", unique = true)
    private String name;
    @Column(name = "level_of_accreditation")
    private int levelOfAccreditation;
    @Column(name = "number_of_institutes")
    private int numberOfInstitutes;
    @Column(name = "amount_of_students")
    private int amountOfStudents;
    @Column(name = "address")
    private String address;

    public University() {
    }

    public University(String name, int levelOfAccreditation, int numberOfInstitutes, int amountOfStudents, String address) {
        this.name = name;
        this.levelOfAccreditation = levelOfAccreditation;
        this.numberOfInstitutes = numberOfInstitutes;
        this.amountOfStudents = amountOfStudents;
        this.address = address;
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

    public int getLevelOfAccreditation() {
        return levelOfAccreditation;
    }

    public void setLevelOfAccreditation(int levelOfAccreditation) {
        this.levelOfAccreditation = levelOfAccreditation;
    }

    public int getNumberOfInstitutes() {
        return numberOfInstitutes;
    }

    public void setNumberOfInstitutes(int numberOfInstitutes) {
        this.numberOfInstitutes = numberOfInstitutes;
    }

    public int getAmountOfStudents() {
        return amountOfStudents;
    }

    public void setAmountOfStudents(int amountOfStudents) {
        this.amountOfStudents = amountOfStudents;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", levelOfAccreditation=" + levelOfAccreditation +
                ", numberOfInstitutes=" + numberOfInstitutes +
                ", amountOfStudents=" + amountOfStudents +
                ", address='" + address + '\'' +
                '}';
    }
}
