package org.hua.dit.distributedsystems.models.post;

import javax.persistence.Column;

public class ClassPost {
    private Long class_id ;
    private String class_name ;

    public ClassPost(){

    }
    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
