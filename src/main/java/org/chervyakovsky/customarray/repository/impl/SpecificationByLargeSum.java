package org.chervyakovsky.customarray.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.repository.Specification;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.service.impl.customImpl.CalculateServiceCustomImpl;

import java.util.OptionalInt;

public class SpecificationByLargeSum implements Specification {

    private static final Logger LOGGER = LogManager.getLogger();
    private double comparedValue;

    public SpecificationByLargeSum(double comparedValue) {
        this.comparedValue = comparedValue;
    }


    @Override
    public boolean specify(CustomArray customArray) {
        boolean result = false;
        CalculateService calculateService = new CalculateServiceCustomImpl();
        try {
            OptionalInt sum = calculateService.sumArrayElements(customArray);
            if (sum.isPresent()) {
                result = (sum.getAsInt() > this.comparedValue);
            } else {
                LOGGER.info("Sum optional is empty" + sum);
            }
        } catch (CustomException exception) {
            LOGGER.error("The sum value is not calculated", exception);
        }
        return result;
    }
}
