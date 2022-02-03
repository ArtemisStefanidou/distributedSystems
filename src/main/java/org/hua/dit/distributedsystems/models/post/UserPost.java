package org.hua.dit.distributedsystems.models.post;

import org.hua.dit.distributedsystems.models.User;

public class UserPost {

    private int user_id ;
    private String user_email ;
    private int user_phone_number  ;
    private String user_password  ;
    private String user_fullName  ;
    private String user_role  ;
    private String email_teacher  ;

    public UserPost(int user_id, String user_email, int user_phone_number, String user_password, String user_fullName, String user_role, String email_teacher) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_phone_number = user_phone_number;
        this.user_password = user_password;
        this.user_fullName = user_fullName;
        this.user_role = user_role;
        this.email_teacher = email_teacher;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(int user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_fullname() {
        return user_fullName;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullName = user_fullname;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getTeacher() {
        return email_teacher;
    }

    public void setTeacher(String teacher) {
        this.email_teacher = teacher;
    }
}
