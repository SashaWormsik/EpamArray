package org.task.array.service.impl.customImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.task.array.entity.CustomArray;
import org.task.array.exception.CustomException;
import org.task.array.service.ReplaceService;

public class ReplaceCustom implements ReplaceService {

    Logger logger = LogManager.getLogger();

    @Override
    public void replaceAll(CustomArray customArray, int nValue, int oldValue) throws CustomException {
        logger.info("Method replace elements start");
        if(customArray.getArray().length == 0){
            throw new CustomException("Array is empty");
        }
        int [] array = customArray.getArray();
        for (int i = 0; i < array.length; i++){
            if (array[i] == oldValue){
                array[i] = nValue;
            }
        }
        customArray.setArray(array);
        logger.info("elements are replaced");
    }

    @Override
    public void replaceNegativeValue(CustomArray customArray, int nValue) throws CustomException {
        logger.info("Method replace elements start");
        if(customArray.getArray().length == 0){
            throw new CustomException("Array is empty");
        }
        int [] array = customArray.getArray();
        for (int i = 0; i < array.length; i++){
            if (array[i] < 0){
                array[i] = nValue;
            }
        }
        customArray.setArray(array);
        logger.info("elements are replaced");
    }
}
