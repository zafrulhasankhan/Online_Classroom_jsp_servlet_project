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
public class attend {
    private String id;
    private String name;
    private String attendance;
    private String sfilename;

    public String getSfilename() {
        return sfilename;
    }

    public void setSfilename(String sfilename) {
        this.sfilename = sfilename;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
    
}
