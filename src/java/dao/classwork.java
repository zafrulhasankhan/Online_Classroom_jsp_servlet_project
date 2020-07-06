/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Zafrul Hasan Nasim
 */
public class classwork {
    private String body;
    private String deadline;
    private String filename;
   private String classwork_no;
private String Student_name;
private String Student_id;
private String Student_email;
private String mark;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getStudent_email() {
        return Student_email;
    }

    public void setStudent_email(String Student_email) {
        this.Student_email = Student_email;
    }


    public String getStudent_name() {
        return Student_name;
    }

    public void setStudent_name(String Student_name) {
        this.Student_name = Student_name;
    }

    public String getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(String Student_id) {
        this.Student_id = Student_id;
    }

    public String getClasswork_no() {
        return classwork_no;
    }

    public void setClasswork_no(String classwork_no) {
        this.classwork_no = classwork_no;
    }
   
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
}
