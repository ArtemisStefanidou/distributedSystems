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
@Table(name="Question")
public class Question implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String image;

    private String text;

    //This field is only for the correct answer
    private String option1;

    private String option2;

    private String option3;

    private String option4;

    @ManyToOne
    private User teacher;

    @OneToMany
    private Collection<Grade> grades = new ArrayList<>();

}
