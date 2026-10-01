package com.killianhewson.coffeemachine.coffee;

/** Represents an Americano prepared by the coffee machine. */
public final class Americano extends CoffeeType {

    public Americano() {
        super("coffee.name.americano", 7, "Americano.wav");
    }

    @Override
    public String getPreparationMessageKey() {
        return "coffee.americano";
    }
}

