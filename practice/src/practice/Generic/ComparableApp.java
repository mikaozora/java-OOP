package practice.Generic;

import practice.Generic.utils.Person;

import java.util.Arrays;

public class ComparableApp {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("mika", "Indo"),
                new Person("yoga", "malay"),
                new Person("jason", "jkt"),
                new Person("abdi", "jepang")
        };
        Arrays.sort(persons);
        System.out.println(Arrays.toString(persons));
    }
}
