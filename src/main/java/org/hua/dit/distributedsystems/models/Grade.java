package org.hua.dit.distributedsystems.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Grade")
public class Grade implements Serializable {

    @Column(name = "grade_of_question")
    private int grade_of_question;

    @Id
    @Column(name = "grade_question_id")
    private int grade_question_id;

    @Id
    @Column(name = "grade_user_id")
    private int grade_user_id;

    public Grade(){

    }
    public int getGrade_of_question() {
        return grade_of_question;
    }

    public void setGrade_of_question(int grade_of_question) {
        this.grade_of_question = grade_of_question;
    }

    public int getGrade_question_id() {
        return grade_question_id;
    }

    public void setGrade_question_id(int grade_question_id) {
        this.grade_question_id = grade_question_id;
    }

    public int getGrade_user_id() {
        return grade_user_id;
    }

    public void setGrade_user_id(int grade_user_id) {
        this.grade_user_id = grade_user_id;
    }
}
