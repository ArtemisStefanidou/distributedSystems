package org.hua.dit.distributedsystems.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quiz_lv1")
public class QuizLv1 {

    @Id
    @Column(name = "subject_lv1_id")
    private int subjectId;

    @Id
    @Column(name = "question_lv1_id")
    private int questionId;

    public QuizLv1() {
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getQuestionId() {
        return questionId;
    }
}