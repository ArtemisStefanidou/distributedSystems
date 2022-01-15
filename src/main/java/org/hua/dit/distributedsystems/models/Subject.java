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

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subject_id;

    private String subject_name;

    @OneToMany
    private Collection<Question> questions = new ArrayList<>();
}
