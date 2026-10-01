package com.killianhewson.coffeemachine.coffee;

/** Represents a latte prepared by the coffee machine. */
public final class Latte extends CoffeeType {

    public Latte() {
        super("coffee.name.latte", 11, "Latte.wav");
    }

    @Override
    public String getPreparationMessageKey() {
        return "coffee.latte";
    }
}

