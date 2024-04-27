package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {

    private final Connection connection;

    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM authors";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
                // Set other fields...
                authors.add(author);
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return authors;
    }

    // Methods for create, update, delete...
}
