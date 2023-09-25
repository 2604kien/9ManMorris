package src.game.models;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Board {
    //Initial empty board
    private String[][] board = {
            {"Col: ", "  1 ", "   2 ", "  3 ", "  4 ", "  5 ", "  6 ", "   7"},
            {"Row 1: ", "o", "------", "------", "o", "------", "------", "o"},
            {"Row 2: ", "|----", "o", "-------", "o", "-------", "o" , "----|"},
            {"Row 3: ", "|", "--------", "o--", "-o-", "--o", "--------", "|"},
            {"Row 4: ", "o----", "o---", "o", "-------", "o", "---o", "----o"},
            {"Row 5: ", "|", "--------", "o--", "-o-", "--o", "--------", "|"},
            {"Row 6: ", "|----", "o", "-------", "o", "-------", "o" , "----|"},
            {"Row 7: ", "o", "------", "------", "o", "------","------" ,"o"},
    };

    private ArrayList<Token> whiteTokenSet = new ArrayList<Token>();
    private ArrayList<Token> blackTokenSet = new ArrayList<Token>();
    private int whitePlayerTokenSetIndex = 0, blackPlayerTokenSetIndex = 0;

    public String[][] getBoard() {
        return board;
    }
    public void resetBoard(){
        String [][] resetBoard = {
                {"Col: ", "  1 ", "   2 ", "  3 ", "  4 ", "  5 ", "  6 ", "   7"},
                {"Row 1: ", "o", "------", "------", "o", "------", "------", "o"},
                {"Row 2: ", "|----", "o", "-------", "o", "-------", "o" , "----|"},
                {"Row 3: ", "|", "--------", "o--", "-o-", "--o", "--------", "|"},
                {"Row 4: ", "o----", "o---", "o", "-------", "o", "---o", "----o"},
                {"Row 5: ", "|", "--------", "o--", "-o-", "--o", "--------", "|"},
                {"Row 6: ", "|----", "o", "-------", "o", "-------", "o" , "----|"},
                {"Row 7: ", "o", "------", "------", "o", "------","------" ,"o"},
        };
        board=resetBoard;
    }
    public boolean setBoard(int row, int column, char colour) {
        if (row < 1 || row > 7 || column < 1 || column > 7) {
            return false;
        }

        String cell = board[row][column];
        if (!cell.contains("o")) {
            return false;
        }

        String newCell = "";
        for (int i = 0; i < cell.length(); i++) {
            char c = cell.charAt(i);
            if (c == 'o') {
                newCell += colour;
            } else {
                newCell += c;
            }
        }

        board[row][column] = newCell;
        return true;
    }

    public void removeTokenFromBoard(int row, int column) {
        if (board[row][column].contains("W") || board[row][column].contains("B")) {
            if (board[row][column].length() == 1) {
                board[row][column] = "o";
            } else if(board[row][column].contains("W") || board[row][column].contains("B")) {
                    board[row][column] = board[row][column].replaceAll("[WB]", "o");
                }
            }

    }

    @Override
    public String toString() {
        System.out.print("\n------------- BOARD -------------\n");

        // Convert the board from String array to String
        StringBuilder sb = new StringBuilder();
        for (String[] row : board) {
            for (String cell : row) {
                sb.append(cell);
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    /** MARK: Tokens **/
    //Initial white and black token set

    private ArrayList<String> whiteTokenSetDisplayed = new ArrayList<String>(9);
    private ArrayList<String> blackTokenSetDisplayed = new ArrayList<String>(9);

    public ArrayList<Token> getWhiteTokenSet() {
        return whiteTokenSet;
    }

    public void setWhiteTokenSet(ArrayList<Token> whiteTokenSet) {
        this.whiteTokenSet = whiteTokenSet;
    }

    public ArrayList<Token> getBlackTokenSet() {
        return blackTokenSet;
    }

    public void setBlackTokenSet(ArrayList<Token> blackTokenSet) {
        this.blackTokenSet = blackTokenSet;
    }

    public int getWhitePlayerTokenSetIndex() {
        return whitePlayerTokenSetIndex;
    }

    public int getBlackPlayerTokenSetIndex() {
        return blackPlayerTokenSetIndex;
    }

    public void addOneToWhitePlayerTokenSetIndex() {
        this.whitePlayerTokenSetIndex++;
    }

    public void addOneToBlackPlayerTokenSetIndex() {
        this.blackPlayerTokenSetIndex++;
    }

    public void removeOneTokenFromWhitePlayerTokenSet(){
        ArrayList<Token> newWhiteTokenSet = getWhiteTokenSet();
        newWhiteTokenSet.remove(0);
        setWhiteTokenSet(newWhiteTokenSet);
    }

    public void removeOneTokenFromBlackPlayerTokenSet(){
        ArrayList<Token> newBlackTokenSet = getBlackTokenSet();
        newBlackTokenSet.remove(0);
        setBlackTokenSet(newBlackTokenSet);
    }

    public int checkForRemainingToken(ArrayList <Token> tokenSet){
        return tokenSet.size();
    }

    //Add 9 tokens to each colour's token set
    public void addTokensToTokenSet(){

        whiteTokenSet.clear();
        blackTokenSet.clear();

        for (int i=0; i<9; i++){

            whiteTokenSet.add(new Token('W'));
        }
        for (int i=0; i<9; i++){
            blackTokenSet.add(new Token('B'));
        }
    }

    //Display each token set
    public void addTokenToDisplayTokenSet(char colour){
        // Adding 9 tokens depending on colour
        if (colour == 'W'){
            whiteTokenSetDisplayed.clear();
            for (int i=0; i <9; i++) {
                whiteTokenSetDisplayed.add("W");
            }
        }
        else if (colour == 'B'){
            blackTokenSetDisplayed.clear();
            for (int i=0; i <9; i++) {
                blackTokenSetDisplayed.add("B");
            }
        }
    }

    // Remove tokens from Player's hand
    public void removeTokenFromDisplayTokenSet(char colour){

        if (colour == 'W'){
                whiteTokenSetDisplayed.remove(0);
                whitePlayerTokenSetIndex--;
        }
        else if (colour == 'B'){
                blackTokenSetDisplayed.remove(0);
                blackPlayerTokenSetIndex--;
        }
    }


    // Display Available tokens on Player's hand
    public void displayTokenSet(char colour){
        if (colour == 'W'){
            System.out.println("White: [" + whiteTokenSetDisplayed.stream().collect(Collectors.joining(" / ")) + "]");
        }
        else if (colour == 'B'){
            System.out.println("Black: [" + blackTokenSetDisplayed.stream().collect(Collectors.joining(" / ")) + "]");
        }
    }


}
