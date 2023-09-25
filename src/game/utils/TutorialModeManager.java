package src.game.utils;

import src.game.models.Board;

import java.util.Arrays;
import java.util.Scanner;

public class TutorialModeManager {
    public static int tutorialMenuItem(){
        int choice=0;

        Scanner sel = new Scanner(System.in);
        do {

            String menu = "";
            menu += "\n---------------------------------------";
            menu += " MENU ";
            menu += "---------------------------------------\n";
            System.out.print(menu);

            System.out.println("(1) What is Nine Men's Morris Game? / (2) How to Play? / (3) Play Game / (4) Exit");

            System.out.print("Please select one:");
            choice = Integer.parseInt(sel.nextLine());

            System.out.println("Your choice:" + choice);

            return choice;
        }
        while(choice!=1 && choice!=2 && choice!=3 && choice!=4);
    }
    public static void whatIsNineMensMorrisGame() {
        System.out.println("\n" +
                "Nine Men's Morris is an ancient strategy board game that has been played for centuries." +
                "It is also known as 'Mills' or 'Merels' in different regions.\n" +
                "The game is typically played on a board consisting of three concentric squares connected by lines at the midpoints of their sides and diagonals.\n" +
                "Each player starts with nine game pieces (usually called 'men') and takes turns placing their pieces on the board and trying to form 'mills'.");
    }
    public static void HowToPlay(){
        System.out.println("\n" +
                "1. Players: The game is played between two players, often referred to as \"White\" and \"Black\" or \"Light\" and \"Dark.\"\n" +
                "2. Board Setup: Start with an empty board consisting of three concentric squares connected by lines. Each player has nine pieces of a specific color.\n" +
                "3. Placing Phase: The game has two phases. In the first phase, players take turns placing their pieces on vacant spots on the board. The goal is to create a mill, which is a row of three pieces along one of the board's lines." +
                "\n   When a mill is formed, the player who created it can remove one of their opponent's pieces from the board.\n" +
                "4. Moving Phase: Once all pieces are placed on the board, the second phase begins. Players take turns moving their pieces along the lines to adjacent vacant spots. The goal remains the same: form mills and remove the opponent's pieces.\n" +
                "5. Flying Phase: When a player is reduced to only three pieces, they can \"fly\" their pieces, meaning they can move to any vacant spot on the board, not just adjacent ones.\n" +
                "6. Mill Formation: If a player forms a mill (three of their pieces in a row along a line), they can remove one of their opponent's pieces from the board. The removed piece must not be part of an opponent's mill unless all their pieces are in mills.\n" +
                "7. Blocking: Players can strategically place their pieces to block their opponent's moves and prevent them from forming mills.\n" +
                "8. Win Conditions: A player wins by either reducing the opponent to fewer than three pieces or by blocking the opponent's moves such that they cannot make a legal move.");
    }

