package org.chervyakovsky.customarray.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.repository.Specification;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.service.impl.customImpl.CalculateServiceCustomImpl;

import java.util.OptionalDouble;

public class SpecificationBySmallerAverage implements Specification {

    private static final Logger LOGGER = LogManager.getLogger();
    private double comparedValue;

    public SpecificationBySmallerAverage(double comparedValue) {
        this.comparedValue = comparedValue;
    }


    @Override
    public boolean specify(CustomArray customArray) {
        boolean result = false;
        CalculateService calculateService = new CalculateServiceCustomImpl();
        try {
            OptionalDouble average = calculateService.averageArrayElements(customArray);
            if (average.isPresent()) {
                result = (average.getAsDouble() < this.comparedValue);
            } else {
                LOGGER.info("Average optional is empty" + average);
            }
        } catch (CustomException exception) {
            LOGGER.error("The average value is not calculated", exception);
        }
        return result;
    }
}
