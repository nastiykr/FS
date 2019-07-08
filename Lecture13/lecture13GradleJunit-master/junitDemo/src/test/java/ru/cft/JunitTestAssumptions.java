package ru.cft;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.cft.utils.PiUtil.calculatePi;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class JunitTestAssumptions {

    @Test
    void piTest(){
        double expected = 3.1415926535897936;
        double actual = calculatePi(55);
        assumeTrue(actual > 3);

        assertEquals(expected, actual);
    }

}
