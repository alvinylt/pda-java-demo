package PDA;

import org.junit.Test;
import static org.junit.Assert.*;
import static PDA.Tokeniser.Token.*;

public class TokeniserTest {
    @Test
    public void testEmpty() {
        String str = "";
        Tokeniser tokeniser = new Tokeniser(str);
        assertFalse(tokeniser.hasNext());
    }

    @Test
    public void testSimple() {
        String str = "abaab";
        Tokeniser tokeniser = new Tokeniser(str);
        assertTrue(tokeniser.hasNext());
        assertEquals(A, tokeniser.next());
        assertEquals(B, tokeniser.next());
        assertEquals(A, tokeniser.next());
        assertEquals(A, tokeniser.next());
        assertTrue(tokeniser.hasNext());
        assertEquals(B, tokeniser.next());
        assertFalse(tokeniser.hasNext());
    }
}
