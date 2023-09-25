package src.game.models;

import java.util.ArrayList;

public class Token {
    private char colour; //i.e., W (White Player) or B (Black Player)
    private Position position;
    private boolean placed;

    private ArrayList<String> displayingTokens = new ArrayList<String>();

    public Token() {
        this.placed = false;
    }

    public Token(char colour) {
        this.colour = colour;
        this.placed = false;
    }

    public char getColour() {
        return colour;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

}
