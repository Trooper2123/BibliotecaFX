package model.services;

import model.dao.DaoFactory;
import model.dao.SubjectDao;
import model.entities.Subject;

import java.util.List;

public class SubjectService {

    private  SubjectDao dao = DaoFactory.creatSubjectDao();

    public List<Subject> findAll() {
        return dao.findAll();
    }
}
