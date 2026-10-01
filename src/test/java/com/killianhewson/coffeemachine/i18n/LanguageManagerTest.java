package com.killianhewson.coffeemachine.i18n;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanguageManagerTest {

    @Test
    void startsInEnglish() {
        LanguageManager languageManager = new LanguageManager();

        assertEquals("Goodbye", languageManager.getString("menu.goodbye"));
    }

    @Test
    void switchesToFrench() {
        LanguageManager languageManager = new LanguageManager();

        languageManager.switchLanguage();

        assertEquals("Au revoir", languageManager.getString("menu.goodbye"));
        assertEquals("Quitter", languageManager.getString("input.exit"));
    }

    @Test
    void switchesBackToEnglish() {
        LanguageManager languageManager = new LanguageManager();

        languageManager.switchLanguage();
        languageManager.switchLanguage();

        assertEquals("Goodbye", languageManager.getString("menu.goodbye"));
    }
}

