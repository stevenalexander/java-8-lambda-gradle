package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class PersonTests {

    @Test
    public void NewPerson() {
        Person p = new Person();
        p.name = "John Smith";
        p.gender = Person.Sex.MALE;
        p.birthday = LocalDate.of(2000, 1, 1);
        p.emailAddress = "one@two.com";

        p.printPerson();
    }

    @Test
    public void getAge() {
        Person p = getPersonWithAge(20);
        assertEquals(20, p.getAge());
    }

    @Test
    public void getTotalAge() {
        int age1 = 20;
        int age2 = 13;
        Person p1 = getPersonWithAge(age1);
        Person p2 = getPersonWithAge(age2);

        assertEquals(age1 + age2, Person.getTotalAge(new ArrayList<Person>() {{ add(p1); add(p2); }}));
    }

    private Person getPersonWithAge(int yearsOld) {
        Person p = new Person();
        p.birthday = LocalDate.now().minusYears(yearsOld);

        return p;
    }
}
