package org.hua.dit.distributedsystems.models.post;

import java.io.Serializable;

public class SelectedItems implements Serializable{

    public SelectedItems(String subject, String classSelected, String level) {
        this.subject = subject;
        this.classSelected = classSelected;
        this.level = level;
    }

    private String subject;

        private String classSelected;

        private String level;

    public String getSubject() {
        return subject;
    }

    public String getClassSelected() {
        return classSelected;
    }

    public String getLevel() {
        return level;
    }
}
