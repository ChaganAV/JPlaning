import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Line {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private int level;
    private String note;
    private LocalDate deadline;
    private Person autor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getLevel() {
        return level;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Person getAutor() {
        return autor;
    }

    public void setAutor(Person autor) {
        this.autor = autor;
    }
}
