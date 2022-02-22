package org.chervyakovsky.customarray.creator.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.creator.CreateCustomerArray;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

public class CreatorCustomerArrayImpl implements CreateCustomerArray {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public CustomArray createArray(int... array) throws CustomException {
        LOGGER.info("Method to create array start");
        if (array == null) {
            throw new CustomException("Array can not be NULL");
        }
        CustomArray createdArray = new CustomArray(array);
        LOGGER.info("created " + createdArray);
        return createdArray;
    }
}
