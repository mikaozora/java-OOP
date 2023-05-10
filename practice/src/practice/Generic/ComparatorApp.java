package practice.Generic;

import practice.Generic.utils.Person;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorApp {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("mika", "Indo"),
                new Person("yoga", "malay"),
                new Person("jason", "jkt"),
                new Person("abdi", "jepang")
        };
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Arrays.sort(persons, comparator);
        System.out.println(Arrays.toString(persons));
    }
}
