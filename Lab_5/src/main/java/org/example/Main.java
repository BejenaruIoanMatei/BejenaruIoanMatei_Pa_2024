package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            DocumentRepository repo = new DocumentRepository("/Users/user/Documents/GitHub/BejenaruIoanMatei_Pa_2024/Lab_5/masterDirectory");
            repo.displayRepositoryContent();
        }catch (Exception e)
        {
            System.out.println("Eroare la repo");
        }
    }
}