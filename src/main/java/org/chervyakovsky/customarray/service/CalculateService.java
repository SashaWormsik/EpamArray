package org.chervyakovsky.customarray.service;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

public interface CalculateService {

    int sumArrayElements(CustomArray customArray) throws CustomException;

    double averageArrayElements(CustomArray customArray) throws CustomException;

    int determineAmountNegDigit(CustomArray customArray) throws CustomException;

    int determineAmountPosDigit(CustomArray customArray) throws CustomException;

}
