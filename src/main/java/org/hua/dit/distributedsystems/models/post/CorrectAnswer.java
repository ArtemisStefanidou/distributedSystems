package org.hua.dit.distributedsystems.models.post;

public class CorrectAnswer {


    String text;
    String correct ;

    public CorrectAnswer(String text, String correct) {
        this.text = text;
        this.correct = correct;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
