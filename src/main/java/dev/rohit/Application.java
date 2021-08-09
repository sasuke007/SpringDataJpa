package dev.rohit;

import dev.rohit.entity.Person;
import dev.rohit.repository.PersonRepository;
import dev.rohit.repository.StudentRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@Log
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person person = Person.builder().birthdate(LocalDateTime.now()).location("indore").name("rohit").build();
        log.info(personRepository.insert(person).toString());
        log.info(personRepository.findById(1).toString());
        log.info(personRepository.findAll().toString());
        studentRepository.saveStudentWithPassport();
    }
}
