package org.chervyakovsky.customarray.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

public class ArrayValidatorUtil {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void checkingCustomArray(CustomArray customArray) throws CustomException {
        if (customArray == null || customArray.getArray() == null || customArray.getArray().length == 0) {
            LOGGER.error("CustomArray is NULL or field array is null");
            throw new CustomException("CustomArray is NULL or field array is null");
        }
    }
}
