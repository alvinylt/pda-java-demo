package PDA;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ParserTest {
    @Test
    public void parseTestEmpty() {
        String str = "";
        Parser parser = new Parser(str);
        assertTrue(parser.parse());
    }

    @Test
    public void parseTestSimpleValid0() {
        String str = "ab";
        Parser parser = new Parser(str);
        assertTrue(parser.parse());
    }

    @Test
    public void parseTestSimpleValid1() {
        String str = "aabb";
        Parser parser = new Parser(str);
        assertTrue(parser.parse());
    }

    @Test
    public void parseTestSimpleValid2() {
        String str = "aaabbb";
        Parser parser = new Parser(str);
        assertTrue(parser.parse());
    }

    @Test
    public void parseTestSimpleInvalid0() {
        String str = "a";
        Parser parser = new Parser(str);
        assertFalse(parser.parse());
    }

    @Test
    public void parseTestSimpleInvalid1() {
        String str = "b";
        Parser parser = new Parser(str);
        assertFalse(parser.parse());
    }

    @Test
    public void parseTestInvalid0() {
        String str = "aab";
        Parser parser = new Parser(str);
        assertFalse(parser.parse());
    }

    @Test
    public void parseTestInvalid1() {
        String str = "abb";
        Parser parser = new Parser(str);
        assertFalse(parser.parse());
    }

    @Test
    public void parseTestLongValid() {
        String str = "aaaaaaaaaabbbbbbbbbb";
        Parser parser = new Parser(str);
        assertTrue(parser.parse());
    }

    @Test
    public void parseTestLongInvalid0() {
        String str = "aaaaaaaaaabbbbbbbbb";
        Parser parser = new Parser(str);
        assertFalse(parser.parse());
    }

    @Test
    public void parseTestLongInvalid1() {
        String str = "aaaaaaaaaabbbbbbbbbbb";
        Parser parser = new Parser(str);
        assertFalse(parser.parse());
    }
}
