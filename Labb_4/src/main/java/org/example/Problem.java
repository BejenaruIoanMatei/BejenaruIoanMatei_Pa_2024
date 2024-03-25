package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem {
    private List<Driver> soferi;
    private List<Person> pasageri;

    public Problem()
    {
        this.soferi = new ArrayList<>();
        this.pasageri = new ArrayList<>();
    }
    public Problem(List<Driver> soferi, List<Person> pasageri)
    {
        this.pasageri = pasageri;
        this.soferi = soferi;
    }

    public List<Driver> getSoferi() {
        return soferi;
    }

    public List<Person> getPasageri() {
        return pasageri;
    }

    public void setSoferi(List<Driver> soferi) {
        this.soferi = soferi;
    }

    public void setPasageri(List<Person> pasageri) {
        this.pasageri = pasageri;
    }

    public void Greedy()
    {
        for(Driver d : soferi)
        {
            for(Person p : pasageri)
            {
                if(d.getAvailableSeat())
                {

                    if(d.getDestination().equals(p.getDestination()))
                    {
                        System.out.println("Soferul " + d.getName() + " merge cu pasagerul " +
                                p.getName() + " catre destinatia " + d.getDestination());
                        d.setAvailableSeat(false);
                    }
                }
            }
        }
    }

}
