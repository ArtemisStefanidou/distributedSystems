package org.hua.dit.distributedsystems.models.post;

public class QuizLvl1Post {
    private Long quizlvl1_subjectId;
    private Long quizlvl1_questionId;


    public  QuizLvl1Post(){

    }

    public Long getQuizlvl1_subjectId() {
        return quizlvl1_subjectId;
    }

    public void setQuizlvl1_subjectId(Long quizlvl1_subjectId) {
        this.quizlvl1_subjectId = quizlvl1_subjectId;
    }

    public Long getQuizlvl1_questionId() {
        return quizlvl1_questionId;
    }

    public void setQuizlvl1_questionId(Long quizlvl1_questionId) {
        this.quizlvl1_questionId = quizlvl1_questionId;
    }
}
