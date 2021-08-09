package dev.rohit.repository;

import dev.rohit.entity.Passport;
import dev.rohit.entity.Student;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Log
@Repository
@Transactional
public class StudentRepository {

    @Autowired
    private EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }
        return student;
    }

    public Student deleteById(Long id) {
        Student student = findById(id);
        entityManager.remove(student);
        return student;
    }

    public void saveStudentWithPassport() {
        Passport passport = Passport.builder().number("Z12345").build();
        Student student = Student.builder().name("mike").passport(passport).build();
        entityManager.persist(student);
    }

}
