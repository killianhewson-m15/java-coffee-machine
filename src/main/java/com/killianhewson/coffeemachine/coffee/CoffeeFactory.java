package com.killianhewson.coffeemachine.coffee;

import com.killianhewson.coffeemachine.exception.InvalidCoffeeTypeException;
import com.killianhewson.coffeemachine.i18n.LanguageManager;

/** Creates the coffee selected by the user. */
public final class CoffeeFactory {

    public CoffeeType create(String choice, LanguageManager languageManager)
            throws InvalidCoffeeTypeException {

        if (choice.equalsIgnoreCase(languageManager.getString("input.latte"))) {
            return new Latte();
        }
        if (choice.equalsIgnoreCase(languageManager.getString("input.americano"))) {
            return new Americano();
        }
        if (choice.equalsIgnoreCase(languageManager.getString("input.espresso"))) {
            return new Espresso();
        }

        throw new InvalidCoffeeTypeException(languageManager.getString("menu.invalid"));
    }
}

