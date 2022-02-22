package org.chervyakovsky.customarray.service.impl.customImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.CalculateService;

public class CalculateServiceCustomImpl implements CalculateService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int sumArrayElements(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to calculate sum of array start");
        if (customArray == null) {
            throw new CustomException("Array can not be NULL");
        }
        int[] array = customArray.getArray();
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        LOGGER.info("Sum of elements: " + sum);
        return sum;
    }

    @Override
    public double averageArrayElements(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to calculate average value start");
        if (customArray == null) {
            throw new CustomException("Array can not be NULL");
        }
        try {
            double average = (double) sumArrayElements(customArray) / (customArray.getArray().length);
            LOGGER.info("Average value: " + average);
            return average;
        } catch (ArithmeticException e) {
            LOGGER.error("Division by zero. Array is empty");
            throw new CustomException(e);
        }
    }

    @Override
    public int determineAmountNegDigit(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to count amount of negative elements in array start");
        if (customArray == null) {
            throw new CustomException("Array can not be NULL");
        }
        int amount = 0;
        for (int i : customArray.getArray()) {
            if (i < 0) {
                amount++;
            }
        }
        LOGGER.info("Amount of negative elements: " + amount);
        return amount;
    }

    @Override
    public int determineAmountPosDigit(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to count amount of positive elements in array start");
        if (customArray == null) {
            throw new CustomException("Array can not be NULL");
        }
        int amount = 0;
        for (int i : customArray.getArray()) {
            if (i > 0) {
                amount++;
            }
        }
        LOGGER.info("Amount of positive elements: " + amount);
        return amount;
    }

}
