package model.entities;

import java.io.Serializable;

public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;
    private String name;

    public Subject() {
    }

    public Subject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return getId().equals(subject.getId());
    }

    @Override
    public String toString() {
        return "Subject [id =" + id + ",name =" + name + "]";

    }
}
