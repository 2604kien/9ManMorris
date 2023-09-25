package src.game.models;

public class Move {
    private Token token;
    private Position from;
    private Position to;

    public Move(Token token, Position from, Position to) {
        this.token = token;
        this.from = from;
        this.token.setPosition(to);
    }

    public Token getToken() {
        return token;
    }


    public Position getFrom() {
        return from;
    }


    public Position getTo() {
        return to;
    }
}
