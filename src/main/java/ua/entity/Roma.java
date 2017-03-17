package ua.entity;

import javax.persistence.*;

/**
 * Created by -rom- on 17.03.2017.
 */

@Entity
public class Roma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String prof;
    private int number;

   /* @OneToOne

   */
   @OneToOne(optional=false)
   @JoinTable(name = "roma_human", joinColumns = @JoinColumn(name = "human_id"), inverseJoinColumns = @JoinColumn(name = "roma_id"))
   private Human human;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }


    public Roma() {
    }

    public Roma(int number) {
        this.number = number;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Roma{" +
                "prof='" + prof + '\'' +
                ", number=" + number +
                '}';
    }
}
