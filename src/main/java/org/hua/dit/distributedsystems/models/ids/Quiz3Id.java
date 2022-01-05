package org.hua.dit.distributedsystems.models.ids;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class Quiz3Id implements Serializable {

    private Long subject_lv3_id;
    private Long question_lv3;

    public Quiz3Id() {
    }

    public Quiz3Id(Long subject_lv3_id, Long questionId) {
        this.subject_lv3_id = subject_lv3_id;
        this.question_lv3 = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quiz3Id)) return false;
        Quiz3Id quiz3Id = (Quiz3Id) o;
        return subject_lv3_id.equals(quiz3Id.subject_lv3_id) && question_lv3.equals(quiz3Id.question_lv3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject_lv3_id, question_lv3);
    }
}
