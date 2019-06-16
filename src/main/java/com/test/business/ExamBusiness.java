package com.test.business;

import com.test.dao.ExamDao;
import com.test.model.Exam;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.test.business.ExamBusinessInterface")
public class ExamBusiness implements ExamBusinessInterface {

    private final ExamDao examDao;

    public ExamBusiness() {
        examDao = new ExamDao();
    }

    public List<Exam> getExamList(String search) {
        return examDao.getExamList(search);
    }

    @Override
    public Exam getExamById(int id) {
        return examDao.getExamById(id);
    }

    @Override
    public void deleteById(int id) {
        examDao.deleteById(id);
    }

    @Override
    public void updateExam(Exam exam) {
        examDao.updateExam(exam);
    }

    @Override
    public void insertExam(Exam exam) {
        examDao.insertExam(exam);
    }
}
