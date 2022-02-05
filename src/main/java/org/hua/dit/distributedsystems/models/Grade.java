package org.hua.dit.distributedsystems.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long grade_question_id;

    private Integer grade_of_question;

    @ManyToOne
    private User student;

    @ManyToOne
    private Question question;

    public Long getGrade_question_id() {
        return grade_question_id;
    }
}