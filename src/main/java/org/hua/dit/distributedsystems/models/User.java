package org.hua.dit.distributedsystems.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "User")
public class User implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id ;

    private String email ;

    private int phoneNumber  ;

    private String password  ;

    private String fullName  ;

    @ManyToMany (fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    private String teacher ;

    @OneToMany
    private Collection<Subject> subjects = new ArrayList<>();

    public User(Long user_id, String email, int phoneNumber, String password, String fullName, String teacher) {
        this.user_id = user_id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.fullName = fullName;
        this.teacher = teacher;
    }
}