package org.chervyakovsky.customarray.service.impl.customImpl;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.SortingService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortingServiceCustomImplTest {

    SortingService sortingService = new SortingServiceCustomImpl();
    CustomArray customArray = new CustomArray(2, 3, 0, -4);

    @Test
    public void bubbleSortTest() throws CustomException {
        int[] expect = new int[] {-4, 0, 2, 3};
        sortingService.bubbleSort(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(actual, expect);
    }

    @Test
    public void selectionSortTest() throws CustomException {
        int[] expect = new int[] {-4, 0, 2, 3};
        sortingService.selectionSort(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(actual, expect);
    }

    @Test
    public void insertionSortTest() throws CustomException {
        int[] expect = new int[] {-4, 0, 2, 3};
        sortingService.insertionSort(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(actual, expect);
    }
}
