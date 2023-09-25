package src.game.utils;

public class MoveManager {
    public static boolean moveValidation(String[][] board, int fromRow, int fromColumn, int toRow, int toColumn) {
        boolean isValid = false;

        if (fromRow == 1 && fromColumn == 1){
            if (toRow == 1 && toColumn == 4 || toRow == 4 && toColumn == 1) {
                isValid = true;
            }
        }
        if (fromRow == 1 && fromColumn == 4){
            if (toRow == 1 && toColumn == 1 || toRow == 2 && toColumn == 4 || toRow == 1 && toColumn == 7) {
                isValid = true;
            }
        }
        if (fromRow == 1 && fromColumn == 7){
            if (toRow == 1 && toColumn == 4 || toRow == 4 && toColumn == 7) {
                isValid = true;
            }
        }
        if (fromRow == 2 && fromColumn == 2){
            if (toRow == 2 && toColumn == 4 || toRow == 4 && toColumn == 2) {
                isValid = true;
            }
        }
        if (fromRow == 2 && fromColumn == 4){
            if (toRow == 2 && toColumn == 6 || toRow == 2 && toColumn == 2 || toRow == 1 && toColumn == 4 || toRow == 3 && toColumn == 4) {
                isValid = true;
            }
        }
        if (fromRow == 2 && fromColumn == 6){
            if (toRow == 2 && toColumn == 4 || toRow == 4 && toColumn == 6) {
                isValid = true;
            }
        }
        if (fromRow == 3 && fromColumn == 3){
            if (toRow == 3 && toColumn == 4 || toRow == 4 && toColumn == 3) {
                isValid = true;
            }
        }
        if (fromRow == 3 && fromColumn == 4){
            if (toRow == 3 && toColumn == 3 || toRow == 2 && toColumn == 4 || toRow == 3 && toColumn == 5) {
                isValid = true;
            }
        }
        if (fromRow == 3 && fromColumn == 5){
            if (toRow == 3 && toColumn == 4 || toRow == 4 && toColumn == 5) {
                isValid = true;
            }
        }
        if (fromRow == 4 && fromColumn == 1){
            if (toRow == 1 && toColumn == 1 || toRow == 4 && toColumn == 2 || toRow == 7 && toColumn == 1) {
                isValid = true;
            }
        }
        if (fromRow == 4 && fromColumn == 2){
            if (toRow == 2 && toColumn == 2 || toRow == 6 && toColumn == 2 || toRow == 4 && toColumn == 1 || toRow == 4 && toColumn == 3) {
                isValid = true;
            }
        }
        if (fromRow == 4 && fromColumn == 3){
            if (toRow == 4 && toColumn == 2 || toRow == 3 && toColumn == 3 || toRow == 5 && toColumn == 3) {
                isValid = true;
            }
        }
        if (fromRow == 4 && fromColumn == 5){
            if (toRow == 3 && toColumn == 5 || toRow == 5 && toColumn == 5 || toRow == 4 && toColumn == 6) {
                isValid = true;
            }
        }
        if (fromRow == 4 && fromColumn == 6){
            if (toRow == 4 && toColumn == 5 || toRow == 4 && toColumn == 7 || toRow == 2 && toColumn == 6 || toRow == 6 && toColumn == 6) {
                isValid = true;
            }
        }
        if (fromRow == 4 && fromColumn == 7){
            if (toRow == 4 && toColumn == 6 || toRow == 1 && toColumn == 7 || toRow == 7 && toColumn == 7) {
                isValid = true;
            }
        }
        if (fromRow == 5 && fromColumn == 3){
            if (toRow == 4 && toColumn == 3 || toRow == 5 && toColumn == 4) {
                isValid = true;
            }
        }
        if (fromRow == 5 && fromColumn == 4){
            if (toRow == 5 && toColumn == 3 || toRow == 5 && toColumn == 5 || toRow == 6 && toColumn == 4) {
                isValid = true;
            }
        }
        if (fromRow == 5 && fromColumn == 5){
            if (toRow == 5 && toColumn == 4 || toRow == 4 && toColumn == 5) {
                isValid = true;
            }
        }
        if (fromRow == 6 && fromColumn == 2){
            if (toRow == 4 && toColumn == 2 || toRow == 6 && toColumn == 4) {
                isValid = true;
            }
        }
        if (fromRow == 6 && fromColumn == 4){
            if (toRow == 5 && toColumn == 4 || toRow == 7 && toColumn == 4 || toRow == 6 && toColumn == 2 || toRow == 6 && toColumn == 6) {
                isValid = true;
            }
        }
        if (fromRow == 6 && fromColumn == 6){
            if (toRow == 4 && toColumn == 6 || toRow == 6 && toColumn == 4) {
                isValid = true;
            }
        }
        if (fromRow == 7 && fromColumn == 1){
            if (toRow == 4 && toColumn == 1 || toRow == 7 && toColumn == 4) {
                isValid = true;
            }
        }
        if (fromRow == 7 && fromColumn == 4){
            if (toRow == 7 && toColumn == 1 || toRow == 6 && toColumn == 4 || toRow == 7 && toColumn == 7) {
                isValid = true;
            }
        }
        if (fromRow == 7 && fromColumn == 7){
            if (toRow == 7 && toColumn == 4 || toRow == 4 && toColumn == 7) {
                isValid = true;
            }
        }


        return isValid;
    }
}
