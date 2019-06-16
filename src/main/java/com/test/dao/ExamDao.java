package com.test.dao;

import com.test.model.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDao {

    public List<Exam> getExamList(String search) {
        try (Connection c = DaoFactory.getConnection()) {
            String sql = "select * from exam ";
            if (search != null && !"".equals(search)) {
                sql += " where name like ?";
            }
            try (PreparedStatement ps = c.prepareStatement(sql)) {

                if (search != null && !"".equals(search)) {
                    ps.setString(1, "%" + search + "%" );
                }

                try (ResultSet rs = ps.executeQuery()) {
                    List<Exam> examList = new ArrayList<>();
                    while (rs.next()) {
                        examList.add(new Exam(
                                rs.getInt("id")
                                , rs.getString("name")
                                , rs.getString("description")
                        ));
                    }
                    return examList;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(int id) {
        try (Connection c = DaoFactory.getConnection()) {
            String sql = "delete from exam where id = ?";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateExam(Exam exam) {
        try (Connection c = DaoFactory.getConnection()) {
            String sql = "update exam set name = ?, description = ? where id = ?";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, exam.getName());
                ps.setString(2, exam.getDescription());
                ps.setInt(3, exam.getId());
                ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertExam(Exam exam) {
        try (Connection c = DaoFactory.getConnection()) {
            String sql = "insert into exam (name, description) values (?, ?)";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, exam.getName());
                ps.setString(2, exam.getDescription());
                ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Exam getExamById(int id) {
        try (Connection c = DaoFactory.getConnection()) {
            String sql = "select * from exam where id =?";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Exam exam = new Exam(
                                rs.getInt("id")
                                , rs.getString("name")
                                , rs.getString("description")
                        );
                        return exam;
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
