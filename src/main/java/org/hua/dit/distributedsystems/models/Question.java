package org.hua.dit.distributedsystems.models;

import javax.persistence.*;

@Entity
@Table(name="Question")
public class Question {

    @Id
    @Column(name = "question_id")
    private Long id;

    @Column(name = "question_image")
    private String image;

    @Column(name = "question_text")
    private String text;

    //in this field go only the correct answers
    @Column(name = "question_option1")
    private String option1;

    @Column(name = "question_option2")
    private String option2;

    @Column(name = "question_option3")
    private String option3;

    @Column(name = "question_option4")
    private String option4;

    @Column(name = "question_script")
    private String script;

    //@manytoone
    @Column(name = "question_teacher")
    private int teacher;

    @Column(name = "question_lvl")
    private int lvl;

    //@polla question se ena subject
    @Column(name = "question_subject_id")
    private int question_subject_id;


    public Question() {

    }

    public Question(Long id) {
        this.id = id;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }


    public int getQuestion_teacher() {
        return teacher;
    }

    public void setQuestion_teacher(int question_teacher) {
        this.teacher = question_teacher;
    }

    public int getQuestion_subject_id() {
        return question_subject_id;
    }

    public void setQuestion_subject_id(int question_subject_id) {
        this.question_subject_id = question_subject_id;
    }
}
