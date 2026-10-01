package com.killianhewson.coffeemachine.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/** Loads translated application messages and switches between English and French. */
public final class LanguageManager {

    private static final String BUNDLE_NAME = "i18n.messages";

    private Locale locale;
    private ResourceBundle bundle;

    public LanguageManager() {
        setLanguage(Locale.ENGLISH);
    }

    public String getString(String key) {
        return bundle.getString(key);
    }

    public void switchLanguage() {
        setLanguage(locale.getLanguage().equals(Locale.ENGLISH.getLanguage())
                ? Locale.FRENCH
                : Locale.ENGLISH);
    }

    private void setLanguage(Locale newLocale) {
        locale = newLocale;
        bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }
}

