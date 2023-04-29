package PDA;

import java.util.ArrayList;
import java.util.List;

public class Tokeniser {
    private final List<Token> tokens;

    public Tokeniser(String str) {
        List<Token> tokens = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                tokens.add(Token.A);
            }
            else if (str.charAt(i) == 'b') {
                tokens.add(Token.B);
            }
            else {
                throw new IllegalArgumentException("Invalid character: " + str.charAt(i));
            }
        }
        this.tokens = tokens;
    }

    public boolean hasNext() {
        return !tokens.isEmpty();
    }

    public Token next() {
        if (hasNext()) {
            Token currentToken = tokens.get(0);
            tokens.remove(0);
            return currentToken;
        }
        else {
            return null;
        }
    }

    public enum Token {
        A, B, Z
    }
}
