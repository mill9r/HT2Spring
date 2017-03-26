package com.epam.tsylko.andrei.dao;


import com.epam.tsylko.andrei.model.Person;

import java.util.List;

public interface PersonDao{

    void addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
    Person getPersonById(int id);
    List<Person> getPeople();

}
