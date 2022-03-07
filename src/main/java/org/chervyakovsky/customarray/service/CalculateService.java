package org.chervyakovsky.customarray.service;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface CalculateService {

    OptionalInt sumArrayElements(CustomArray customArray) throws CustomException;

    OptionalDouble averageArrayElements(CustomArray customArray) throws CustomException;

    int determineAmountNegDigit(CustomArray customArray) throws CustomException;

    int determineAmountPosDigit(CustomArray customArray) throws CustomException;

}
