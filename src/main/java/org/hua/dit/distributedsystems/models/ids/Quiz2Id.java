package org.hua.dit.distributedsystems.models.ids;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class Quiz2Id implements Serializable {

    private Long subject_lv2_id;
    private Long question_lv2;

    public Quiz2Id() {
    }

    public Quiz2Id(Long subject_lv2_id, Long question_lv2) {
        this.subject_lv2_id = subject_lv2_id;
        this.question_lv2 = question_lv2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quiz2Id)) return false;
        Quiz2Id quiz2Id = (Quiz2Id) o;
        return subject_lv2_id.equals(quiz2Id.subject_lv2_id) && question_lv2.equals(quiz2Id.question_lv2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject_lv2_id, question_lv2);
    }
}
