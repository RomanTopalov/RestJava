package ua.dto;

/**
 * Created by -rom- on 27.05.2017.
 */
public class TaskManagerDTO {
    private int id;
    private String title;
    private String text;
    private String autor;

    public TaskManagerDTO() {
    }

    public TaskManagerDTO(int id, String title, String text, String autor) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.autor = autor;
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

    @Override
    public String toString() {
        return "TaskManagerDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
