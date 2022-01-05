package org.hua.dit.distributedsystems;

import org.hua.dit.distributedsystems.models.QuizLvl1;
import org.hua.dit.distributedsystems.models.QuizLvl2;
import org.hua.dit.distributedsystems.models.QuizLvl3;
import org.hua.dit.distributedsystems.repositories.QuizLv1Repo;
import org.hua.dit.distributedsystems.repositories.QuizLv2Repo;
import org.hua.dit.distributedsystems.repositories.QuizLv3Repo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.hua.dit.distributedsystems.repositories.ClassRepo;

@SpringBootApplication
public class DistributedSystemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedSystemsApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(QuizLv3Repo repo) {
        return args -> {

            QuizLvl3 q = new QuizLvl3(1L, 1L);

            repo.save(q);

/*          Grade bill = new Grade(10 , 1L, 1L);
          repo.save(bill);*/


        };
    }

}
