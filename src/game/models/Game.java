package src.game.models;

import src.game.players.Player;
import src.game.utils.GameManager;
import src.game.utils.MoveManager;
import src.game.utils.TutorialModeManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Board board = new Board();
    public Board getBoard() {
        return board;
    }

    private Player whitePlayer = new Player ("White Player", 'W', 9);
    private Player blackPlayer = new Player ("Black Player", 'B', 9);
    private Player chosenPlayer;
    private boolean millIsNotCreatedYet =true;
    private int currentRow=0, currentColumn=0;
    private boolean isBlack=false;

    /** Tutorial Mode properties **/
    private boolean tutorialModeSelected = false;

    public boolean getTutorialModeSelected() {
        return tutorialModeSelected;
    }
    public void setTutorialModeSelected(boolean tutorialModeSelected) {
        this.tutorialModeSelected = tutorialModeSelected;
    }



    /** Game Play methods **/
    public void chooseMode(){
        int selection;
        do {
            selection = GameManager.chooseModeItem();
            switch (selection) {
                case 1:
                    setTutorialModeSelected(false);
                    run();
                    break;
                case 2:
                    setTutorialModeSelected(true);
                    run();
                    break;
            }
        }
        while (selection != 3);
    }

    public void run(){

        //Add NINE tokens to each colour's token set (not player)
        board.addTokensToTokenSet();

        //Add NINE tokens to display token set
        board.addTokenToDisplayTokenSet('W');
        board.addTokenToDisplayTokenSet('B');

        /** Display **/
        //Display mode
        if (getTutorialModeSelected()) {
            System.out.println("\n--------- TUTORIAL MODE has been selected---------");
            board.resetBoard();
            int selection;
            do {
                selection = TutorialModeManager.tutorialMenuItem();
                switch (selection) {
                    case 1:
                        TutorialModeManager.whatIsNineMensMorrisGame();
                        break;
                    case 2:
                        TutorialModeManager.HowToPlay();
                        break;
                    case 4:
                        System.exit(1);
                }
            }
            while (selection != 3);
        }
        else {
            System.out.println("\n--------- NORMAL MODE has been selected---------");
            board.resetBoard();
        }

        //Display board
        System.out.println(board);

        //Display Tokens to be placed in set
        System.out.print("---------- Tokens to be placed ----------\n");
        board.displayTokenSet('W');
        board.displayTokenSet('B');

        //Display Remaining Tokens
        String remainingTokens;
        remainingTokens = "\n-- Remaining Tokens --\n";
        remainingTokens += "White: " + Integer.toString(board.checkForRemainingToken(board.getWhiteTokenSet()));
        remainingTokens += "  Black: " + board.checkForRemainingToken(board.getBlackTokenSet()) + "\n";
        System.out.print(remainingTokens);

        int selection;
        do {
            endTheGame(board.getWhiteTokenSet(), board.getBlackTokenSet());

            selection = GameManager.menuItem();
            switch (selection) {
                    case 1:
                        choosePlayer();
                        break;
                    case 2:
                        placeTokenOnBoard();
                        break;
                    case 3:
                        moveTokenOnBoard();
                        break;
                    case 4:
                        flyTokenOnBoard();
                        break;
                }
        }
        while (selection != 5);

    }

    public void choosePlayer(){
        int playerNumber;
        String playerNumberString;
        currentRow=0;
        currentColumn=0;
        Scanner sel = new Scanner(System.in);
        System.out.print("\n------- INSTRUCTION (Choose a Player) -------\n");
        System.out.print("Enter a player number\n");
        System.out.print("1 (WHITE) or 2 (BLACK): ");
        playerNumberString = sel.nextLine();
        playerNumber = Integer.parseInt(playerNumberString);
        if (playerNumber == 1){
            chosenPlayer = whitePlayer;
        }
        else if (playerNumber == 2){
            chosenPlayer = blackPlayer;
        }
    }



    public void placeTokenOnBoard(){
        /** Tutorial Mode **/

        /** Actual Playing **/
        ArrayList<Token> newWhiteTokenSet = board.getWhiteTokenSet();
        ArrayList<Token> newBlackTokenSet = board.getBlackTokenSet();
        currentRow=0;
        currentColumn=0;
        Token chosenToken = new Token();
        int row = 0, column = 0;
        String rowString, columnString;

        if (chosenPlayer == whitePlayer && isBlack==false){
            if (getTutorialModeSelected()){
                int selection;
                do {
                    selection = TutorialModeManager.hintMenuItem();
                    switch (selection) {
                        case 1:
                            TutorialModeManager.placeHint(board.getBoard());
                            break;
                    }
                }
                while (selection != 2);
            }

            chosenToken = newWhiteTokenSet.get(board.getWhitePlayerTokenSetIndex());
            Scanner sel = new Scanner(System.in);

            System.out.println(board); //Display the board
            System.out.print("------- INSTRUCTION (Place a Token) -------\n");
            System.out.print("Place a WHITE token on the board\n");

            do{
            System.out.print("Choose a Row (Type only Number between 1 to 7): ");
            rowString = sel.nextLine();
            row = Integer.parseInt(rowString);
            currentRow=row;
            }
            while(1>row||row>7);
            do{
            System.out.print("Choose a Column (Type only Number between 1 to 7): ");
            columnString = sel.nextLine();
            column = Integer.parseInt(columnString);
            currentColumn=column;
            }
            while(1>column||column>7);
            moveTokenFromTokenSetToBoard(whitePlayer);
            isBlack=true;
            System.out.print("\nNow, It's BLACK's turn\n");
            System.out.print("Choose a Player with BLACK\n");
        }

        else if (chosenPlayer == blackPlayer && isBlack==true){
            if (getTutorialModeSelected()){
                int selection;
                do {
                    selection = TutorialModeManager.hintMenuItem();
                    switch (selection) {
                        case 1:
                            TutorialModeManager.placeHint(board.getBoard());
                            break;
                    }
                }
                while (selection != 2);
            }

            chosenToken = newBlackTokenSet.get(board.getBlackPlayerTokenSetIndex());
            Scanner sel = new Scanner(System.in);

            System.out.println(board); //Display the board
            System.out.print("------- INSTRUCTION (Place a Token) -------\n");
            System.out.print("Place a BLACK token on the board\n");

            do{
            System.out.print("Choose a Row (Type only Number between 1 to 7): ");
            rowString = sel.nextLine();
            row = Integer.parseInt(rowString);
            currentRow=row;
            }
            while(1>row||row>7);
            do{
            System.out.print("Choose a Column (Type only Number between 1 to 7): ");
            columnString = sel.nextLine();
            column = Integer.parseInt(columnString);
            currentColumn=column;
            }
            while(1>row||row>7);
            moveTokenFromTokenSetToBoard(blackPlayer);
            isBlack=false;
            System.out.print("\nNow, It's WHITE's turn\n");
            System.out.print("Choose a Player with WHITE\n");
        }

        boolean flag = addTokenToBoard(row, column);
        if(flag && chosenPlayer == whitePlayer){
            board.removeTokenFromDisplayTokenSet('W');
        } else if (flag && chosenPlayer == blackPlayer) {
            board.removeTokenFromDisplayTokenSet('B');
        }

        Position newPosition = new Position(row, column);
        chosenToken.setPosition(newPosition);

        /** Display **/
        //Display board
        System.out.println(board);

        //Display Tokens to be placed in set
        System.out.print("---------- Tokens to be placed ----------\n");
        board.displayTokenSet('W');
        board.displayTokenSet('B');

        //Check for mill
        if ((checkMil(board.getBoard(), "W") || checkMil(board.getBoard(), "B"))) {
        if ((checkForMill(board.getBoard(), "W") || checkForMill(board.getBoard(), "B"))) {
            removeTokenByMill();
            millIsNotCreatedYet = false;
            currentColumn=0;
            currentRow=0;
        }
        }

        //Display Remaining Tokens
        String remainingTokens;
        remainingTokens = "\n-- Remaining Tokens --\n";
        remainingTokens += "White: " + Integer.toString(board.checkForRemainingToken(board.getWhiteTokenSet()));
        remainingTokens += "  Black: " + board.checkForRemainingToken(board.getBlackTokenSet()) + "\n";
        System.out.print(remainingTokens);

    }

    public void moveTokenOnBoard(){
        ArrayList<Token> newWhiteTokenSet = board.getWhiteTokenSet();
        ArrayList<Token> newBlackTokenSet = board.getBlackTokenSet();
        currentRow=0;
        currentColumn=0;
        Token chosenToken;
        int fromRow = 0, fromColumn = 0, toRow = 0, toColumn = 0;
        String fromRowString, fromColumnString, toRowString, toColumnString;

        if (chosenPlayer == whitePlayer && isBlack==false){
            chosenToken = newWhiteTokenSet.get(board.getWhitePlayerTokenSetIndex());
            Position chosenTokenCurrentPosition = chosenToken.getPosition();

            Scanner sel = new Scanner(System.in);

            System.out.println(board); //Display the board
            System.out.print("------- INSTRUCTION (Move a Token) -------\n");
            System.out.print("Select a token you want to move\n");

            do{
            System.out.print("Choose a Row (Type only Number between 1 to 7): ");
            fromRowString = sel.nextLine();
            fromRow = Integer.parseInt(fromRowString);
            }
            while(1>fromRow||fromRow>7);
            do{
            System.out.print("Choose a Column (Type only Number between 1 to 7): ");
            fromColumnString = sel.nextLine();
            fromColumn = Integer.parseInt(fromColumnString);
            }
            while(1>fromColumn||fromColumn>7);

            /** Tutorial Mode **/
            if (getTutorialModeSelected()){
                int selection;
                do {
                    selection = TutorialModeManager.hintMenuItem();
                    switch (selection) {
                        case 1:
                            TutorialModeManager.moveHint(board.getBoard(), fromRow, fromColumn);
                            break;
                    }
                }
                while (selection != 2);
            }

            System.out.print("\nChoose where the selected token will move\n");
            do{
            System.out.print("Choose a Row (Type only Number between 1 to 7): ");
            toRowString = sel.nextLine();
            toRow = Integer.parseInt(toRowString);
            currentRow=toRow;
            }
            while(1>toRow||toRow>7);
            do {
                System.out.print("Choose a Column (Type only Number between 1 to 7): ");
                toColumnString = sel.nextLine();
                toColumn = Integer.parseInt(toColumnString);
                currentColumn=toColumn;
            }
            while(1>toColumn||toColumn>7);

            // Check Move Validation
            if (MoveManager.moveValidation(board.getBoard(), fromRow, fromColumn, toRow, toColumn)) {
                board.removeTokenFromBoard(fromRow, fromColumn);
                addTokenToBoard(toRow, toColumn);
                Position chosenTokenNewPosition = new Position(toRow, toColumn);
                Move move = new Move(chosenToken, chosenTokenCurrentPosition, chosenTokenNewPosition);
                if ((checkMil(board.getBoard(), "W") || checkMil(board.getBoard(), "B"))) {
                    if (checkForMill(board.getBoard(), "W") || checkForMill(board.getBoard(), "B")) {
                        removeTokenByMill();
                        millIsNotCreatedYet = false;
                        currentColumn=0;
                        currentRow=0;
                    }
                }
                isBlack=true;
                System.out.print("\nNow, It's BLACK's turn\n");
                System.out.print("Choose a Player with BLACK\n");
            }
            else {
                System.out.print("\n!!! ERROR: WRONG MOVE!!!");
                System.out.print("\nPlease select an adjacent position of the token.\n");
            }
            isBlack=true;
        }

        else if (chosenPlayer == blackPlayer && isBlack==true){
            chosenToken = newBlackTokenSet.get(board.getBlackPlayerTokenSetIndex());
            Position chosenTokenCurrentPosition = chosenToken.getPosition();

            Scanner sel = new Scanner(System.in);

            System.out.println(board); //Display the board
            System.out.print("------- INSTRUCTION (Move a Token) -------\n");
            System.out.print("Select a token you want to move\n");

            System.out.print("Choose a Row (Type only Number between 1 to 7): ");
            fromRowString = sel.nextLine();
            fromRow = Integer.parseInt(fromRowString);
            System.out.print("Choose a Column (Type only Number between 1 to 7): ");
            fromColumnString = sel.nextLine();
            fromColumn = Integer.parseInt(fromColumnString);

            /** Tutorial Mode **/
            if (getTutorialModeSelected()){
                int selection;
                do {
                    selection = TutorialModeManager.hintMenuItem();
                    switch (selection) {
                        case 1:
                            TutorialModeManager.moveHint(board.getBoard(), fromRow, fromColumn);
                            break;
                    }
                }
                while (selection != 2);
            }

            System.out.print("\nChoose where the selected token will move\n");
            System.out.print("Choose a Row (Type only Number between 1 to 7): ");
            toRowString = sel.nextLine();
            toRow = Integer.parseInt(toRowString);
            currentRow=toRow;
            System.out.print("Choose a Column (Type only Number between 1 to 7): ");
            toColumnString = sel.nextLine();
            toColumn = Integer.parseInt(toColumnString);
            currentColumn=toColumn;

            // Check Move Validation
            if (MoveManager.moveValidation(board.getBoard(), fromRow, fromColumn, toRow, toColumn)) {
                board.removeTokenFromBoard(fromRow, fromColumn);
                addTokenToBoard(toRow, toColumn);
                Position chosenTokenNewPosition = new Position(toRow, toColumn);
                Move move = new Move(chosenToken, chosenTokenCurrentPosition, chosenTokenNewPosition);
                if ((checkMil(board.getBoard(), "W") || checkMil(board.getBoard(), "B"))) {
                    if (checkForMill(board.getBoard(), "W") || checkForMill(board.getBoard(), "B")) {
                        removeTokenByMill();
                        millIsNotCreatedYet = false;
                        currentColumn=0;
                        currentRow=0;
                    }
                }
                isBlack=false;
                System.out.print("\nNow, It's WHITE's turn\n");
                System.out.print("Choose a Player with WHITE\n");
            }
            else {
                System.out.print("\n!!! ERROR: WRONG MOVE!!!");
                System.out.print("\nPlease select an adjacent position of the token.\n");
            }
            isBlack=false;
        }

        /** Display **/
        //Display board
        System.out.println(board);

        //Display Tokens to be placed in set
        System.out.print("---------- Tokens to be placed ----------\n");
        board.displayTokenSet('W');
        board.displayTokenSet('B');

        //Check for mill
        if ((checkMil(board.getBoard(), "W") || checkMil(board.getBoard(), "B"))) {
            if ((checkForMill(board.getBoard(), "W") || checkForMill(board.getBoard(), "B"))) {
                removeTokenByMill();
                millIsNotCreatedYet = false;
                currentColumn = 0;
                currentRow = 0;
            }
        }
        //Display Remaining Tokens
        String remainingTokens;
        remainingTokens = "\n-- Remaining Tokens --\n";
        remainingTokens += "White: " + Integer.toString(board.checkForRemainingToken(board.getWhiteTokenSet()));
        remainingTokens += "  Black: " + board.checkForRemainingToken(board.getBlackTokenSet()) + "\n";
        System.out.print(remainingTokens);
    }

    public void flyTokenOnBoard(){

        /** Actual Playing **/
        ArrayList<Token> newWhiteTokenSet = board.getWhiteTokenSet();
        ArrayList<Token> newBlackTokenSet = board.getBlackTokenSet();
        currentRow=0;
        currentColumn=0;
        Token chosenToken;
        int newRow = 0, newColumn = 0;
        String newRowString, newColumnString;

        if (chosenPlayer == whitePlayer&& isBlack==false){
            /** Tutorial Mode **/
            if (getTutorialModeSelected()){
                int selection;
                do {
                    selection = TutorialModeManager.hintMenuItem();
                    switch (selection) {
                        case 1:
                            TutorialModeManager.flyHint(board.getBoard());
                            break;
                    }
                }
                while (selection != 2);
            }

            chosenToken = newWhiteTokenSet.get(board.getWhitePlayerTokenSetIndex());
            Position chosenTokenCurrentPosition = chosenToken.getPosition();
            Scanner sel = new Scanner(System.in);

            System.out.println(board); //Display the board
            System.out.print("------- INSTRUCTION (Fly a Token) -------\n");
            System.out.print("Select a token you want to fly\n");

            do{
            System.out.print("Choose a Row (Type only Number between 1 to 7): ");
            newRowString = sel.nextLine();
            newRow = Integer.parseInt(newRowString);
            currentRow=newRow;
            }
            while(1>newRow||newRow>7);
            do {
                System.out.print("Choose a Column (Type only Number between 1 to 7): ");
                newColumnString = sel.nextLine();
                newColumn = Integer.parseInt(newColumnString);
                currentColumn=newColumn;
            }
            while(1>newColumn||newColumn>7);
            board.removeTokenFromBoard(newRow, newColumn);

            System.out.print("Choose where the selected token will fly\n");
            do {
                System.out.print("Choose a Row (Type only Number between 1 to 7): ");
                newRowString = sel.nextLine();
                newRow = Integer.parseInt(newRowString);
                currentRow=newRow;
            }
            while(1>newRow||newRow>7);
            do{
                System.out.print("Choose a Column (Type only Number between 1 to 7): ");
                newColumnString = sel.nextLine();
                newColumn = Integer.parseInt(newColumnString);
                currentColumn=newColumn;
            }
            while(1>newColumn||newColumn>7);
            addTokenToBoard(newRow, newColumn);
            Position chosenTokenNewPosition = new Position(newRow, newColumn);
            Move move = new Move(chosenToken, chosenTokenCurrentPosition, chosenTokenNewPosition);
            isBlack=true;
            System.out.print("\nNow, It's BLACK's turn\n");
            System.out.print("Choose a Player with BLACK\n");
        }
        else if (chosenPlayer == blackPlayer && isBlack==true){
            /** Tutorial Mode **/
            if (getTutorialModeSelected()){
                int selection;
                do {
                    selection = TutorialModeManager.hintMenuItem();
                    switch (selection) {
                        case 1:
                            TutorialModeManager.flyHint(board.getBoard());
                            break;
                    }
                }
                while (selection != 2);
            }

            chosenToken = newBlackTokenSet.get(board.getBlackPlayerTokenSetIndex());
            Position chosenTokenCurrentPosition = chosenToken.getPosition();
            Scanner sel = new Scanner(System.in);

            System.out.println(board); //Display the board
            System.out.print("------- INSTRUCTION (Fly a Token) -------\n");
            System.out.print("Select a token you want to fly\n");

            do{
            System.out.print("Choose a Row (Type only Number between 1 to 7): ");
            newRowString = sel.nextLine();
            newRow = Integer.parseInt(newRowString);
            currentRow=newRow;
            }
            while(1>newRow||newRow>7);
            do{
            System.out.print("Choose a Column (Type only Number between 1 to 7): ");
            newColumnString = sel.nextLine();
            newColumn = Integer.parseInt(newColumnString);
            currentColumn=newColumn;
            }
            while(1>newColumn||newColumn>7);
            board.removeTokenFromBoard(newRow, newColumn);

            System.out.print("Choose where the selected token will fly\n");
            do{
            System.out.print("Choose a Row (Type only Number between 1 to 7): ");
            newRowString = sel.nextLine();
            newRow = Integer.parseInt(newRowString);
            currentRow=newRow;
            }
            while(1>newRow||newRow>7);
            do{
            System.out.print("Choose a Column (Type only Number between 1 to 7): ");
            newColumnString = sel.nextLine();
            newColumn = Integer.parseInt(newColumnString);
            currentColumn=newColumn;
            }
            while(1>newColumn||newColumn>7);

            addTokenToBoard(newRow, newColumn);
            Position chosenTokenNewPosition = new Position(newRow, newColumn);
            Move move = new Move(chosenToken, chosenTokenCurrentPosition, chosenTokenNewPosition);
            isBlack=false;
            System.out.print("\nNow, It's WHITE's turn\n");
            System.out.print("Choose a Player with WHITE\n");
        }

        /** Display **/
        //Display board
        System.out.println(board);

        //Display Tokens to be placed in set
        System.out.print("---------- Tokens to be placed ----------\n");
        board.displayTokenSet('W');
        board.displayTokenSet('B');
        if ((checkMil(board.getBoard(), "W") || checkMil(board.getBoard(), "B"))) {
        //Check for mill
        if ((checkForMill(board.getBoard(), "W") || checkForMill(board.getBoard(), "B"))) {
            removeTokenByMill();
            millIsNotCreatedYet = false;
            currentColumn=0;
            currentRow=0;
        }
        }

        //Display Remaining Tokens
        String remainingTokens;
        remainingTokens = "\n-- Remaining Tokens --\n";
        remainingTokens += "White: " + Integer.toString(board.checkForRemainingToken(board.getWhiteTokenSet()));
        remainingTokens += "  Black: " + board.checkForRemainingToken(board.getBlackTokenSet()) + "\n";
        System.out.print(remainingTokens);
    }


    public boolean addTokenToBoard(int row, int column){
        boolean flag = false;
        if (chosenPlayer == whitePlayer){
            flag = board.setBoard(row, column, 'W');
        }
        else if (chosenPlayer == blackPlayer){
            flag = board.setBoard(row, column, 'B');
        }
        return flag;
    }

    public void moveTokenFromTokenSetToBoard(Player player){
        if (player == whitePlayer){
            board.addOneToWhitePlayerTokenSetIndex();
        }
        else if (player == blackPlayer){
            board.addOneToBlackPlayerTokenSetIndex();
        }
    }

    public void removeTokenByMill (){
        int chosenRow = 0, chosenColumn = 0;
        String chosenRowString, chosenColumnString;

        System.out.print("\n---------------------------\n");
        System.out.print("------- INSTRUCTION -------");
        System.out.print("\n---------------------------\n");

        Scanner sel = new Scanner(System.in);
        System.out.print("Please choose the opponent's token to remove\n");
        System.out.print("Choose a Row (Type only Number between 1 to 7): ");
        chosenRowString = sel.nextLine();
        chosenRow = Integer.parseInt(chosenRowString);
        System.out.print("Choose a Column (Type only Number between 1 to 7): ");
        chosenColumnString = sel.nextLine();
        chosenColumn = Integer.parseInt(chosenColumnString);

        // Removing chosen token from the board
        board.removeTokenFromBoard(chosenRow, chosenColumn);

        // Removing chosen token from Token Set
        if (chosenPlayer == whitePlayer){
            board.removeOneTokenFromBlackPlayerTokenSet();
        }
        else if (chosenPlayer == blackPlayer){
            board.removeOneTokenFromWhitePlayerTokenSet();
        }

        System.out.print("\n-------------------------------------\n");
        System.out.print("The opponent's token has been removed\n");
        System.out.print("-------------------------------------\n");

        //Display board
        System.out.println(board);
    }

    public boolean checkForMill(String[][] board, String colour) {
        boolean millIsFormed = false;
        String str = "\n-------------------------------------\n";
        str += "*** Mill has been formed ***";
        //str += "--------------------------------------------------------------\n";

        ArrayList <Token> tokenSetOfMill= new ArrayList();

        // Horizontal mills
        if (board[1][1].contains(colour) && board[1][4].contains(colour) && board[1][7].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[2][2].contains(colour) && board[2][4].contains(colour) && board[2][6].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[3][3].contains(colour) && board[3][4].contains(colour) && board[3][5].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[4][1].contains(colour) && board[4][2].contains(colour) && board[4][3].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[4][5].contains(colour) && board[4][6].contains(colour) && board[4][7].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[5][3].contains(colour) && board[5][4].contains(colour) && board[5][5].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[6][2].contains(colour) && board[6][4].contains(colour) && board[6][6].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[7][1].contains(colour) && board[7][4].contains(colour) && board[7][7].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }

        // Vertical mills
        if (board[1][1].contains(colour) && board[4][1].contains(colour) && board[7][1].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[2][2].contains(colour) && board[4][2].contains(colour) && board[6][2].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[3][3].contains(colour) && board[4][3].contains(colour) && board[5][3].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[1][4].contains(colour) && board[2][4].contains(colour) && board[3][4].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[5][4].contains(colour) && board[6][4].contains(colour) && board[7][4].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }

        if (board[3][5].contains(colour) && board[4][5].contains(colour) && board[5][5].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[2][6].contains(colour) && board[4][6].contains(colour) && board[6][6].contains(colour)){
            System.out.print(str);
            millIsFormed = true;
        }
        if (board[1][7].contains(colour) && board[4][7].contains(colour) && board[7][7].contains(colour)) {
            System.out.print(str);
            millIsFormed = true;
        }
        return millIsFormed;
    }

    public void endTheGame(ArrayList<Token> whitePlayerTokenSet, ArrayList<Token> blackPlayerTokenSet){
        if (whitePlayerTokenSet.size() <= 2) {
            System.out.print("\n-------------------------------------\n");
            System.out.print("The BLACK player has won !!!\n");
            System.out.print("-------------------------------------\n");
            System.exit(1);
        }
        else if (blackPlayerTokenSet.size() <= 2) {
            System.out.print("\n-------------------------------------\n");
            System.out.print("The WHITE player has won !!!\n");
            System.out.print("-------------------------------------\n");
            System.exit(1);
        }
    }
    public boolean checkMil(String[][] board, String colour){

        // Horizontal mills
        if (board[1][1].contains(colour) && board[1][4].contains(colour) && board[1][7].contains(colour)&&((currentRow==1&&currentColumn==1)||(currentRow==1&&currentColumn==4)||(currentRow==1&&currentColumn==7))){

            millIsNotCreatedYet = true;
        }
        if (board[2][2].contains(colour) && board[2][4].contains(colour) && board[2][6].contains(colour)&&((currentRow==2&&currentColumn==2)||(currentRow==2&&currentColumn==4)||(currentRow==2&&currentColumn==6))){

            millIsNotCreatedYet = true;
        }
        if (board[3][3].contains(colour) && board[3][4].contains(colour) && board[3][5].contains(colour)&&((currentRow==3&&currentColumn==3)||(currentRow==3&&currentColumn==4)||(currentRow==3&&currentColumn==5))){

            millIsNotCreatedYet = true;
        }
        if (board[4][1].contains(colour) && board[4][2].contains(colour) && board[4][3].contains(colour)&&((currentRow==4&&currentColumn==1)||(currentRow==4&&currentColumn==2)||(currentRow==4&&currentColumn==3))){

            millIsNotCreatedYet = true;
        }
        if (board[4][5].contains(colour) && board[4][6].contains(colour) && board[4][7].contains(colour)&&((currentRow==4&&currentColumn==5)||(currentRow==4&&currentColumn==6)||(currentRow==4&&currentColumn==7))){

            millIsNotCreatedYet = true;
        }
        if (board[5][3].contains(colour) && board[5][4].contains(colour) && board[5][5].contains(colour)&&((currentRow==5&&currentColumn==3)||(currentRow==5&&currentColumn==4)||(currentRow==5&&currentColumn==5))){

            millIsNotCreatedYet = true;
        }
        if (board[6][2].contains(colour) && board[6][4].contains(colour) && board[6][6].contains(colour)&&((currentRow==6&&currentColumn==2)||(currentRow==6&&currentColumn==4)||(currentRow==6&&currentColumn==6))){

            millIsNotCreatedYet = true;
        }
        if (board[7][1].contains(colour) && board[7][4].contains(colour) && board[7][7].contains(colour)&&((currentRow==7&&currentColumn==1)||(currentRow==7&&currentColumn==4)||(currentRow==7&&currentColumn==7))){

            millIsNotCreatedYet = true;
        }

        // Vertical mills
        if (board[1][1].contains(colour) && board[4][1].contains(colour) && board[7][1].contains(colour)&&((currentRow==1&&currentColumn==1)||(currentRow==4&&currentColumn==1)||(currentRow==7&&currentColumn==1))){

            millIsNotCreatedYet = true;
        }
        if (board[2][2].contains(colour) && board[4][2].contains(colour) && board[6][2].contains(colour)&&((currentRow==2&&currentColumn==2)||(currentRow==4&&currentColumn==2)||(currentRow==6&&currentColumn==2))){

            millIsNotCreatedYet = true;
        }
        if (board[3][3].contains(colour) && board[4][3].contains(colour) && board[5][3].contains(colour)&&((currentRow==3&&currentColumn==3)||(currentRow==4&&currentColumn==3)||(currentRow==5&&currentColumn==3))){

            millIsNotCreatedYet = true;
        }
        if (board[1][4].contains(colour) && board[2][4].contains(colour) && board[3][4].contains(colour)&&((currentRow==1&&currentColumn==4)||(currentRow==2&&currentColumn==4)||(currentRow==3&&currentColumn==4))){

            millIsNotCreatedYet = true;
        }
        if (board[5][4].contains(colour) && board[6][4].contains(colour) && board[7][4].contains(colour)&&((currentRow==5&&currentColumn==4)||(currentRow==6&&currentColumn==4)||(currentRow==7&&currentColumn==4))){

            millIsNotCreatedYet = true;
        }

        if (board[3][5].contains(colour) && board[4][5].contains(colour) && board[5][5].contains(colour)&&((currentRow==3&&currentColumn==5)||(currentRow==4&&currentColumn==5)||(currentRow==5&&currentColumn==5))){

            millIsNotCreatedYet = true;
        }
        if (board[2][6].contains(colour) && board[4][6].contains(colour) && board[6][6].contains(colour)&&((currentRow==2&&currentColumn==6)||(currentRow==4&&currentColumn==6)||(currentRow==6&&currentColumn==6))){

            millIsNotCreatedYet = true;
        }
        if (board[1][7].contains(colour) && board[4][7].contains(colour) && board[7][7].contains(colour)&&((currentRow==1&&currentColumn==7)||(currentRow==4&&currentColumn==7)||(currentRow==7&&currentColumn==7))) {

            millIsNotCreatedYet = true;
        }
    return millIsNotCreatedYet;
    }
}

