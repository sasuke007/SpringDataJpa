package dev.rohit.repository;

import dev.rohit.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Objects;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    private EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course) {
        if (Objects.isNull(course.getId())) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public void playWithEntityManager() {
        Course course1 = new Course("web services in 100 steps");
        entityManager.persist(course1);
        Course course2 = new Course("angular in 100 steps");
        entityManager.persist(course2);
        entityManager.flush();//to flush all the changes done uptill now to database
        entityManager.clear();//to detach eveything this only works for transactions entities.
        entityManager.detach(course1);//just to detach course1
        course1.setName("web services in 100 steps - updated");//if we dont detach the entity manager this change would go to database (interesting)
        entityManager.refresh(course1);//all the changes in course 1 are gone now course1 has lastest changes present in database the exacty copy has be copies to course1.(interesting)
    }
}
