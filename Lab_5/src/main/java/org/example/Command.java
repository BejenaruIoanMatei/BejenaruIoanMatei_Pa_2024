package org.example;

interface Command {
    void execute(DocumentRepository repo) throws Exception;
}
