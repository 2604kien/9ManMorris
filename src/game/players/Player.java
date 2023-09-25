package src.game.players;

import src.game.models.Move;

public class Player {
    private String name;
    private char colour; //i.e., W or B
    private int tokensRemained;

    private Move move;

    public Player(String name, char colour, int tokensRemained) {
        this.name = name;
        this.colour = colour;
        this.tokensRemained = tokensRemained;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return colour;
    }

    public int getTokensRemained() {
        return tokensRemained;
    }

    public int setTokensRemained(int tokensRemained){
        return this.tokensRemained = tokensRemained;
    }

    public void reduceTokensRemained() {
        tokensRemained--;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
