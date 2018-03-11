package com.planner.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageUtil {

    /**
     * @param language
     * @param messageKey
     * @return
     */
    public String getMessage(String language, String messageKey) {

        String messageValue = null;
        if (language == null) {
            language = Constants.DEFAULT_LANG;
        }

        if (this.validateLanguage(language)) {
            try {
                Locale locale = new Locale(language);
                messageValue = returnKeyValue(locale, messageKey);
            } catch (Exception e) {
                throw e;
            }
        } else {
            messageValue = "Invalid Language. Provide a valid Language";
        }
        return messageValue;
    }

    /**
     * @param locale
     * @param messageKey
     * @return
     */
    private String returnKeyValue(Locale locale, String messageKey) {

        String messageValue = null;

        try {
            ResourceBundle messages = ResourceBundle.getBundle("text", locale);
            messageValue = messages.getString(messageKey);
        } catch (Exception e) {
            throw e;
        }
        return messageValue;
    }

    /**
     * For validation of the language
     *
     * @param language
     * @return
     */
    public boolean validateLanguage(String language) {

        boolean isValidLanguage = false;
        if (language != null) {
            for (String lang : Constants.LANGUAGES) {
                if (lang.equalsIgnoreCase(language)) {
                    isValidLanguage = true;
                }
            }
        }
        return isValidLanguage;
    }
}
