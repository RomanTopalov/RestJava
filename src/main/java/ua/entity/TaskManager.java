package ua.entity;

import javax.persistence.*;

/**
 * Created by -rom- on 27.05.2017.
 */
@Entity
public class TaskManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String text;
    private String autor;

    @ManyToOne
    private User user;

    public TaskManager() {
    }

    public TaskManager(String title, String text, String autor, User user) {
        this.title = title;
        this.text = text;
        this.autor = autor;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TaskManager{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", autor='" + autor + '\'' +
                ", user=" + user +
                '}';
    }
}
