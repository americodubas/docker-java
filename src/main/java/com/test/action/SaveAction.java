package com.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.test.business.ExamBusiness;
import com.test.model.Exam;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/exam")
@Result(name="success", location = "browser", type = "redirectAction")
public class SaveAction extends ActionSupport {

    private Exam exam;

    @Action("save")
    public String execute() {
        ExamBusiness examBusiness = new ExamBusiness();
        if (exam.getId() > 0) {
            examBusiness.updateExam(exam);
        } else {
            examBusiness.insertExam(exam);
        }
        return SUCCESS;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
