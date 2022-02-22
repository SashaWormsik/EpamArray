package org.chervyakovsky.customarray.service;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

public interface ReplaceService {

    void replaceAll(CustomArray customArray, int nValue, int oldValue) throws CustomException;

    void replaceNegativeValue(CustomArray customArray, int nValue) throws CustomException;
}
