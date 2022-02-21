package org.task.array.service;

import org.task.array.entity.CustomArray;
import org.task.array.exception.CustomException;

public interface SearchService {

    int searchMin(CustomArray customArray) throws CustomException;

    int searchMax(CustomArray customArray) throws CustomException;
}
