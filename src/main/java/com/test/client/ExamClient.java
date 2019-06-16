package com.test.client;

import com.test.business.ExamBusinessInterface;
import com.test.model.Exam;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ExamClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:9876/exam");

        QName qName = new QName("http://business.test.com/", "ExamBusinessService");

        Service ws = Service.create(url, qName);
        ExamBusinessInterface examBusinessInterface = ws.getPort(ExamBusinessInterface.class);

        Exam exam = new Exam(0,"insert", "desc insert");
        examBusinessInterface.insertExam(exam);

        System.out.println("Begin test soap");

        exam = examBusinessInterface.getExamById(1);
        System.out.println("Exam 1: " + exam.toString());

        exam.setName("update");
        exam.setDescription("desc update");
        examBusinessInterface.updateExam(exam);

        exam = examBusinessInterface.getExamById(1);
        System.out.println("Exam 2: " + exam.toString());

        examBusinessInterface.deleteById(1);

        System.out.println("End test soap");
    }

}
