package org.example;

record Person (int id , String name) {

    @Override
    public int id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }
}