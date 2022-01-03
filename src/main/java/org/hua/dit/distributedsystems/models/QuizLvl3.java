package org.hua.dit.distributedsystems.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "quiz_lv3")
public class QuizLvl3 implements Serializable {

    @Id
    @Column(name = "subject_lv3_id")
    private int subject_lv3_id;

    @Id
    @Column(name = "question_lv3_id")
    private int question_lv3;

    public QuizLvl3() {
    }

    public int getSubject_lv3_id() {
        return subject_lv3_id;
    }

    public void setSubject_lv3_id(int subject_lv3_id) {
        this.subject_lv3_id = subject_lv3_id;
    }

    public int getQuestion_lv3() {
        return question_lv3;
    }

    public void setQuestion_lv3(int question_lv3) {
        this.question_lv3 = question_lv3;
    }
}
