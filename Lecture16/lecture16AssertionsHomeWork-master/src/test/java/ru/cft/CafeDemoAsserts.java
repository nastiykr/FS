package ru.cft;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;



public class CafeDemoAsserts {
    // 1 - isEqualTo
    @Tag("assertj")
    @Test
    void TestAssertThatIsEqualTo (){
        Cafe cafe = new Cafe();
        int inputBeans = 24;
        cafe.restockBeans(inputBeans);

        assertThat(cafe.getBeansInStock()).isEqualTo((24));
    }

    // 2 - isNotEqualTo
    @Tag("assertj")
    @Test
    void TestAssertThatIsNoEqualTo (){
        Cafe cafe = new Cafe();
        cafe.restockBeans(24);
        cafe.restockMilk(227);

        Coffee coffeeEspresso1 = cafe.brew(CoffeeType.Espresso);
        Coffee coffeeEspresso2 = cafe.brew(CoffeeType.Espresso,2);

        assertThat(coffeeEspresso1.getBeans()).isNotEqualTo(coffeeEspresso2.getBeans());

    }

    // 3 - startsWith, endsWith, isEqualToIgnoringCase, contains
    @Tag("assertj")
    @Test
    void TestAssertThatStartsEndsIgnoring (){
        Cafe cafe = new Cafe();
        cafe.restockBeans(24);
        cafe.restockMilk(227);

        Coffee coffeeEspresso = cafe.brew(CoffeeType.Espresso);

        assertThat(coffeeEspresso.toString())
                .startsWith("Coffee")
                .endsWith("}")
                .isEqualToIgnoringCase("coffee{type=espresso, beans=7, milk=0}")
                .contains("milk");


    }

    // 4 - isEqualToComparingFieldByFieldRecursively, isNotEqualByComparingTo
    @Tag("assertj")
    @Test
    void TestAssertThatComparing (){
               Cafe cafe = new Cafe();
        cafe.restockBeans(24);
        cafe.restockMilk(227);

        Coffee coffeeEspresso = cafe.brew(CoffeeType.Espresso);
        Coffee coffeeEspresso2 = cafe.brew(CoffeeType.Espresso,1);


        assertThat(coffeeEspresso).isEqualToComparingFieldByFieldRecursively(coffeeEspresso2);


        assertThat(CoffeeType.Latte).isNotEqualByComparingTo(CoffeeType.Espresso);
        assertThat(CoffeeType.Latte).isEqualToComparingFieldByFieldRecursively(CoffeeType.Latte);

    }

    // 5 - READ FROM FILE
    @Tag("assertj")
    @Test
    public void testRead() throws IOException {
        String s = "";
        Scanner in = new Scanner(new File("src\\test\\resources\\input_text.txt"));
        while(in.hasNext())
            s += in.nextLine() + "\r\n";
        in.close();

        assertThat(s).contains("Latte");
    }
}
