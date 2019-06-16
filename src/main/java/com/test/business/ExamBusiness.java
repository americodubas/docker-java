package com.test.business;

import com.test.dao.ExamDao;
import com.test.model.Exam;

import java.util.List;

public class ExamBusiness {

    private final ExamDao examDao;

    public ExamBusiness() {
        examDao = new ExamDao();
    }

    public List<Exam> getExamList(String search) {
        return examDao.getExamList(search);
    }

    public Exam getExamById(int id) {
        return examDao.getExamById(id);
    }

    public void deleteById(int id) {
        examDao.deleteById(id);
    }

    public void updateExam(Exam exam) {
        examDao.updateExam(exam);
    }

    public void insertExam(Exam exam) {
        examDao.insertExam(exam);
    }
}
