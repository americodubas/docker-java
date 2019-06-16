package com.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.test.business.ExamBusiness;
import com.test.model.Exam;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import java.util.List;

@Namespace("/exam")
public class BrowserAction extends ActionSupport {

    private List<Exam> examList;
    private String search;

    @Action("browser")
    public String execute() {
        examList = new ExamBusiness().getExamList(search);
        return SUCCESS;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
