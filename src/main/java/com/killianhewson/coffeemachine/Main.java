package com.killianhewson.coffeemachine;

import com.killianhewson.coffeemachine.i18n.LanguageManager;
import com.killianhewson.coffeemachine.logging.ApplicationLogger;
import com.killianhewson.coffeemachine.menu.Menu;

import java.util.Scanner;

/** Entry point for the coffee machine application. */
public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        ApplicationLogger.info("Coffee machine started");

        try (Scanner scanner = new Scanner(System.in)) {
            Menu menu = new Menu(scanner, new LanguageManager());
            menu.run();
        }

        ApplicationLogger.info("Coffee machine stopped");
    }
}

