package org.task.array.service;

import org.task.array.entity.CustomArray;
import org.task.array.exception.CustomException;

public interface CalculateService {

    int sumArrayElements(CustomArray customArray) throws CustomException;

    double averageArrayElements(CustomArray customArray) throws CustomException;

    int determineAmountNegDigit(CustomArray customArray) throws CustomException;

    int determineAmountPosDigit(CustomArray customArray) throws CustomException;

}
