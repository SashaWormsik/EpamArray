package org.chervyakovsky.customarray.service.impl.streamImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.util.ArrayValidatorUtils;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CalculateServiceStreamImpl implements CalculateService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public OptionalInt sumArrayElements(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to calculate sum of array start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        if (customArray.getArray().length == 0) {
            LOGGER.info("It is impossible to calculate the sum, the number of elements is 0 in " + customArray);
            return OptionalInt.empty();
        }
        int[] array = customArray.getArray();
        return OptionalInt.of(Arrays.stream(array).sum());
    }

    @Override
    public OptionalDouble averageArrayElements(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to calculate average value start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        return Arrays.stream(array).average();

    }

    @Override
    public int determineAmountNegDigit(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to count amount of negative elements in array start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        return (int) Arrays.stream(array).filter(x -> x < 0).count();
    }

    @Override
    public int determineAmountPosDigit(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to count amount of positive elements in array start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        return (int) Arrays.stream(array).filter(x -> x > 0).count();
    }
}
