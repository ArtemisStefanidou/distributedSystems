package org.hua.dit.distributedsystems.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subject")
public class Subject {

    @Id
    @Column(name = "subject_id")
    private int subject_id;

    @Column(name = "subject_name")
    private String subject_name;

    @Column(name = "subject_class")
    private String subject_class;


    public Subject() {

    }
    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

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
