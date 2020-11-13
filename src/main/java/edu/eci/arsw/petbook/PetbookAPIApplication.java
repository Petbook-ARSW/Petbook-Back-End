package edu.eci.arsw.petbook;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("edu.eci.arsw.petbook.persistence")
@EntityScan("edu.eci.arsw.petbook.model")
public class PetbookAPIApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetbookAPIApplication.class, args);
    }
}
