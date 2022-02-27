package org.chervyakovsky.customarray.service;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

public interface SortingService {

    void selectionSort(CustomArray customArray) throws CustomException;

    void bubbleSort(CustomArray customArray) throws CustomException;

    void insertionSort(CustomArray customArray) throws CustomException;

    void streamSort(CustomArray customArray) throws CustomException;
}
