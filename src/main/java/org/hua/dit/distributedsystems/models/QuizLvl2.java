package org.hua.dit.distributedsystems.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
    @Table(name = "quiz_lv2")
    public class QuizLvl2 implements Serializable {

        @Id
        @Column(name = "subject_lv2_id")
        private int subject_lv2_id;

        @Id
        @Column(name = "question_lv2_id")
        private int question_lv2;

        public QuizLvl2() {
        }

        public int getSubject_lv2_id() {
            return subject_lv2_id;
        }

        public void setSubject_lv2_id(int subject_lv2_id) {
            this.subject_lv2_id = subject_lv2_id;
        }

        public int getQuestion_lv2() {
            return question_lv2;
        }

        public void setQuestion_lv2(int question_lv2) {
            this.question_lv2 = question_lv2;
        }
    }
