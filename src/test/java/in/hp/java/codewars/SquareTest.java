package in.hp.java.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTest {
    @Test
    public void shouldWorkForSomeExamples() throws Exception {
        assertEquals(false, Square.isSquare(-1), "negative numbers aren't square numbers");
        assertEquals(true, Square.isSquare(0), "0 is a square number (0 * 0)");
        assertEquals(false, Square.isSquare(3), "3 isn't a square number");
        assertEquals(true, Square.isSquare(4), "4 is a square number (2 * 2)");
        assertEquals(true, Square.isSquare(25), "25 is a square number (5 * 5)");
        assertEquals(false, Square.isSquare(26), "26 isn't a square number");
    }
}