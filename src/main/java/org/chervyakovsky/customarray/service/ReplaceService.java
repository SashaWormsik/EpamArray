package org.chervyakovsky.customarray.service;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

public interface ReplaceService {

    void replaceAll(CustomArray customArray, int newValue, int oldValue) throws CustomException;

    void replaceNegativeValue(CustomArray customArray, int newValue) throws CustomException;
}
