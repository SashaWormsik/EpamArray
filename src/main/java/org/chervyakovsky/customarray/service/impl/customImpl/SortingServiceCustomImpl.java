package org.chervyakovsky.customarray.service.impl.customImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.SortingService;
import org.chervyakovsky.customarray.util.ArrayValidatorUtils;

import java.util.Arrays;

public class SortingServiceCustomImpl implements SortingService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void selectionSort(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to sort array by selectionSort start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            int minIndex = minIndex(array, i, array.length);
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        customArray.setArray(array);
    }

    @Override
    public void bubbleSort(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to sort array by bubbleSort start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        customArray.setArray(array);
    }

    @Override
    public void insertionSort(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to sort array by insertionSort start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
        customArray.setArray(array);
    }

    @Override
    public void streamSort(CustomArray customArray) throws CustomException {
        LOGGER.info("Method to sort array by stream start");
        ArrayValidatorUtils.checkingCustomArray(customArray);
        int[] array = customArray.getArray();
        array = Arrays.stream(array).sorted().toArray();
        customArray.setArray(array);
    }

    private static int minIndex(int[] array, int start, int end) throws CustomException {
        if (array.length == 0) {
            LOGGER.error("Array is empty in minIndex method");
            throw new CustomException("Array is empty");
        }
        int minIndex = start;
        int minValue = array[start];
        for (int i = start + 1; i < end; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
