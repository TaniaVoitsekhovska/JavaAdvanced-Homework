package ua.lviv.home.SpringWebHomework18.entities;

import javax.persistence.*;

@Entity
@Table(name = "participants")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String level;
    @Column(name = "primary_skill")
    private String primarySkill;
    @Column(name = "cover_id")
    private String coverId;

    public Participant() {
    }

    public Participant(String name, String email, String level, String primarySkill,String coverId) {
        this.name = name;
        this.email = email;
        this.level = level;
        this.primarySkill = primarySkill;
        this.coverId=coverId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public String getCoverId() {
        return coverId;
    }

    public void setCoverId(String coverId) {
        this.coverId = coverId;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", level='" + level + '\'' +
                ", primarySkill='" + primarySkill + '\'' +
                ", coverId='" + coverId + '\'' +
                '}';
    }
}
