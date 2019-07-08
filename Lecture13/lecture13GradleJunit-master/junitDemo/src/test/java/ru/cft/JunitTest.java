package ru.cft;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.cft.utils.StringUtil;

import static ru.cft.utils.PiUtil.calculatePi;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitTest {

    @Test
    void simpleTest(){
        String expected = "expected";
        String actual = "expected";

        assertEquals(expected, actual);
    }

    @Test
    void piTest(){
        double expected = 3.1415926535897936;

        double actual = calculatePi(55);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {55})
    void piTestParametrized(int number){
        double expected = 3.1415926535897936;

        double actual = calculatePi(number);

        assertEquals(expected, actual);
    }

    @Test
    void stringUtilTest(){
        String expected = "3,14";

        String actual = StringUtil.format(3.1415926535897936, 2);

        assertEquals(expected, actual);
    }

    @Test
    @Disabled("Not implemented yet")
    void testShowSomething() {
        System.out.println("I'm disabled");
    }
}
