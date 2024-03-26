package org.example;

import java.io.File;
import java.util.List;
import java.util.Map;

public class DocumentRepository {
    private File path;
    private Map<Person, List<Document>> documents;

    public DocumentRepository(String pathMaster)
    {
        this.path= new File(pathMaster);
        if (!this.path.exists() || !this.path.isDirectory()) {
            System.out.println("Invalid master directory path");
        }
    }

    public void displayRepositoryContent() {
        File[] personDirectories = path.listFiles(File::isDirectory);
        if (personDirectories == null || personDirectories.length == 0) {
            System.out.println("Repository is empty");
            return;
        }

        System.out.println("Ce contine repo-ul:");
        for (File personDirectory : personDirectories) {
            System.out.println("- " + personDirectory.getName());
        }
    }
}
