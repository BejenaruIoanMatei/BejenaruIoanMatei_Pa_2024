package org.example;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection connection = Database.getConnection();

        AuthorDAO authorDAO = new AuthorDAO(connection);

        Author author1 = new Author(1, "Ion Creangă");
        Author author2 = new Author(2, "Mihai Eminescu");

        List<Author> authors = authorDAO.getAllAuthors();
        for (Author author : authors) {
            System.out.println(author);
        }
        Database.closeConnection();
        //skibidi
    }
}
