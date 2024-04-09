package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.addPlayer(new Player("Ana"));
        game.addPlayer(new Player("Mihai"));
        game.addPlayer(new Player("Marian"));

        game.play();
    }
}