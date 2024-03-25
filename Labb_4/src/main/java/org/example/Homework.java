package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.util.stream.Stream;
import java.util.*;
import java.util.stream.Collectors;
import com.github.javafaker.Faker;

public class Homework {
    public static void main(String[] args)
    {
        List<Person> people = new ArrayList<>();
        Person pers1 = new Driver("Ion",20,"Bacau",true);
        Person pers2 = new Driver("Marian",18,"Roman",true);
        Person pers3 = new Driver("Ana",24,"Pascani",true);

        Person pers4 = new Passenger("Pass1",20,"Roman");
        Person pers5 = new Passenger("Pass2",18,"Bacau");
        Person pers6 = new Passenger("Pass3",24,"Bacau");

        people.add(pers1);
        people.add(pers2);
        people.add(pers3);
        people.add(pers4);
        people.add(pers5);
        people.add(pers6);

        List<Driver> soferi = people.stream()
                .filter(person -> person instanceof Driver)
                .map(person->(Driver) person)
                .collect(Collectors.toList());

        Set<Person> pasageri = people.stream()
                        .filter(person -> person instanceof Passenger)
                                .collect(Collectors.toSet());

        List<Person> pasageri2 = people.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .collect(Collectors.toList());

        //lista cu destinatiile prin care trec soferii
        List<String> destinatii = soferi.stream()
                .map(Person::getDestination)
                .distinct()
                .collect(Collectors.toList());

        System.out.print("Destinatiile soferilor : ");
        destinatii.forEach(n->System.out.print(n+ " "));



        //map cu destinatiile pasagerilor impreuna cu pasagerii care vor sa mearga
        Map<String,List<Person>> destinatiiPasageri = pasageri.stream()
                .collect(Collectors.groupingBy(Person::getDestination));

        System.out.println("Destinatiile pasagerilor : ");
        destinatiiPasageri.forEach((destinatie,pasager)
                ->System.out.println("Destinatie : "+destinatie+" , Pasageri : "+pasager.toString()));
        System.out.println();


        //generare de persoane fake folosind javafaker
        FakeEverything generator = new FakeEverything();
        List<Person> peopleGenerated = generator.generatePeople(5);
        peopleGenerated.forEach(n->System.out.println(n));
        System.out.println();


        //problema
        Problem pb = new Problem();
        pb.setSoferi(soferi);
        pb.setPasageri(pasageri2);

        pb.Greedy();


    }
}
