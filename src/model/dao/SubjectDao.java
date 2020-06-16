package model.dao;

import model.entities.Subject;

import java.util.List;

public interface SubjectDao {
    void insert(Subject obj);
    void update(Subject obj);
    void deleteById(Integer id);
    Subject findById(Integer id);
    List<Subject> findAll();
}
