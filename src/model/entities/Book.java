package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer numpages;

    private Subject subject;

    public Book(){
    }

    public Book(Integer id, String name, Integer numpages, Subject subject){
        this.id =id;
        this.name = name;
        this.numpages = numpages;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
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

    public Integer getNumpages() {
        return numpages;
    }

    public void setNumpages(Integer numpages) {
        this.numpages = numpages;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId().equals(book.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", subject=" + subject + ", numpages=" + numpages + " ]";
    }

}
