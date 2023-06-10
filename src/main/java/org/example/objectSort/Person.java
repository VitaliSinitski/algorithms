package org.example.objectSort;

import java.util.Comparator;

public class Person implements Comparator<Person> {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public static Person createPerson(String firstName, String lastName, int age) {
        return new Person(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return firstName + "/" + lastName + "/" + age;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return o1.lastName.compareTo(o2.lastName);
    }
}
