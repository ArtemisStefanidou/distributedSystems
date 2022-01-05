package org.hua.dit.distributedsystems.models.ids;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class GradeId implements Serializable {

    private Long grade_question_id;

    private Long grade_user_id;

    public GradeId() {
    }

    public GradeId(Long grade_question_id, Long grade_user_id) {
        this.grade_question_id = grade_question_id;
        this.grade_user_id = grade_user_id;
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
