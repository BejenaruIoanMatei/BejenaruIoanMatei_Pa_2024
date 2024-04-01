package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentRepository {
    private String path;
    private Map<Person, List<Document>> documents = new HashMap<>();

    public DocumentRepository(String pathMaster) throws InvalidRepositoryException {
        try {
            this.path = pathMaster;
            if (!new File(pathMaster).isDirectory()) {
                throw new InvalidRepositoryException(new Exception("Incorrect path provided"));
            }
        } catch (Exception e) {
            throw new InvalidRepositoryException(e);
        }
    }

    public void displayRepositoryFileNames(String path) {

        File repository = new File(path);
        List<Document> listaDoc = new ArrayList<>();
        if (!repository.isDirectory()) {
            System.out.println("Invalid path: Not a directory.");
            return;
        }
        File[] files = repository.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Repository is empty");
            return;
        }
        System.out.println("Files in repository:");
        int i = 0;
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("- " + file.getName());
                Person pers = new Person(i++,"Matei");
                Document docs = new Document(file.getName(), "file");
                listaDoc.add(docs);
                documents.put(pers,listaDoc);
            }
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<Person, List<Document>> getDocuments() {
        return documents;
    }

    public void setDocuments(Map<Person, List<Document>> documents) {
        this.documents = documents;
    }

}
