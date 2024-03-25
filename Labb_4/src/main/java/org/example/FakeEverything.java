package org.example;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class FakeEverything {
    Faker faker = new Faker();

    public FakeEverything() {
        this.faker = new Faker();
    }

    public Person generatePerson() {
        String name = faker.name().fullName();
        String destination = faker.address().city();
        int age = faker.number().numberBetween(18, 60);
        return new Person(name, age,destination);
    }

    public List<Person> generatePeople(int numPeople) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < numPeople; i++) {
            people.add(generatePerson());
        }
        return people;
    }
}
