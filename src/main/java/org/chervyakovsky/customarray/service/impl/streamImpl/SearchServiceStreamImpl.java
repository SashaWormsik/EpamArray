package org.chervyakovsky.customarray.service.impl.streamImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.SearchService;

import java.util.Arrays;

public class SearchServiceStreamImpl implements SearchService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int searchMin(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to find min element start");
        if (customArray == null) {
            throw new CustomException("Array can not be NULL");
        }
        int[] array = customArray.getArray();
        int min = Arrays.stream(array).min().getAsInt(); //FIXME
        return min;
    }

    @Override
    public int searchMax(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to find max element start");
        if (customArray == null) {
            throw new CustomException("Array can not be NULL");
        }
        int[] array = customArray.getArray();
        int max = Arrays.stream(array).max().getAsInt(); //FIXME
        return max;
    }
}
