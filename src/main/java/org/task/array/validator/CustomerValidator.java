package org.task.array.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerValidator {

    public static boolean isValid(String str) {

        Logger logger = LogManager.getLogger();

        boolean isValid = true;
        if (str.length() == 0) {
            isValid = false;
        }
        String[] arrString = str.split(",");
        int index = arrString.length - 1;
        while (isValid && index >= 0) {
            String valString = arrString[index].trim();
            isValid = valString.matches("[+-]?\\d+");
            index--;
        }
        logger.log(Level.INFO, isValid ? "Read valid array: " + str : "Read invalid array: " + str);
        return isValid;
    }
}
