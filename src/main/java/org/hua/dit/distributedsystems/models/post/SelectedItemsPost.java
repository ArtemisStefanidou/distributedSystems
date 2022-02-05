package org.hua.dit.distributedsystems.models.post;

public class SelectedItemsPost {

    private String studentEmail;
    private String subject;

    public SelectedItemsPost(String studentEmail, String subject) {
        this.studentEmail = studentEmail;
        this.subject = subject;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
