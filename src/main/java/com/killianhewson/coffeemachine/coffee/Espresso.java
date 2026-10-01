package com.killianhewson.coffeemachine.coffee;

/** Represents an espresso prepared by the coffee machine. */
public final class Espresso extends CoffeeType {

    public Espresso() {
        super("coffee.name.espresso", 4, "Espresso.wav");
    }

    @Override
    public String getPreparationMessageKey() {
        return "coffee.espresso";
    }
}

