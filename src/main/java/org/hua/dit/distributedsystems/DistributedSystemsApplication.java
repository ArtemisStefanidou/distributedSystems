package org.hua.dit.distributedsystems;

import org.hua.dit.distributedsystems.models.QuizLvl1;
import org.hua.dit.distributedsystems.models.QuizLvl2;
import org.hua.dit.distributedsystems.models.QuizLvl3;
import org.hua.dit.distributedsystems.models.User;
import org.hua.dit.distributedsystems.repositories.*;
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
    CommandLineRunner commandLineRunner(UserRepo repo) {
        return args -> {

            System.out.println("hello");

/*            QuizLvl3 q = new QuizLvl3(1L, 1L);

            repo.save(q);*/

          User bill = new User();
          repo.save(bill);


        };
    }

}
