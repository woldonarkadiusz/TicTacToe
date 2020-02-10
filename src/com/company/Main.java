package com.company;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            System.out.println("Welcome in Tic Tac Toe game :)");
            System.out.println("Set board size");
            int boardSize = new Scanner(System.in).nextInt();
            char [] [] board = new char [boardSize][boardSize];
            char playerSign;
            do {
                System.out.println("Select :  o  or  x");
                playerSign = new Scanner(System.in).next().charAt(0);

            }while (!(playerSign == 'x' || playerSign == 'o'));


            int moveCounter = 0;
            boolean ifContinue = true;
            while (ifContinue && moveCounter <= boardSize*boardSize) {
                printBoard(board);
                boolean ifCorrectMove = move(board, playerSign);
                if (ifCorrectMove){
                    moveCounter++;
                    boolean win =  ifWinColumn(board, playerSign) || ifWinRow(board, playerSign)
                            || ifWinDiagonal1(board, playerSign) || ifWinDiagonal2(board, playerSign);
                    if (win){
                        System.out.println(playerSign + " win");
                        printBoard(board);
                        System.out.println(playerSign + " win");
                        ifContinue = false;
                    }
                    playerSign = playerSign == 'x' ? 'o' : 'x';
                }
            }
        }

        public static boolean move (char [] [] board, char playerSign){

            System.out.println(playerSign + " Your turn");
            int row;
            do {
                System.out.println(playerSign + ", pick row no.");
                row = new Scanner(System.in).nextInt();
            }while (!(row < board.length));

            int column;
            do {
                System.out.println(playerSign + ", pick column no.");
                column = new Scanner(System.in).nextInt();

            }while (!(column < board.length));


            boolean correctMove = board[row][column] ==0;
            if (!correctMove){
                System.out.println("Incorrect move");
                return false;
            }
            board[row][column] = playerSign;
            return  true;
        }

        public  static void printBoard(char [] [] board){

            int boardSize = board.length;
//        System.out.print("\t");
            for (int i = 0; i < boardSize ; i++) {
                System.out.print("\t"+i);
            }
            System.out.println();

            for (int row = 0; row < board.length ; row++) {
                System.out.print(row + ":\t");

                for (int column = 0; column < board.length; column++) {
                    System.out.print(board[row][column] + "\t");
                }
                System.out.println();
            }
        }

        public static boolean ifWinRow(char [] [] board, char playerSign){
            for (int row = 0; row < board.length ; row++) {
                boolean win = true;
                for (int column = 0; column <board.length ; column++) {
                    if (board [row][column] != playerSign){
                        win = false;
                        break;
                    }
                }
                if (win){
                    return true;
                }
            }
            return false;
        }

        public static boolean ifWinColumn(char [] [] board, char playerSign){
            for (int column = 0; column < board.length ; column++) {
                boolean win = true;
                for (int row = 0; row <board.length ; row++) {
                    if (board [row][column] != playerSign){
                        win = false;
                        break;
                    }
                }
                if (win){
                    return true;
                }
            }
            return false;
        }

        public static boolean ifWinDiagonal1(char [] [] board, char playerSign){
            for (int i = 0; i < board.length ; i++) {
                if (board[i][i] != playerSign){
                    return false;
                }
            }
            return true;
        }

        public static boolean ifWinDiagonal2(char [] [] board, char playerSign){
            for (int i = 0; i < board.length; i++) {
                if (board[i][board.length - i - 1] != playerSign) {
                    return false;
                }
            }
            return true;
        }
}

