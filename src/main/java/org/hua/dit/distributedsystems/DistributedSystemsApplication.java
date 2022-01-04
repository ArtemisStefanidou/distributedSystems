package org.hua.dit.distributedsystems;

import org.hua.dit.distributedsystems.depositories.UserRepo;
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
    CommandLineRunner commandLineRunner(UserRepo userRepo) {
        return args -> {
          User bill = new User(2L,"artemis@gmail.com", 123 , 123, "Artemis", "Mathematician");

          userRepo.save(bill);
        };
    }

}
