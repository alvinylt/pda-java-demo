package PDA;

import java.util.ArrayDeque;
import java.util.Deque;
import static PDA.Tokeniser.Token.*;
import static PDA.Parser.State.*;

public class Parser {
    private State currentState;
    private final Deque<Tokeniser.Token> stack = new ArrayDeque<>();
    private final Tokeniser tokeniser;

    public Parser(String str) {
        this.tokeniser = new Tokeniser(str);
        this.currentState = State.S0;
    }

    public boolean parse() {
        stack.push(Z);

        if (!tokeniser.hasNext()) {
            currentState = S3;
        }

        while (tokeniser.hasNext()) {
            Tokeniser.Token currentToken = tokeniser.next();

            switch (currentState) {
                case S0 -> {
                    if (currentToken.equals(A)) {
                        currentState = S1;
                        stack.push(A);
                    }
                }
                case S1 -> {
                    if (currentToken.equals(A)) {
                        stack.push(A);
                    }
                    else if (currentToken.equals(B)) {
                        currentState = S2;
                        stack.pop();
                        if (stack.peek() != null && stack.peek() == Z) {
                            currentState = S3;
                        }
                    }
                }
                case S2 -> {
                    if (currentToken.equals(B)) {
                        stack.pop();
                        if (stack.peek() != null && stack.peek().equals(Z)) {
                            currentState = S3;
                        }
                    }
                }
                case S3 -> {
                    return false; // The PDA reached S3 but there are still tokens to parse
                }
                default -> throw new RuntimeException("parse: Invalid state");
            }
        }

        if (stack.peek() != Z) {
            return false; // ensure only Z is left in the stack
        }

        return currentState.isTerminal(); // Ensure the final state is S3
    }

    public enum State {
        S0, S1, S2, S3;

        /**
         * @return whether the state is a terminal state
         */
        public boolean isTerminal() {
            return this.equals(S3);
        }
    }
}
