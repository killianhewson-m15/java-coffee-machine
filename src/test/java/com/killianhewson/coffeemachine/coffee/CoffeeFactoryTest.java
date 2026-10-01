package com.killianhewson.coffeemachine.coffee;

import com.killianhewson.coffeemachine.exception.InvalidCoffeeTypeException;
import com.killianhewson.coffeemachine.i18n.LanguageManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoffeeFactoryTest {

    private CoffeeFactory coffeeFactory;
    private LanguageManager languageManager;

    @BeforeEach
    void setUp() {
        coffeeFactory = new CoffeeFactory();
        languageManager = new LanguageManager();
    }

    @Test
    void createsEachAvailableCoffeeType() throws InvalidCoffeeTypeException {
        assertInstanceOf(Latte.class, coffeeFactory.create("Latte", languageManager));
        assertInstanceOf(Americano.class, coffeeFactory.create("Americano", languageManager));
        assertInstanceOf(Espresso.class, coffeeFactory.create("Espresso", languageManager));
    }

    @Test
    void acceptsCoffeeNamesWithoutMatchingCase() throws InvalidCoffeeTypeException {
        assertInstanceOf(Latte.class, coffeeFactory.create("latte", languageManager));
    }

    @Test
    void rejectsUnknownCoffeeType() {
        assertThrows(
                InvalidCoffeeTypeException.class,
                () -> coffeeFactory.create("Tea", languageManager)
        );
    }

    @Test
    void acceptsFrenchEspressoNameAfterLanguageSwitch() throws InvalidCoffeeTypeException {
        languageManager.switchLanguage();

        assertInstanceOf(Espresso.class, coffeeFactory.create("Espresso", languageManager));
    }
}

