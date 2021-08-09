package dev.rohit.repository;

import dev.rohit.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//Repository
@Repository
@Transactional
public class PersonRepository {

    /**
     * connect to database
     */
    @PersistenceContext
    private EntityManager entityManager;


    /**
     * query the database
     *
     * @param id id;
     * @return Person Object.
     */
    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }
}
