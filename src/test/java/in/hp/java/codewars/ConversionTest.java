package in.hp.java.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConversionTest {
    private Conversion conversion = new Conversion();

    @Test
    public void shouldConvertToRoman() {
        assertEquals("I", conversion.solution(1), "solution(1) should equal to I");
        assertEquals("IV", conversion.solution(4), "solution(4) should equal to IV");
        assertEquals("VI", conversion.solution(6), "solution(6) should equal to VI");
        assertEquals("MCMXC", conversion.solution(1990), "solution(1990) should equal to MCMXC");
        assertEquals("MMVIII", conversion.solution(2008), "solution(2008) should equal to MMVIII");
        assertEquals("MDCLXVI", conversion.solution(1666), "solution(1666) should equal to MDCLXVI");
    }
}