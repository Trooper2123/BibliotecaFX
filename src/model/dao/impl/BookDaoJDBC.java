package model.dao.impl;



import db.DB;
import db.DbException;
import model.dao.BookDao;
import model.entities.Book;
import model.entities.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDaoJDBC implements BookDao {


    private final Connection conn;

    public BookDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Book obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO book "
                            + "(name, subject, numpages) "
                            + "VALUES "
                            + "(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            st.setInt(2, obj.getNumpages());
            st.setInt(3, obj.getSubject().getId());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }
            else {new DbException("Unexpected error! No rows affected!");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }


    @Override
    public void update(Book obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE book "
                            + "SET name = ?,subject = ?, numpages = ? "
                            + "WHERE id = ?");

            st.setString(1, obj.getName());
            st.setInt(2, obj.getNumpages());
            st.setInt(3, obj.getSubject().getId());

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM book WHERE Id = ?");

            st.setInt(1, id);

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Book findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT book.*,subject.name as SujName "
                            + "FROM book INNER JOIN subject "
                            + "ON book.subject = subject.id "
                            + "WHERE book.id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Subject subj = instantiateSubject(rs);
                Book obj = instantiateBook(rs, subj);
                return obj;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Book instantiateBook(ResultSet rs, Subject subj) throws SQLException {
        Book obj = new Book();
        obj.setId(rs.getInt("id"));
        obj.setName(rs.getString("name"));
        obj.setNumpages(rs.getInt("numpages"));
        obj.setSubject(subj);
        return obj;
    }

    private Subject instantiateSubject(ResultSet rs) throws SQLException {
        Subject subj = new Subject();
        subj.setId(rs.getInt("id"));
        subj.setName(rs.getString("name"));
        return subj;
    }

    @Override
    public List<Book> findAll () {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT book.*,subject.name as SubjName "
                            + "FROM book INNER JOIN subject "
                            + "ON book.subject = subject.id "
                            + "ORDER BY Name");

            rs = st.executeQuery();

            List<Book> list = new ArrayList<>();
            Map<Integer, Subject> map = new HashMap<>();

            while (rs.next()) {

                Subject subj = map.get(rs.getInt("subject"));

                if (subj == null) {
                    subj = instantiateSubject(rs);
                    map.put(rs.getInt("subject"),subj);
                }

                Book obj = instantiateBook(rs, subj);
                list.add(obj);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Book> findBySubject(Subject subj) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT book.*,subject.name as SubjName "
                            + "FROM book INNER JOIN subject "
                            + "ON book.subject = subject.id "
                            + "WHERE subject = ? "
                            + "ORDER BY Name");

            st.setInt(1, subj.getId());

            rs = st.executeQuery();

            List<Book> list = new ArrayList<>();
            Map<Integer, Subject> map = new HashMap<>();

            while (rs.next()) {

                Subject subj1 = map.get(rs.getInt("subject"));

                if (subj1 == null) {
                    subj1 = instantiateSubject(rs);
                    map.put(rs.getInt("subject"), subj1);
                }

                Book obj = instantiateBook(rs, subj1);
                list.add(obj);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}

