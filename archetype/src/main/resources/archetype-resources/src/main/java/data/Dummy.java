package ${package}.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dummy")
public class Dummy {

    private int id;
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dummy dummy = (Dummy) o;
        return Objects.equals(id, dummy.id) &&
            Objects.equals(title, dummy.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
