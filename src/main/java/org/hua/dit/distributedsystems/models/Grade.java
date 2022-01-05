package org.hua.dit.distributedsystems.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Grade")
@IdClass(Grade.GradeId.class)
public class Grade implements Serializable {

    @Column(name = "grade_of_question")
    private Long grade_of_question;

    @Id
    @Column(name = "grade_question_id")
    private Long grade_question_id;

    @Id
    @Column(name = "grade_user_id")
    private Long grade_user_id;

    public Grade(){

    }




    public Long getGrade_of_question() {
        return grade_of_question;
    }

    public void setGrade_of_question(Long grade_of_question) {
        this.grade_of_question = grade_of_question;
    }

    public Long getGrade_question_id() {
        return grade_question_id;
    }

    public void setGrade_question_id(Long grade_question_id) {
        this.grade_question_id = grade_question_id;
    }

    public Long getGrade_user_id() {
        return grade_user_id;
    }

    public void setGrade_user_id(Long grade_user_id) {
        this.grade_user_id = grade_user_id;
    }

    public class GradeId implements Serializable {

        private Long grade_question_id;

        private Long grade_user_id;

        public GradeId(Long grade_question_id, Long grade_user_id) {
            this.grade_question_id = grade_question_id;
            this.grade_user_id = grade_user_id;
        }

        public GradeId() {
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;


            GradeId gradeId = (GradeId) obj;
            return grade_question_id.equals(gradeId.grade_question_id) &&
                    grade_user_id.equals(gradeId.grade_user_id);
        }


        @Override
        public int hashCode() {
            return Objects.hash(grade_question_id, grade_user_id);
        }
    }
}
