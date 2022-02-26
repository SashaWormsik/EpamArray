package org.chervyakovsky.customarray.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerArrayValidator {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX_FOR_VALIDATION = "\\s*(-\\s*)?\\d+(\\s*,\\s*(-\\s*)?\\d+)*\\s*";
    private static CustomerArrayValidator instance;

    private CustomerArrayValidator() {
    }

    public static CustomerArrayValidator getInstance(){
        if (instance == null){
            instance = new CustomerArrayValidator();
        }
        return instance;
    }

    public static boolean isValid(String checkString) {
        boolean isValid = checkString != null && (checkString.trim().isEmpty() || checkString.matches(REGEX_FOR_VALIDATION));
        LOGGER.log(Level.INFO, isValid ? "Read valid array: {}" : "Read invalid array: {}", checkString);
        return isValid;
    }
}
