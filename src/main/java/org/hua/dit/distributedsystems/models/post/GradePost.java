package org.hua.dit.distributedsystems.models.post;

import javax.persistence.Column;
import javax.persistence.Id;

public class GradePost {

    private String grade_of_question;
    private String grade_question_text;
    private String user;

    public String getGrade_of_question() {
        return grade_of_question;
    }

    public void setGrade_of_question(String grade_of_question) {
        this.grade_of_question = grade_of_question;
    }

    public String getGrade_question_text() {
        return grade_question_text;
    }

    public void setGrade_question_text(String grade_question_text) {
        this.grade_question_text = grade_question_text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
