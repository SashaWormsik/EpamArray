package org.chervyakovsky.customarray.service.impl.customImpl;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.ReplaceService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReplaceServiceCustomImplTest {

    ReplaceService replaceService;

    @DataProvider(name = "data_for_replaceAllTest")
    public Object[][] createDataForReplaceAllTest() {
        Object[][] data = new Object[3][4];
        data[0] = new Object[]{
                new CustomArray(),
                0,
                100,
                new CustomArray()};
        data[1] = new Object[]{
                new CustomArray(1, 2, 3, 5, 3, 3),
                -44,
                3,
                new CustomArray(1, 2, -44, 5, -44, -44)};
        data[2] = new Object[]{new CustomArray(1, 2, 3, 5, 3, 3),
                8,
                -44,
                new CustomArray(1, 2, 3, 5, 3, 3)};
        return data;
    }

    @DataProvider(name = "data_for_replaceNegativeValueTest")
    public Object[][] createDataForReplaceNegativeValueTest() {
        Object[][] data = new Object[3][3];
        data[0] = new Object[]{
                new CustomArray(),
                100,
                new CustomArray()};
        data[1] = new Object[]{
                new CustomArray(1, 2, 3, 5, 3, 3),
                44,
                new CustomArray(1, 2, 3, 5, 3, 3)};
        data[2] = new Object[]{new CustomArray(1, 2, -3, -5, 3, 3),
                8,
                new CustomArray(1, 2, 8, 8, 3, 3)};
        return data;
    }

    @BeforeClass
    public void setCalculateService() {
        replaceService = new ReplaceServiceCustomImpl();
    }

    @Test(dataProvider = "data_for_replaceAllTest")
    public void replaceAllTest(CustomArray actual, int newValue, int oldValue, CustomArray expected) throws CustomException {
        replaceService.replaceAll(actual, newValue, oldValue);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceNegativeValueTest")
    public void replaceNegativeValueTest(CustomArray actual, int newValue, CustomArray expected) throws CustomException {
        replaceService.replaceNegativeValue(actual, newValue);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void nullExceptionReplaceAllTest() throws CustomException {
        replaceService.replaceAll(null, 0, 5);
    }

    @Test(expectedExceptions = CustomException.class)
    public void nullExceptionReplaceNegativeValueTest() throws CustomException {
        replaceService.replaceNegativeValue(null, 0);
    }

    @AfterClass
    public void deleteReplaceService() {
        replaceService = null;
    }
}
