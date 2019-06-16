package com.test.business;

import com.test.model.Exam;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ExamBusinessInterface {

    @WebMethod
    Exam getExamById(int id);

    @WebMethod
    void deleteById(int id);

    @WebMethod
    void updateExam(Exam exam);

    @WebMethod
    void insertExam(Exam exam);
}
