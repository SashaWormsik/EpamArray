package org.chervyakovsky.customarray.service.impl.customImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.SearchService;
import org.chervyakovsky.customarray.util.ArrayValidatorUtils;

import java.util.OptionalInt;

public class SearchServiceCustomImpl implements SearchService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public OptionalInt searchMin(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to find min element start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        if (customArray.getArray().length == 0) {
            LOGGER.info("Min not found, the number of elements is 0 in " + customArray);
            return OptionalInt.empty();
        }
        int[] array = customArray.getArray();
        int min = array[0];
        for (int i : array) {
            if (min > i) {
                min = i;
            }
        }
        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt searchMax(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to find max element start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        if (customArray.getArray().length == 0) {
            LOGGER.info("Max not found, the number of elements is 0 in " + customArray);
            return OptionalInt.empty();
        }
        int[] array = customArray.getArray();
        int max = array[0];
        for (int i : array) {
            if (max < i) {
                max = i;
            }
        }
        return OptionalInt.of(max);
    }
}
