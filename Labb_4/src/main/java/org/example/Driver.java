package org.example;


public class Driver extends Person {
    private boolean availableSeat;

    public Driver(String name, int age, String destination, boolean availableSeat) {
        super(name, age, destination);
        this.availableSeat = availableSeat;
    }

    public boolean getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(boolean availableSeat) {
        this.availableSeat = availableSeat;
    }


    @Override
    public String toString() {
        return super.toString() + ", Am loc : " + availableSeat;
    }
}