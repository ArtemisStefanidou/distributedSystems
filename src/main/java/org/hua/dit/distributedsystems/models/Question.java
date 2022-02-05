package org.hua.dit.distributedsystems.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", text='" + text + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", teacher=" + teacher +
                ", grades=" + grades +
                '}';
    }
}
