package org.hua.dit.distributedsystems.models.post;

import java.io.Serializable;
import java.util.List;

public class QuestionGet implements Serializable {

    private String image;
    private String text;
    private List<CorrectAnswer> answers;

    public QuestionGet(String image, String text, List<CorrectAnswer> answers) {
        this.image = image;
        this.text = text;
        this.answers = answers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<CorrectAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<CorrectAnswer> answers) {
        this.answers = answers;
    }
}
