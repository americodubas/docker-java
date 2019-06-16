package com.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.test.business.ExamBusiness;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/exam")
@Result(name="success", location = "browser", type = "redirectAction")
public class DeleteAction extends ActionSupport {

    private int id;

    @Action("delete")
    public String execute() {
        new ExamBusiness().deleteById(id);
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
