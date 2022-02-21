package org.task.array.service;

import org.task.array.entity.CustomArray;
import org.task.array.exception.CustomException;

public interface ReplaceService {

    void replaceAll(CustomArray customArray, int nValue, int oldValue) throws CustomException;

    void replaceNegativeValue(CustomArray customArray, int nValue) throws CustomException;
}
