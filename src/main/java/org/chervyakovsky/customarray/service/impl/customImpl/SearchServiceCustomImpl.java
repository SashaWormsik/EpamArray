package org.chervyakovsky.customarray.service.impl.customImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.SearchService;
import org.chervyakovsky.customarray.util.ArrayValidatorUtil;

public class SearchServiceCustomImpl implements SearchService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int searchMin(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to find min element start");
        ArrayValidatorUtil.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        int min = array[0];
        for (int i : array) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    @Override
    public int searchMax(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to find max element start");
        ArrayValidatorUtil.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        int max = array[0];
        for (int i : array) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
}
