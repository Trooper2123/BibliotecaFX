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
        final int prime = 31;
        int result = 1;
        result = prime * result+ ((id ==null ? 0 : id.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Subject other = (Subject) obj;
        if (id == null) return true;
        else return id.equals(id);
    }

    @Override
    public String toString() {
        return "Subject [id =" +id + ",name ="+ name+ "]";

    }
}
