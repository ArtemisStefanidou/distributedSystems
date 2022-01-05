package org.hua.dit.distributedsystems;

import org.hua.dit.distributedsystems.models.Grade;
import org.hua.dit.distributedsystems.models.Question;
import org.hua.dit.distributedsystems.models.Subject;
import org.hua.dit.distributedsystems.repositories.GradeRepo;
import org.hua.dit.distributedsystems.repositories.QuestionsRepo;
import org.hua.dit.distributedsystems.repositories.SubjectRepo;
import org.hua.dit.distributedsystems.repositories.UserRepo;
import org.hua.dit.distributedsystems.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DistributedSystemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedSystemsApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(GradeRepo repo) {
        return args -> {
/*          Grade bill = new Grade(10 , 1L, 1L);
          repo.save(bill);*/


        };
    }

}
