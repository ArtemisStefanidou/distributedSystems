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

    public void setGrade_question_id(Long grade_question_id) {
        this.grade_question_id = grade_question_id;
    }

    public Integer getGrade_of_question() {
        return grade_of_question;
    }

    public void setGrade_of_question(Integer grade_of_question) {
        this.grade_of_question = grade_of_question;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}