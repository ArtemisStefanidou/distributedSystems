package org.hua.dit.distributedsystems.models.ids;


import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class Quiz1Id implements Serializable {

    private Long subjectId;
    private Long questionId;

    public Quiz1Id() {
    }

    public Quiz1Id(Long subjectId ,Long questionId) {
        this.subjectId = subjectId;
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;


        Quiz1Id quiz1Id = (Quiz1Id) o;
        return subjectId.equals(quiz1Id.subjectId) && questionId.equals(quiz1Id.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, questionId);
    }
}
