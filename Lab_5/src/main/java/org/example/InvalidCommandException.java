package org.example;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(Exception E)
    {
        super("Comanda este invalida.",E);
    }
}
