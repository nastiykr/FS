package ru.cft;

import org.junit.jupiter.api.*;
import ru.cft.utils.StringUtil;

import static ru.cft.utils.PiUtil.calculatePi;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitTestAfterBefore {

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - executes before each test method in this class");
    }

    @Test
    void piTest(){
        double expected = 3.1415926535897936;
        double actual = calculatePi(55);

        assertEquals(expected, actual);
    }


    @Test
    void stringUtilTest(){
        String expected = "3,14";
        String actual = StringUtil.format(3.1415926535897936, 2);

        assertEquals(expected, actual);
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void done() {
        System.out.println("@AfterAll - executed after all test methods.");
    }
}
