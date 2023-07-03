package org.example.person;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Person implements Comparable<Person>{
    private int id;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Person{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               '}';
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(id, o.id);
//        if (id == o.id) {
//            return 0;
//        } else if (id > o.id) {
//            return 1;
//        } else {
//            return -1;
//        }
    }
}
