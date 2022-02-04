package org.hua.dit.distributedsystems.models.post;

public class QuizPost {

    private String email;
    private String subject;

    public QuizPost(String email, String subject) {
        this.email = email;
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
