package org.hua.dit.distributedsystems.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long user_id ;

    @Column(name = "email")
    private String email ;

    @Column(name = "user_phone_number")
    private int user_phone_number  ;

    @Column(name = "user_password")
    private String user_password  ;

    @Column(name = "user_fullname")
    private String user_fullname  ;


    @Column(name = "user_role")
    @ManyToMany (fetch = FetchType.EAGER)
    private Collection<Role> user_role = new ArrayList<>();

    @Column(name = "user_teacher")
    private String user_teacher  ;

    public User() {
    }

    public User(Long user_id, String email, int user_phone_number, String user_password, String user_fullname, Collection<Role> user_role) {
        this.user_id = user_id;
        this.email = email;
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
        return email;
    }

    public void setUser_email(String email) {
        this.email = email;
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
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Role> getUser_role() {
        return user_role;
    }

    public void setUser_role(Collection<Role> user_role) {
        this.user_role = user_role;
    }

    public String getUser_teacher() {
        return user_teacher;
    }

    public void setUser_teacher(String user_teacher) {
        this.user_teacher = user_teacher;
    }
}
