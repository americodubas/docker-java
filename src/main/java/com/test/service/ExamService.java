package com.test.service;

import com.test.business.ExamBusiness;
import com.test.model.Exam;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ExamService {

    @WebMethod
    public List<Exam> getExamList(String search) {
        return new ExamBusiness().getExamList(search);
    }

}
