package org.hua.dit.distributedsystems.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Grade")
public class Grade implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long grade_question_id;

    private int grade_of_question;

}
