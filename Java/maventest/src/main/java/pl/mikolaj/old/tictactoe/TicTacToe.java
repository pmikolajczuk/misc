package pl.mikolaj.old.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board =
                {{' ', ' ', ' '},
                 {' ', ' ', ' '},
                 {' ', ' ', ' '}};

        while(true) {
            printBoard(board);
            userMove(board);
            cpuMove(board);
            if(isGameFinished(board)) {
                printBoard(board);
                break;
            }
        }
    }

    private static boolean isGameFinished(char[][] board) {
        char token = 'X';
        //horizontal
        for(int i = 0; i < 3; i++) {
            int counter = 0;
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == token) {
                    counter++;
                }
            }
            if(counter == 3) {
                return true;
            }
        }
        return false;
    }

    private static void cpuMove(char[][] board) {
        while(true) {
            int move = new Random().nextInt(9);
            if(board[move / 3][move % 3] ==' ') {
                placeToken(move, 'O', board);
                break;
            }

        }

    }

    private static void userMove(char[][] board) {
        System.out.println("Where would you like to play");
        int move = new Scanner(System.in).nextInt();
        move--;
        placeToken(move, 'X', board);
    }

    private static void placeToken(int move, char token, char[][] board) {
        board[move / 3][move % 3] = token;
    }

    private static void printBoard(char[][] board) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if(j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i < 2) {
                System.out.println("-+-+-");
            }
        }
    }
}