    public static int hintMenuItem(){
        int choice=0;

        Scanner sel = new Scanner(System.in);
        do {
            String menu = "";
            menu += "\n-------------------------";
            menu += " MENU ";
            menu += "---------------------------\n";
            System.out.print(menu);

            System.out.println("(1) Hint: Where I can place/move/fly a token? / (2) No Hint");

            System.out.print("Please select one:");
            choice = Integer.parseInt(sel.nextLine());

            System.out.println("Your choice:" + choice);

            return choice;
        }
        while(choice!=1 && choice!=2 && choice!=3 && choice!=4);
    }
    public static void placeHint(String[][] board) {
        System.out.print("\n** A token can be placed where it is marked 'H'.");

        String[][] newBoard = Arrays.copyOf(board, board.length);
        for (int i = 1; i < newBoard.length; i++) {
            newBoard[i] = Arrays.copyOf(board[i], board[i].length);
            for (int j = 1; j < newBoard[i].length; j++) {
                if (newBoard[i][j].contains("o")) {
                    newBoard[i][j] = newBoard[i][j].replace("o", "H");
                }
            }
        }

        // Display the modified board
        System.out.print("\n------------- HINT BOARD -------------\n");
        for (String[] row : newBoard) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void moveHint(String[][] board, int fromRow, int fromColumn) {
        System.out.print("\n** A selected token can move to where it is marked 'H'.");
        System.out.print("\nSelected token's Row: " + fromRow);
        System.out.print("\nSelected token's Column: " + fromColumn +"\n");

        /** Copy board **/
        String[][] newBoard = Arrays.copyOf(board, board.length);
        for (int i = 1; i < newBoard.length; i++) {
            newBoard[i] = Arrays.copyOf(board[i], board[i].length);
            for (int j = 1; j < newBoard[i].length; j++) {
                newBoard[i][j] = String.valueOf(board[i][j]);
            }
        }

        /** Actual hint **/
        int i, j; //i = toRow, j = toColumn

        if (fromRow == 1 && fromColumn == 1){
            i = 1; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 1;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 1 && fromColumn == 4){
            i = 1; j = 1;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 2; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 1; j = 7;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 1 && fromColumn == 7){
            i = 1; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 7;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 2 && fromColumn == 2){
            i = 2; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 2;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 2 && fromColumn == 4){
            i = 2; j = 6;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 2; j = 2;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 1; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 3; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 2 && fromColumn == 6){
            i = 2; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 6;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 3 && fromColumn == 3){
            i = 3; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 3;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 3 && fromColumn == 4){
            i = 3; j = 3;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 2; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 3; j = 5;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 3 && fromColumn == 5){
            i = 3; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 5;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 4 && fromColumn == 1){
            i = 1; j = 1;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 2;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 7; j = 1;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 4 && fromColumn == 2){
            i = 2; j = 2;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 6; j = 2;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 1;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 3;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 4 && fromColumn == 3){
            i = 4; j = 2;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 3; j = 3;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 5; j = 3;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 4 && fromColumn == 5){
            i = 3; j = 5;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 5; j = 5;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 6;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 4 && fromColumn == 6){
            i = 4; j = 5;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 7;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 2; j = 6;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 6; j = 6;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 4 && fromColumn == 7){
            i = 4; j = 6;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 1; j = 7;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 7; j = 7;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 5 && fromColumn == 3){
            i = 4; j = 3;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 5; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 5 && fromColumn == 4){
            i = 5; j = 3;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 5; j = 5;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 6; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 5 && fromColumn == 5){
            i = 5; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 5;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 6 && fromColumn == 2){
            i = 4; j = 2;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 6; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 6 && fromColumn == 4){
            i = 5; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 7; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 6; j = 2;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 6; j = 6;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 6 && fromColumn == 6){
            i = 4; j = 6;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 6; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 7 && fromColumn == 1){
            i = 4; j = 1;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 7; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 7 && fromColumn == 4){
            i = 7; j = 1;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 6; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 7; j = 7;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }

        if (fromRow == 7 && fromColumn == 7){
            i = 7; j = 4;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
            i = 4; j = 7;
            if (newBoard[i][j].contains("o")) {
                newBoard[i][j] = newBoard[i][j].replace("o", "H");
            }
        }


        /** Display the modified board **/
        System.out.print("\n------------- HINT BOARD -------------\n");
        for (String[] row : newBoard) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void flyHint(String[][] board) {
        //Almost same as placeHint method.
        System.out.print("\n** A token can fly where it is marked 'H'.");

        String[][] newBoard = Arrays.copyOf(board, board.length);
        for (int i = 1; i < newBoard.length; i++) {
            newBoard[i] = Arrays.copyOf(board[i], board[i].length);
            for (int j = 1; j < newBoard[i].length; j++) {
                if (newBoard[i][j].contains("o")) {
                    newBoard[i][j] = newBoard[i][j].replace("o", "H");
                }
            }
        }

        // Display the modified board
        System.out.print("\n------------- HINT BOARD -------------\n");
        for (String[] row : newBoard) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


}
