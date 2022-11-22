package com.example.FullSpringBasic.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> { Student elias = new Student("Elias", "e.koschwitz@googlemail.com", LocalDate.of(1992, Month.APRIL, 6));
                        Student alex = new Student("Alex", "a.anderson@googlemail.com", LocalDate.of(1945, Month.JANUARY, 8));

            //Safe the Students
            repository.saveAll(List.of(elias, alex));
        };

    }

}
