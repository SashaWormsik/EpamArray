package org.chervyakovsky.customarray.service.impl.customImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.SearchService;

public class SearchServiceCustomImpl implements SearchService {

    Logger logger = LogManager.getLogger();

    @Override
    public int searchMin(CustomArray customArray) throws CustomException {
        logger.info("Method to find min element start");
        if (customArray.getArray().length == 0) {
            throw new CustomException("Array is empty");
        }
        int[] array = customArray.getArray();
        int min = array[0];
        for (int i : array) {
            if (min > i) {
                min = i;
            }
        }
        logger.info("Min element: " + min);
        return min;
    }

    @Override
    public int searchMax(CustomArray customArray) throws CustomException {
        logger.info("Method to find max element start");
        if (customArray.getArray().length == 0) {
            throw new CustomException("Array is empty");
        }
        int[] array = customArray.getArray();
        int max = array[0];
        for (int i : array) {
            if (max < i) {
                max = i;
            }
        }
        logger.info("Max element: " + max);
        return max;
    }
}
