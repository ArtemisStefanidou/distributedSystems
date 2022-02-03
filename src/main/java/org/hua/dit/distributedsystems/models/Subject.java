package org.hua.dit.distributedsystems.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="subject")
public class Subject implements Serializable {

    @Id
    private String subject_name;

    private String classLevel;

    @OneToMany
    private Collection<Question> questions = new ArrayList<>();
}
