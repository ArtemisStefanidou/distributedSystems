package org.hua.dit.distributedsystems.models;

import org.hua.dit.distributedsystems.models.ids.Quiz1Id;
import org.hua.dit.distributedsystems.models.ids.Quiz2Id;

import javax.persistence.*;
import java.io.Serializable;


@Entity
    @Table(name = "quiz_lv2")
@IdClass(Quiz2Id.class)
    public class QuizLvl2 implements Serializable {

        @Id
        @Column(name = "subject_lv2_id")
        private Long subject_lv2_id;

        @Id
        @Column(name = "question_lv2_id")
        private Long question_lv2;

        public QuizLvl2() {
        }

    public QuizLvl2(Long subject_lv2_id, Long question_lv2) {
        this.subject_lv2_id = subject_lv2_id;
        this.question_lv2 = question_lv2;
    }

    public Long getSubject_lv2_id() {
            return subject_lv2_id;
        }

        public void setSubject_lv2_id(Long subject_lv2_id) {
            this.subject_lv2_id = subject_lv2_id;
        }

        public Long getQuestion_lv2() {
            return question_lv2;
        }

        public void setQuestion_lv2(long question_lv2) {
            this.question_lv2 = question_lv2;
        }
    }
