package org.chervyakovsky.customarray.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerValidator {

    private static final String SEPARATOR = ",";
    private static final String REGEX_FOR_VALIDATION = "[+-]?\\d+";
    private static final Logger LOGGER = LogManager.getLogger();

    public static boolean isValid(String checkString) {
        boolean isValid = true;
        if (checkString.length() == 0) {
            LOGGER.log(Level.INFO, "Read valid array: {}", checkString);
            return true;
        }
        String[] arrString = checkString.split(SEPARATOR);
        int index = arrString.length - 1;
        while (isValid && index >= 0) {
            String string = arrString[index].trim();
            isValid = string.matches(REGEX_FOR_VALIDATION);
            index--;
        }
        LOGGER.log(Level.INFO, isValid ? "Read valid array: {}" : "Read invalid array: {}", checkString);
        return isValid;
    }
}
