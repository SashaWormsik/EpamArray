package org.task.array.service;

import org.task.array.entity.CustomArray;
import org.task.array.exception.CustomException;

public interface SortingService {

    void selectionSort(CustomArray customArray) throws CustomException;

    void bubbleSort(CustomArray customArray) throws CustomException;

    void insertionSort(CustomArray customArray) throws CustomException;
}
