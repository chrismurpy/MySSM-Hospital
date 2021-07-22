package com.murphy.pojo;

public class User {
    private Integer u_LoginName;

    private String u_password;

    private String u_trueName;

    private String u_email;

    private Integer u_state;

    private Integer r_id;

    public Integer getU_LoginName() {
        return u_LoginName;
    }

    public void setU_LoginName(Integer u_LoginName) {
        this.u_LoginName = u_LoginName;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password == null ? null : u_password.trim();
    }

    public String getU_trueName() {
        return u_trueName;
    }

    public void setU_trueName(String u_trueName) {
        this.u_trueName = u_trueName == null ? null : u_trueName.trim();
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email == null ? null : u_email.trim();
    }

    public Integer getU_state() {
        return u_state;
    }

    public void setU_state(Integer u_state) {
        this.u_state = u_state;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }
}