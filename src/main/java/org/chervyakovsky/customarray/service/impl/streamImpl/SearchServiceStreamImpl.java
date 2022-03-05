package org.chervyakovsky.customarray.service.impl.streamImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.SearchService;
import org.chervyakovsky.customarray.util.ArrayValidatorUtil;

import java.util.Arrays;

public class SearchServiceStreamImpl implements SearchService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int searchMin(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to find min element start");
        ArrayValidatorUtil.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        int min = Arrays.stream(array).min().getAsInt();
        return min;
    }

    @Override
    public int searchMax(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to find max element start");
        ArrayValidatorUtil.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        int max = Arrays.stream(array).max().getAsInt();
        return max;
    }
}
