package org.example;

import java.util.Random;

public class GameBoard {
    private final char[][] board;

    //tabla de 10 pe 10
    public GameBoard() {
        board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = '~';
            }
        }
        placeShips();
    }

    //partea de plasat barci o fac random ca sa nu dureze prea mult jocul
    private void placeShips() {
        Random random = new Random();
        int shipsPlaced = 0;
        while (shipsPlaced < 5)
        {

            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (board[x][y] == '~') {
                board[x][y] = 'S';
                shipsPlaced++;
            }
        }
    }


    //partea de hit n miss
    public String receiveMove(int x, int y) {
        if (board[x][y] == '~') {
            board[x][y] = 'M';
            return "Miss";
        } else if (board[x][y] == 'S') {
            board[x][y] = 'H';
            return "Hit";
        }
        return "Already hit this spot"; // asta daca faci o mutare pe acelasi loc
    }

    public void printBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
