package org.chervyakovsky.customarray.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.service.impl.customImpl.CalculateServiceCustomImpl;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ComparatorUtils {

    private static final Logger LOGGER = LogManager.getLogger();

    public static double findAverage(CustomArray customArray) {
        CalculateService calculateService = new CalculateServiceCustomImpl();
        double resultAverage = Double.MIN_VALUE;
        try {
            OptionalDouble average = calculateService.averageArrayElements(customArray);
            if (average.isPresent()) {
                resultAverage = average.getAsDouble();
            } else {
                LOGGER.info("Average is empty value");
            }
        } catch (CustomException e) {
            LOGGER.error("The average value cannot be calculated", e);
        }
        return resultAverage;
    }

    public static int findSum(CustomArray customArray) {
        CalculateService calculateService = new CalculateServiceCustomImpl();
        int resultSum = Integer.MIN_VALUE;
        try {
            OptionalInt sum = calculateService.sumArrayElements(customArray);
            if (sum.isPresent()) {
                resultSum = sum.getAsInt();
            } else {
                LOGGER.info("Sum is empty value");
            }
        } catch (CustomException exception) {
            LOGGER.error("Sum cannot be calculated", exception);
        }
        return resultSum;
    }
}
