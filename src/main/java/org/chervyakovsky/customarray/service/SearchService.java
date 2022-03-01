package org.chervyakovsky.customarray.service;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

public interface SearchService {

    int searchMin(CustomArray customArray) throws CustomException;

    int searchMax(CustomArray customArray) throws CustomException;
}
