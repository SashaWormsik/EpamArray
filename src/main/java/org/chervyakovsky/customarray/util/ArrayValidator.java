package org.chervyakovsky.customarray.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

public class ArrayValidator {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void checkingCustomArray(CustomArray customArray) throws CustomException {
        if (customArray == null) {
            LOGGER.error("CustomArray is NULL");
            throw new CustomException("Array can not be NULL");
        }
    }
}
