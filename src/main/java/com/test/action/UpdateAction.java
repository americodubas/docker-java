package com.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.test.business.ExamBusiness;
import com.test.model.Exam;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/exam")
public class UpdateAction extends ActionSupport {

    private Exam exam;
    private int id;

    @Action("update")
    public String execute() {
        if (id > 0) {
            exam = new ExamBusiness().getExamById(id);
        } else {
            exam = new Exam();
        }
        return SUCCESS;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
