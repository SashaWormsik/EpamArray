package org.chervyakovsky.customarray.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.repository.Specification;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.service.impl.customImpl.CalculateServiceCustomImpl;

public class SpecificationByLargeAverage implements Specification {

    private static final Logger LOGGER = LogManager.getLogger();
    private double comparedValue;

    public SpecificationByLargeAverage(double comparedValue) {
        this.comparedValue = comparedValue;
    }


    @Override
    public boolean specify(CustomArray customArray) {
        boolean result = false;
        CalculateService calculateService = new CalculateServiceCustomImpl();
        try {
            double average = calculateService.averageArrayElements(customArray);
            result = (average > this.comparedValue);
        } catch (CustomException e) {
            LOGGER.error("The average value is not calculated", e);
        }
        return result;
    }
}
