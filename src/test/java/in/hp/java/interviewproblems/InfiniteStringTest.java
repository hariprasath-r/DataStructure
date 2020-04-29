package in.hp.java.interviewproblems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfiniteStringTest {

    @Test
    public void test1() {
        assertEquals(3, InfiniteString.findOccurances("abc", 9));
    }

    @Test
    public void test2() {
        assertEquals(4, InfiniteString.findOccurances("abc", 12));
    }

    @Test
    public void test3() {
        assertEquals(15, InfiniteString.findOccurances("abcdedf", 100));
    }
}