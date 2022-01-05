package org.hua.dit.distributedsystems.models;

import org.hua.dit.distributedsystems.models.ids.Quiz1Id;
import org.hua.dit.distributedsystems.models.ids.Quiz3Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quiz_lv3")
@IdClass(Quiz3Id.class)
public class QuizLvl3 implements Serializable {

    @Id
    @Column(name = "subject_lv3_id")
    private Long subject_lv3_id;

    @Id
    @Column(name = "question_lv3_id")
    private Long question_lv3;

    public QuizLvl3() {
    }

    public QuizLvl3(Long subject_lv3_id, Long question_lv3) {
        this.subject_lv3_id = subject_lv3_id;
        this.question_lv3 = question_lv3;
    }

    public Long getSubject_lv3_id() {
        return subject_lv3_id;
    }

    public void setSubject_lv3_id(Long subject_lv3_id) {
        this.subject_lv3_id = subject_lv3_id;
    }

    public Long getQuestion_lv3() {
        return question_lv3;
    }

    public void setQuestion_lv3(Long question_lv3) {
        this.question_lv3 = question_lv3;
    }
}
