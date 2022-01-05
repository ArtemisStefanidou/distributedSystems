package org.hua.dit.distributedsystems.models;

import org.hua.dit.distributedsystems.models.ids.GradeId;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Grade")
@IdClass(GradeId.class)
public class Grade implements Serializable {

    @Column(name = "grade_of_question")
    private int grade_of_question;

    @Id
    @Column(name = "grade_question_id")
    private Long grade_question_id;

    @Id
    @Column(name = "grade_user_id")
    private Long grade_user_id;

    public Grade(){

    }

    public Grade(int grade_of_question, Long grade_question_id, Long grade_user_id) {
        this.grade_of_question = grade_of_question;
        this.grade_question_id = grade_question_id;
        this.grade_user_id = grade_user_id;
    }

    public int getGrade_of_question() {
        return grade_of_question;
    }

    public void setGrade_of_question(int grade_of_question) {
        this.grade_of_question = grade_of_question;
    }

    public Long getGrade_question_id() {
        return grade_question_id;
    }

    public void setGrade_question_id(Long grade_question_id) {
        this.grade_question_id = grade_question_id;
    }

    public Long getGrade_user_id() {
        return grade_user_id;
    }

    public void setGrade_user_id(Long grade_user_id) {
        this.grade_user_id = grade_user_id;
    }

}
