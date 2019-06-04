package ru.cft;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.*;

import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

public class CafeDemoJupiter{
    // 1- AssertAll
    @Tag("jupiter")
    @Test
    void getterMethods() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(24);
        cafe.restockMilk(227);

        Coffee coffeeEspresso = cafe.brew(CoffeeType.Espresso);
        Coffee coffeeLatte = cafe.brew(CoffeeType.Latte);
        Coffee coffeeFilterCoffee = cafe.brew(CoffeeType.FilterCoffee);


        assertAll("coffe getter methods", //
                () -> assertEquals(7, coffeeEspresso.getBeans()), //
                () -> assertEquals(7, coffeeLatte.getBeans()), //
                () -> assertEquals(10, coffeeFilterCoffee.getBeans())//
        );
    }

    // 2 - AssertNotNull
    @Tag("jupiter")
    @Test
    public void assertNeNull() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        Coffee coffeeEspresso = cafe.brew(CoffeeType.Espresso);

        assertNotNull(coffeeEspresso);

    }

    // 3 - AssertEquals
    @Tag("jupiter")
    @Test
    void AssertEqual (){
        Cafe cafe = new Cafe();
        int inputBeans = 24;
        cafe.restockBeans(inputBeans);

        assertEquals(inputBeans, cafe.getBeansInStock());
    }

    // 4 - AssertEquals
    @Tag("jupiter")
    @Test
    void assertEqualsObject(){
        Cafe cafe = new Cafe();

        cafe.restockBeans(14);

        Coffee coffeeEspresso1 = cafe.brew(CoffeeType.Espresso);
        Coffee coffeeEspresso2 = cafe.brew(CoffeeType.Espresso);

        assertEquals(coffeeEspresso1.getBeans(), coffeeEspresso2.getBeans());
    }

    // 5 - AssertNotSame
    @Tag("jupiter")
    @Test
    public void assertNeSame() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(24);
        cafe.restockMilk(227);

        Coffee coffeeEspresso = cafe.brew(CoffeeType.Espresso);
        Coffee coffeeLatte = cafe.brew(CoffeeType.Latte);

        assertNotSame(coffeeEspresso, coffeeLatte);
    }

    // 6 - AssertTrue
    @Tag("jupiter")
    @Test
    public void assertIsTrue() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(24);
        cafe.restockMilk(227);

        assertTrue(cafe.getBeansInStock() < cafe.getMilkInStock());
    }

    // 7 - AssertFalse
    @Tag("jupiter")
    @Test
    public void assertIsFalse() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(24);
        cafe.restockMilk(227);

        assertFalse(cafe.getBeansInStock() > cafe.getMilkInStock());
    }

    // 8 - assertTimeout
    @Tag("jupiter")
    @Test
    void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });
    }


    // 9 - assertTrue
    @Tag("jupiter")
    @Test
    public void testReadFileWithClassLoader(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("input_text.txt").getFile());
        assertTrue(file.exists());

    }
    // 10 - assertNotNull
    @Tag("jupiter")
    @Test
    public void testReadAsStream() throws IOException {
        InputStream is = this.getClass().getResourceAsStream("/input_text.txt");
        assertNotNull(is);

        //assertThat(is).contains("milk");
    }
}

/*
JUnit 5 Assertions Example
**************************
1. AssertAll

2. AssertNull
3. AssertNotNull

4. AssertEquals
5. AssertNotEquals

6. AssertArrayEquals
7. AssertIterableEquals

8. AssertTrue
9. AssertFalse

10. AssertSame
11. AssertNotSame

12. AssertTimeout
13. AssertTimeoutPreemptively

14. AssertThrows
15. Fail
 */
