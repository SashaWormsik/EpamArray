package org.chervyakovsky.customarray.service.impl.customImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.util.ArrayValidatorUtils;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CalculateServiceCustomImpl implements CalculateService {

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
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return OptionalInt.of(sum);
    }

    @Override
    public OptionalDouble averageArrayElements(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to calculate average value start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        int lengthArray = customArray.getArray().length;
        OptionalInt sum = sumArrayElements(customArray);
        if (lengthArray == 0 || !sum.isPresent()) {
            LOGGER.info("It is impossible to calculate the average, the number of elements is 0 in " + customArray);
            return OptionalDouble.empty();
        } else {
            double average = (double) sum.getAsInt() / lengthArray;
            return OptionalDouble.of(average);
        }
    }

    @Override
    public int determineAmountNegDigit(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to count amount of negative elements in array start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
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
        ArrayValidatorUtils.checkingCustomArray(customArray);
        int amount = 0;
        for (int i : customArray.getArray()) {
            if (i > 0) {
                amount++;
            }
        }
        return amount;
    }

}
