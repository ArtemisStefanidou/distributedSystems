package org.hua.dit.distributedsystems.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "class")
public class Class implements Serializable {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long class_id ;

    private String class_name ;

    @ManyToOne
    private User user;

    @OneToMany
    private Collection<Subject> subjects = new ArrayList<>();
}