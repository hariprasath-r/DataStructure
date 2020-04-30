package in.hp.java.codewars;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsogramTest {

    @Test
    public void FixedTests() {
        Isogram isogram = new Isogram();
        assertEquals(true, isogram.isIsogram("Dermatoglyphics"));
        assertEquals(true, isogram.isIsogram("isogram"));
        assertEquals(false, isogram.isIsogram("moose"));
        assertEquals(false, isogram.isIsogram("isIsogram"));
        assertEquals(false, isogram.isIsogram("aba"));
        assertEquals(false, isogram.isIsogram("moOse"));
        assertEquals(true, isogram.isIsogram("thumbscrewjapingly"));
        assertEquals(true, isogram.isIsogram(""));
    }

    @Test
    public void FixedTests1() {
        Isogram isogram = new Isogram();
        assertEquals(true, isogram.isIsogramBestPractise("Dermatoglyphics"));
        assertEquals(true, isogram.isIsogramBestPractise("isogram"));
        assertEquals(false, isogram.isIsogramBestPractise("moose"));
        assertEquals(false, isogram.isIsogramBestPractise("isIsogram"));
        assertEquals(false, isogram.isIsogramBestPractise("aba"));
        assertEquals(false, isogram.isIsogramBestPractise("moOse"));
        assertEquals(true, isogram.isIsogramBestPractise("thumbscrewjapingly"));
        assertEquals(true, isogram.isIsogramBestPractise(""));
    }
}