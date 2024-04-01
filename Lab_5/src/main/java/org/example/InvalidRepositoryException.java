package org.example;

public class InvalidRepositoryException extends Exception{
    public InvalidRepositoryException(Exception E)
    {
        super("Repo ul este invalid.", E);
    }
}
