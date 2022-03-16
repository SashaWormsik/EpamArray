package org.chervyakovsky.customarray.service.impl.streamImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.SearchService;
import org.chervyakovsky.customarray.util.ArrayValidatorUtils;

import java.util.Arrays;
import java.util.OptionalInt;

public class SearchServiceStreamImpl implements SearchService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public OptionalInt searchMin(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to find min element start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        return Arrays.stream(array).min();
    }

    @Override
    public OptionalInt searchMax(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to find max element start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        return Arrays.stream(array).max();
    }
}
