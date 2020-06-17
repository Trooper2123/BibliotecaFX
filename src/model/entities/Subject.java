package model.entities;

import java.io.Serializable;

public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;


    private static Integer id;
    private String name;

    public Subject(){
    }

    public Subject (Integer id, String name){
        Subject.id = id;
        this.name = name;
    }

    public static Integer getId(){
        return id;
    }

    public void setId(Integer id){
        Subject.id = id;
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
            Subject subject= (Subject) o;
            return getId().equals(subject.getId());
    }

    @Override
    public String toString() {
        return "Subject [id =" +id + ",name ="+ name+ "]";

    }
}
