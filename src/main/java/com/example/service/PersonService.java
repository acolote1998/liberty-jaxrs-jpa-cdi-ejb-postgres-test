package com.example.service;

import com.example.model.Person;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonService {
    @PersistenceContext
    private EntityManager em;

    public List<Person> list() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    public Person create(Person p) {
        em.persist(p);
        return p;
    }
}
