package org.hua.dit.distributedsystems.models.post;

public class QuestionPost {
    private String question_id;
    private String question_image;
    private String question_text;
    private String question_option1;
    private String question_option2;
    private String question_option3;
    private String question_option4;
    private String email_teacher;
    private String subject_question;


    public QuestionPost( String question_image, String question_text, String question_option1, String question_option2, String question_option3, String question_option4, String email_teacher,String subject_question) {
        this.question_image = question_image;
        this.question_text = question_text;
        this.question_option1 = question_option1;
        this.question_option2 = question_option2;
        this.question_option3 = question_option3;
        this.question_option4 = question_option4;
        this.email_teacher = email_teacher;
        this.subject_question = subject_question;
    }

    public String getSubject_question() {
        return subject_question;
    }

    public void setSubject_question(String subject_question) {
        this.subject_question = subject_question;
    }

    public String getTeacher() {
        return email_teacher;
    }

    public void setTeacher(String teacher) {
        this.email_teacher = teacher;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_image() {
        return question_image;
    }

    public void setQuestion_image(String question_image) {
        this.question_image = question_image;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getQuestion_option1() {
        return question_option1;
    }

    public void setQuestion_option1(String question_option1) {
        this.question_option1 = question_option1;
    }

    public String getQuestion_option2() {
        return question_option2;
    }

    public void setQuestion_option2(String question_option2) {
        this.question_option2 = question_option2;
    }

    public String getQuestion_option3() {
        return question_option3;
    }

    public void setQuestion_option3(String question_option3) {
        this.question_option3 = question_option3;
    }

    public String getQuestion_option4() {
        return question_option4;
    }

    public void setQuestion_option4(String question_option4) {
        this.question_option4 = question_option4;
    }
}
