package org.hua.dit.distributedsystems.models;

import org.hua.dit.distributedsystems.models.ids.Quiz1Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quiz_lv1")
@IdClass(Quiz1Id.class)
public class QuizLvl1 implements Serializable {

    @Id
    @Column(name = "subject_lv1_id")
    private Long subjectId;

    @Id
    @Column(name = "question_lv1_id")
    private Long questionId;

    public QuizLvl1() {
    }

    public QuizLvl1(Long subjectId, Long questionId) {
        this.subjectId = subjectId;
        this.questionId = questionId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public Long getQuestionId() {
        return questionId;
    }
}