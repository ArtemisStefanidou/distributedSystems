package org.hua.dit.distributedsystems.models.post;

import org.hua.dit.distributedsystems.models.User;

public class QuestionPost {
    private String question_id;
    private String question_image;
    private String question_text;
    private String question_option1;
    private String question_option2;
    private String question_option3;
    private String question_option4;
    private String question_script;
    private User teacher;
    private int  lvl;

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public QuestionPost() {
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

    public String getQuestion_script() {
        return question_script;
    }

    public void setQuestion_script(String question_script) {
        this.question_script = question_script;
    }

}
