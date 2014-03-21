package com.example;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return birthday.until(LocalDate.now()).getYears();
    }

    public void printPerson() {
        System.out.println(this.toString());
    }

    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) { p.printPerson(); }
        }
    }

    public static void printPersonsOverAge(List<Person> roster, int age) {
        printPersonsWithPredicate(roster, p -> p.getAge() > age);
    }

    public static List<Person> getPersonsOverAge(List<Person> roster, int age) {
        return roster.stream().filter(p -> p.getAge() > age).collect(Collectors.toList());
    }

    public static int getTotalAge(List<Person> roster) {
        return roster.stream().mapToInt(p -> p.getAge()).sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s", name, gender, birthday, emailAddress);
    }
}

interface Predicate<T> {
    boolean test(T t);
}
