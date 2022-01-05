package org.hua.dit.distributedsystems.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "class")
public class Class implements Serializable {
    @Id
    @Column(name = "class_id")
    private Long class_id ;


    @Column(name = "class_name")
    private String class_name ;


    public Class(){

    }

    public Class(Long class_id, String class_name) {
        this.class_id = class_id;
        this.class_name = class_name;
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
