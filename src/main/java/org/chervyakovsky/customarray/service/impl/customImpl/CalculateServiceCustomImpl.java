package org.chervyakovsky.customarray.service.impl.customImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.util.ArrayValidatorUtil;

public class CalculateServiceCustomImpl implements CalculateService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int sumArrayElements(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to calculate sum of array start");
        ArrayValidatorUtil.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    @Override
    public double averageArrayElements(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to calculate average value start");
        ArrayValidatorUtil.checkingCustomArray(customArray);
        try {
            double average = (double) sumArrayElements(customArray) / customArray.getArray().length;
            return average;
        } catch (ArithmeticException e) {
            LOGGER.error("Division by zero. Array is empty", e);
            throw new CustomException("Division by zero. Array is empty", e);
        }
    }

    @Override
    public int determineAmountNegDigit(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to count amount of negative elements in array start");
        ArrayValidatorUtil.checkingCustomArray(customArray);
        int amount = 0;
        for (int i : customArray.getArray()) {
            if (i < 0) {
                amount++;
            }
        }
        return amount;
    }

    @Override
    public int determineAmountPosDigit(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to count amount of positive elements in array start");
        ArrayValidatorUtil.checkingCustomArray(customArray);
        int amount = 0;
        for (int i : customArray.getArray()) {
            if (i > 0) {
                amount++;
            }
        }
        return amount;
    }

}
