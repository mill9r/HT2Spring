package com.epam.tsylko.andrei.dao.impl;


import com.epam.tsylko.andrei.dao.PersonDao;
import com.epam.tsylko.andrei.model.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(person);
        session.flush();
    }

    @Override
    public void updatePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(person);
        session.flush();
    }

    @Override
    public void deletePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(person);
        session.flush();
    }

    @Override
    public Person getPersonById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = (Person) session.get(Person.class, id);
        session.flush();
        return person;
    }

    @Override
    public List<Person> getPeople() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Person");
        List<Person> people = query.list();
        return people;
    }
}
