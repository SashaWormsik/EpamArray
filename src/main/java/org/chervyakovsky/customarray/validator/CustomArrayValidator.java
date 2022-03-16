package org.chervyakovsky.customarray.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayValidator {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX_FOR_VALIDATION = "\\s*(-\\s*)?\\d+(\\s*,\\s*(-\\s*)?\\d+)*\\s*";
    private static CustomArrayValidator instance;

    private CustomArrayValidator() {
    }

    public static CustomArrayValidator getInstance() {
        if (instance == null) {
            instance = new CustomArrayValidator();
        }
        return instance;
    }

    public boolean isValidStringForIntArray(String checkString) {
        boolean isValid = checkString != null && (checkString.trim().isEmpty() || checkString.matches(REGEX_FOR_VALIDATION));
        LOGGER.log(Level.INFO, isValid ? "Valid string: {}" : "Invalid string: {}", checkString);
        return isValid;
    }
}
