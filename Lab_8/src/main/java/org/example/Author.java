package org.example;

public class Author {
    private int id;
    private String name;
    // Alte atribute, cum ar fi email, data nașterii, etc.

    // Constructori, getteri și setteri

    public Author() {
        // Constructor implicit
    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getteri și setteri pentru fiecare atribut
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Metode pentru alte atribute

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                // Alte atribute
                '}';
    }
}
