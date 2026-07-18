package pl.mikolaj.webservicetest.services.impl;

import org.junit.jupiter.api.Test;
import pl.mikolaj.webservicetest.beans.Person;
import pl.mikolaj.webservicetest.dao.PersonDao;
import pl.mikolaj.webservicetest.dao.impl.PersonDaoImpl;
import pl.mikolaj.webservicetest.services.PersonService;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceImplTest {
    PersonDao personDao = new PersonDaoImpl();
    PersonService personService = new PersonServiceImpl(personDao);

    @Test
    void testGetAllPeople() {
        List<Person> people = personService.getAllPeople(10, 0);
        assertEquals(10, people.size());

        people = personService.getAllPeople(10,99);
        assertEquals(10, people.size());

        people = personService.getAllPeople(10, 100);
        assertTrue(people.isEmpty());

        people = personService.getAllPeople(999, 1);
        assertEquals(1, people.size());
    }

    @Test
    void findByIds() {
        List<Integer> ids = List.of(1,2,3,4,5,6,7,8,9,10,11);
        List<Person> persons = personService.findByIds(ids);
        assertEquals(ids.size(), persons.size());

        persons = personService.findByIds(ids, 10, 0);
        assertEquals(10, persons.size());

        persons = personService.findByIds(ids, 10, 1);
        assertEquals(1, persons.size());

        persons = personService.findByIds(ids, 10, 2);
        assertEquals(0, persons.size());
    }

    @Test
    void testPrintPerson() {
        printPerson(personService.getAllPeople(), new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return "Male".equals(p.getGender()) && p.getAge() >= 18 && p.getAge() <= 25;
            }
        });
        printPersonWithPredicate(personService.getAllPeople(),
                p -> "Male".equals(p.getGender()) && p.getAge() >= 18 && p.getAge() <= 25
        );
    }

    @FunctionalInterface
    interface CheckPerson {
        boolean test(Person p);
    }

    private void printPersonWithPredicate(List<Person> people, Predicate<Person> condition) {
        for(Person person : people) {
            if(condition.test(person)) {
                System.out.println(person);
            }
        }
    }

    private void printPerson(List<Person> people, CheckPerson condition) {
        for(Person person : people) {
            if(condition.test(person)) {
                System.out.println(person);
            }
        }
    }
}