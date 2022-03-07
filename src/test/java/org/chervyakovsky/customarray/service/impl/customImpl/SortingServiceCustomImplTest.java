package org.chervyakovsky.customarray.service.impl.customImpl;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.SortingService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortingServiceCustomImplTest {

    private SortingService sortingService;

    @DataProvider(name = "data")
    public Object[][] createData() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(),
                new CustomArray()};
        data[1] = new Object[]{
                new CustomArray(555),
                new CustomArray(555)};
        data[2] = new Object[]{
                new CustomArray(5, -6, 8, 0, -100),
                new CustomArray(-100, -6, 0, 5, 8)};
        return data;
    }

    @BeforeClass
    public void setSortingService() {
        sortingService = new SortingServiceCustomImpl();
    }

    @Test(dataProvider = "data")
    public void bubbleSortTest(CustomArray actual, CustomArray expected) throws CustomException {
        sortingService.bubbleSort(actual);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "data")
    public void selectionSortTest(CustomArray actual, CustomArray expected) throws CustomException {
        sortingService.selectionSort(actual);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "data")
    public void insertionSortTest(CustomArray actual, CustomArray expected) throws CustomException {
        sortingService.insertionSort(actual);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "data")
    public void testStreamSort(CustomArray actual, CustomArray expected) throws CustomException {
        sortingService.streamSort(actual);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void exceptionBubbleSortTest() throws CustomException {
        sortingService.bubbleSort(new CustomArray(null));
    }

    @Test(expectedExceptions = CustomException.class)
    public void exceptionSelectionSortTest() throws CustomException {
        sortingService.selectionSort(new CustomArray(null));
    }

    @Test(expectedExceptions = CustomException.class)
    public void exceptionInsertionSortTest() throws CustomException {
        sortingService.insertionSort(new CustomArray(null));
    }

    @Test(expectedExceptions = CustomException.class)
    public void nullExceptionBubbleSortTest() throws CustomException {
        sortingService.bubbleSort(null);
    }

    @Test(expectedExceptions = CustomException.class)
    public void nullExceptionSelectionSortTest() throws CustomException {
        sortingService.selectionSort(null);
    }

    @Test(expectedExceptions = CustomException.class)
    public void nullExceptionInsertionSortTest() throws CustomException {
        sortingService.insertionSort(null);
    }

    @AfterClass
    public void deleteSortingService() {
        sortingService = null;
    }

}
