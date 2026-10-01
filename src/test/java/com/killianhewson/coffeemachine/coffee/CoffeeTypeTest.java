package com.killianhewson.coffeemachine.coffee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeeTypeTest {

    @Test
    void americanoContainsExpectedDetails() {
        CoffeeType americano = new Americano();

        assertEquals("coffee.name.americano", americano.getNameKey());
        assertEquals("coffee.americano", americano.getPreparationMessageKey());
        assertEquals(7, americano.getPreparationTime());
    }

    @Test
    void espressoContainsExpectedDetails() {
        CoffeeType espresso = new Espresso();

        assertEquals("coffee.name.espresso", espresso.getNameKey());
        assertEquals("coffee.espresso", espresso.getPreparationMessageKey());
        assertEquals(4, espresso.getPreparationTime());
    }

    @Test
    void latteContainsExpectedDetails() {
        CoffeeType latte = new Latte();

        assertEquals("coffee.name.latte", latte.getNameKey());
        assertEquals("coffee.latte", latte.getPreparationMessageKey());
        assertEquals(11, latte.getPreparationTime());
    }
}

