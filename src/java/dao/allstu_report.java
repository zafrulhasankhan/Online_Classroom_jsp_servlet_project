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
public class allstu_report {
    
    private int presentno;
    private int totalday;
    private String classid;
    private String student_name;
    private String email;
 private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
 
    public int getTotalday() {
        return totalday;
    }

    public void setTotalday(int totalday) {
        this.totalday = totalday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    

    public int getPresentno() {
        return presentno;
    }

    public void setPresentno(int presentno) {
        this.presentno = presentno;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }
    
}
