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
    @Column(name = "user_id")
    private Long user_id ;

    private String email ;

    private int phoneNumber  ;

    private String password  ;

    private String fullName  ;

    @ManyToMany (fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    private String teacherName  ;
}
