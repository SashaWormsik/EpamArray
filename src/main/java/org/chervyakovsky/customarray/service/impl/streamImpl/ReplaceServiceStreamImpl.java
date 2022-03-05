package org.chervyakovsky.customarray.service.impl.streamImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.ReplaceService;
import org.chervyakovsky.customarray.util.ArrayValidatorUtil;

import java.util.Arrays;

public class ReplaceServiceStreamImpl implements ReplaceService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void replaceAll(CustomArray customArray, int newValue, int oldValue) throws CustomException {
        LOGGER.info("Method replace elements start");
        ArrayValidatorUtil.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        if (array.length == 0) {
            return;
        }
        array = Arrays.stream(array).map((x) -> (x == oldValue) ? newValue : x).toArray();
        customArray.setArray(array);
    }

    @Override
    public void replaceNegativeValue(CustomArray customArray, int newValue) throws CustomException {
        LOGGER.info("Method replace elements start");
        ArrayValidatorUtil.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        if (array.length == 0) {
            return;
        }
        array = Arrays.stream(array).map((x) -> (x < 0) ? newValue : x).toArray();
        customArray.setArray(array);
    }
}
