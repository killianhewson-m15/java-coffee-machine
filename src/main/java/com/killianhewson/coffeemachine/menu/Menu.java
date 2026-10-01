package com.killianhewson.coffeemachine.menu;

import com.killianhewson.coffeemachine.coffee.CoffeeFactory;
import com.killianhewson.coffeemachine.coffee.CoffeeType;
import com.killianhewson.coffeemachine.exception.InvalidCoffeeTypeException;
import com.killianhewson.coffeemachine.i18n.LanguageManager;
import com.killianhewson.coffeemachine.logging.ApplicationLogger;

import javax.sound.sampled.Clip;
import java.text.MessageFormat;
import java.util.Optional;
import java.util.Scanner;

/** Displays the menu and coordinates the preparation of a selected coffee. */
public final class Menu {

    private final Scanner input;
    private final LanguageManager languageManager;
    private final CoffeeFactory coffeeFactory;

    public Menu(Scanner input, LanguageManager languageManager) {
        this.input = input;
        this.languageManager = languageManager;
        this.coffeeFactory = new CoffeeFactory();
    }

    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            String choice = input.nextLine().trim();

            if (choice.equalsIgnoreCase(languageManager.getString("input.exit"))) {
                System.out.println(languageManager.getString("menu.goodbye"));
                running = false;
            } else if (choice.equalsIgnoreCase(languageManager.getString("input.language"))) {
                languageManager.switchLanguage();
                System.out.println(languageManager.getString("language.switched"));
                ApplicationLogger.info("Application language changed");
            } else {
                handleCoffeeChoice(choice);
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n" + languageManager.getString("menu.title"));
        System.out.println(languageManager.getString("menu.prompt"));
        System.out.println(languageManager.getString("menu.options"));
        System.out.println(languageManager.getString("menu.exit"));
        System.out.println(languageManager.getString("menu.language"));
        System.out.print(languageManager.getString("menu.choice"));
    }

    private void handleCoffeeChoice(String choice) {
        try {
            CoffeeType coffee = coffeeFactory.create(choice, languageManager);
            prepareCoffee(coffee);
        } catch (InvalidCoffeeTypeException exception) {
            System.out.println(exception.getMessage());
            ApplicationLogger.warning("Invalid coffee selection: " + choice, exception);
        }
    }

    private void prepareCoffee(CoffeeType coffee) {
        String coffeeName = languageManager.getString(coffee.getNameKey());

        System.out.println(languageManager.getString("coffee.making") + coffeeName);
        System.out.println(languageManager.getString(coffee.getPreparationMessageKey()));
        ApplicationLogger.info("Preparing " + coffeeName);

        Optional<Clip> sound = coffee.playSound();

        try {
            countdown(coffee.getPreparationTime());
            String readyMessage = MessageFormat.format(
                    languageManager.getString("coffee.ready"),
                    coffeeName
            );
            System.out.println(readyMessage);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println(languageManager.getString("error.preparation"));
            ApplicationLogger.warning("Coffee preparation was interrupted", exception);
        } finally {
            sound.ifPresent(Clip::close);
        }
    }

    private void countdown(int seconds) throws InterruptedException {
        Thread countdownThread = new Thread(() -> {
            for (int remaining = seconds; remaining > 0; remaining--) {
                System.out.println(remaining);
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }, "coffee-countdown");

        countdownThread.start();

        try {
            countdownThread.join();
        } catch (InterruptedException exception) {
            countdownThread.interrupt();
            throw exception;
        }
    }
}

