package model.services;

import model.entities.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectService {
    public List<Subject> findAll() {
        List<Subject> list = new ArrayList<>();
        list.add(new Subject(1, "Classic"));
        list.add(new Subject(2, "Romance"));
        list.add(new Subject(3, "Historic"));
        return list;

    }
}
