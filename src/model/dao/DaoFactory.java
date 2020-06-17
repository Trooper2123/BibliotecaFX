package model.dao;

import db.DB;
import model.dao.impl.BookDaoJDBC;
import model.dao.impl.SubjectDaoJDBC;



public class DaoFactory {
    public static BookDao creatBookDao() {
        return new BookDaoJDBC(DB.getConnection());
    }

    public static SubjectDao creatSubjectDao() {
        return new SubjectDaoJDBC(DB.getConnection());
    }
}