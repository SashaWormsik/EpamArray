package org.chervyakovsky.customarray.service.impl.customImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.CalculateService;

public class CalculateServiceCustomImpl implements CalculateService {

    Logger logger = LogManager.getLogger();

    @Override
    public int sumArrayElements(CustomArray customArray) throws CustomException {
        logger.info("Method to calculate sum of array start");
        if (customArray.getArray().length == 0) {
            throw new CustomException("Array is empty");
        }
        int[] array = customArray.getArray();
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        logger.info("Sum of elements: " + sum);
        return sum;
    }

    @Override
    public double averageArrayElements(CustomArray customArray) throws CustomException {
        logger.info("Method to calculate average value start");
        if (customArray.getArray().length == 0) {
            throw new CustomException("Array is empty");
        }
        double average = (double) sumArrayElements(customArray) / (customArray.getArray().length);
        logger.info("Average value: " + average);
        return average;
    }

    @Override
    public int determineAmountNegDigit(CustomArray customArray) throws CustomException {
        logger.info("Method to count amount of negative elements in array start");
        if (customArray.getArray().length == 0) {
            throw new CustomException("Array is empty");
        }
        int amount = 0;
        for (int i : customArray.getArray()) {
            if (i < 0) {
                amount++;
            }
        }
        logger.info("Amount of negative elements: " + amount);
        return amount;
    }

    @Override
    public int determineAmountPosDigit(CustomArray customArray) throws CustomException {
        logger.info("Method to count amount of positive elements in array start");
        if (customArray.getArray().length == 0) {
            throw new CustomException("Array is empty");
        }
        int amount = 0;
        for (int i : customArray.getArray()) {
            if (i > 0) {
                amount++;
            }
        }
        logger.info("Amount of positive elements: " + amount);
        return amount;
    }

}
