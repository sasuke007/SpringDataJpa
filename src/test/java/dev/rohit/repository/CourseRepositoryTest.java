package dev.rohit.repository;

import dev.rohit.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//brings up the entire spring boot application context
@SpringBootTest
@RunWith(SpringRunner.class)
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void contextLoads() {
        Course course = courseRepository.findById(1l);
        assertEquals("JPA", course.getName());
    }

    //dirties context will reset the context after executing the test so the other test case have that data when they are run.
    //used when test is trying to change the state of database.
    @Test
    @DirtiesContext
    public void deleteById_basic() {
        courseRepository.deleteById(1002l);
        assertNull(courseRepository.findById(10002l));
    }


}