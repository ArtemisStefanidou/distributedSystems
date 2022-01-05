package org.hua.dit.distributedsystems.models.post;

import javax.persistence.Column;
import javax.persistence.Id;

public class GradePost {

    private int grade_of_question;
    private Long grade_question_id;
    private Long grade_user_id;

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
