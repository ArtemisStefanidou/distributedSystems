package org.hua.dit.distributedsystems.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long user_id ;

    @Column(name = "user_email")
    private String user_email ;

    @Column(name = "user_phone_number")
    private int user_phone_number  ;

    @Column(name = "user_password")
    private int user_password  ;

    @Column(name = "user_fullname")
    private String user_fullname  ;

    @Column(name = "user_role")
    private String user_role  ;

    @Column(name = "user_teacher")
    private String user_teacher  ;

    public User() {
    }

    public User(Long id, String user_email, int user_phone_number, int user_password, String user_fullname, String user_role) {
        this.user_id = id;
        this.user_email = user_email;
        this.user_phone_number = user_phone_number;
        this.user_password = user_password;
        this.user_fullname = user_fullname;
        this.user_role = user_role;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
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

    public int getUser_password() {
        return user_password;
    }

    public void setUser_password(int user_password) {
        this.user_password = user_password;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getUser_teacher() {
        return user_teacher;
    }

    public void setUser_teacher(String user_teacher) {
        this.user_teacher = user_teacher;
    }
}
