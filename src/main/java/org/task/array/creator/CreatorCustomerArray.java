package org.task.array.creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.task.array.entity.CustomArray;
import org.task.array.exception.CustomException;

public class CreatorCustomerArray {

    Logger logger = LogManager.getLogger();

    public CustomArray createArray(int... array) throws CustomException {
        logger.info("Method to create array start");
        if (array == null) {
            throw new CustomException("Array can not be NULL");
        }
        CustomArray createdArray = new CustomArray(array);
        logger.info("created " + createdArray);
        return createdArray;
    }
}
