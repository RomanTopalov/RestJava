package ua.entity;


import javax.persistence.*;

/**
 * Created by -rom- on 13.02.2017.
 */
@Entity
public class Human {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;
    private String surname;
    private int number;
    private String pathImage;

   /* @OneToOne
    @JoinTable(name = "roma_human", joinColumns = @JoinColumn(name = "roma_id"), inverseJoinColumns = @JoinColumn(name = "human_id"))
  */
   @OneToOne(optional=false)
   @JoinTable(name = "roma_human", joinColumns = @JoinColumn(name = "roma_id"), inverseJoinColumns = @JoinColumn(name = "human_id"))
   private Roma roma;

    public Roma getRoma() {
        return roma;
    }

    public void setRoma(Roma roma) {
        this.roma = roma;
    }

    public Human() {

    }
    public Human(String name, String surname, int number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
