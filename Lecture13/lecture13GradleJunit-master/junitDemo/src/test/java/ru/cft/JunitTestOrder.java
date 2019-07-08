package ru.cft;

import org.junit.jupiter.api.*;
import ru.cft.utils.StringUtil;

import static ru.cft.utils.PiUtil.calculatePi;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitTestOrder {

    @Test
    @Order(2)
    void piTest(){
        double expected = 3.1415926535897936;
        double actual = calculatePi(55);

        assertEquals(expected, actual);
    }

    @Test
    @Order(1)
    void stringUtilTest(){
        String expected = "3,14";
        String actual = StringUtil.format(3.1415926535897936, 2);

        assertEquals(expected, actual);
    }
}
