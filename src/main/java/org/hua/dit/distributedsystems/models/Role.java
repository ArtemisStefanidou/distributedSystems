package org.hua.dit.distributedsystems.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String name ;
}
