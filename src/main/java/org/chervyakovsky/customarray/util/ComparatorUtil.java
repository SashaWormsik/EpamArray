package org.chervyakovsky.customarray.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.service.impl.customImpl.CalculateServiceCustomImpl;

public class ComparatorUtil {

    private static final Logger LOGGER = LogManager.getLogger();

    public static double findAverage(CustomArray customArray) {
        CalculateService calculateService = new CalculateServiceCustomImpl();
        double average = Double.MIN_VALUE;
        try {
            average = calculateService.averageArrayElements(customArray);
        } catch (CustomException e) {
            LOGGER.error("The average value cannot be calculated", e);
        }
        return average;
    }

    public static int findSum(CustomArray customArray) {
        CalculateService calculateService = new CalculateServiceCustomImpl();
        int sum = Integer.MIN_VALUE;
        try {
            sum = calculateService.sumArrayElements(customArray);
        } catch (CustomException e) {
            LOGGER.error("Sum cannot be calculated", e);
        }
        return sum;
    }
}
