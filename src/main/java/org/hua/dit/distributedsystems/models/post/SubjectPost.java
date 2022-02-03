package org.hua.dit.distributedsystems.models.post;

import javax.persistence.Column;
import javax.persistence.Id;

public class SubjectPost {

    private String subject_name;
    private String subject_class;


    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_class() {
        return subject_class;
    }

    public void setSubject_class(String subject_class) {
        this.subject_class = subject_class;
    }
}
