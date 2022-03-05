package org.chervyakovsky.customarray.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.repository.Specification;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.service.impl.customImpl.CalculateServiceCustomImpl;

public class SpecificationBySmallerSum implements Specification {

    private static final Logger LOGGER = LogManager.getLogger();
    private double comparedValue;

    public SpecificationBySmallerSum(double comparedValue) {
        this.comparedValue = comparedValue;
    }


    @Override
    public boolean specify(CustomArray customArray) {
        boolean result = false;
        CalculateService calculateService = new CalculateServiceCustomImpl();
        try {
            double sum = calculateService.sumArrayElements(customArray);
            result = (sum < this.comparedValue);
        } catch (CustomException e) {
            LOGGER.error("The sum value is not calculated", e);
        }
        return result;
    }
}
