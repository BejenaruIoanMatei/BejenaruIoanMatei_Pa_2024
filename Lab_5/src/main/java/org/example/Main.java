package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvalidRepositoryException {
        String repoPath = "/Users/user/Documents/GitHub/BejenaruIoanMatei_Pa_2024/Lab_5/masterDirectory";
        DocumentRepository repo = new DocumentRepository(repoPath);

        repo.displayRepositoryFileNames(repoPath);
        new Shell(repo).start();
    }
}

