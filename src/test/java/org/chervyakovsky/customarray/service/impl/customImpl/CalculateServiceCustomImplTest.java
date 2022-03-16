package org.chervyakovsky.customarray.service.impl.customImpl;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.CalculateService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CalculateServiceCustomImplTest {

    private CalculateService calculateService;

    @DataProvider(name = "data_for_sum")
    public Object[][] createDataForSum() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(1, 2, 3),
                OptionalInt.of(6)};
        data[1] = new Object[]{
                new CustomArray(),
                OptionalInt.empty()};
        data[2] = new Object[]{
                new CustomArray(0, -3, 3),
                OptionalInt.of(0)};
        return data;
    }

    @DataProvider(name = "data_for_average")
    public Object[][] createDataForAverage() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(1, 2, 3),
                OptionalDouble.of(2)};
        data[1] = new Object[]{
                new CustomArray(),
                OptionalDouble.empty()};
        data[2] = new Object[]{
                new CustomArray(0, -3, 3),
                OptionalDouble.of(0)};
        return data;
    }

    @DataProvider(name = "data_for_amountNegDigit")
    public Object[][] createDataForAmountNegDigit() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(1, 2, 3),
                0};
        data[1] = new Object[]{
                new CustomArray(),
                0};
        data[2] = new Object[]{
                new CustomArray(0, -3, -5, -9, 3),
                3};
        return data;
    }

    @DataProvider(name = "data_for_amountPosDigit")
    public Object[][] createDataForAmountPosDigit() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(1, 2, 3),
                3};
        data[1] = new Object[]{
                new CustomArray(),
                0};
        data[2] = new Object[]{
                new CustomArray(0, -3, 3),
                1};
        return data;
    }

    @BeforeClass
    public void setCalculateService() {
        calculateService = new CalculateServiceCustomImpl();
    }

    @Test(dataProvider = "data_for_sum")
    public void sumArrayElementsTest(CustomArray customArray, OptionalInt expected) throws CustomException {
        OptionalInt actual = calculateService.sumArrayElements(customArray);
        Assert.assertEquals(actual, expected);
    }


    @Test(dataProvider = "data_for_average")
    public void averageArrayElementsTest(CustomArray customArray, OptionalDouble expected) throws CustomException {
        OptionalDouble actual = calculateService.averageArrayElements(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_amountNegDigit")
    public void determineAmountNegDigitTest(CustomArray customArray, int expected) throws CustomException {
        int actual = calculateService.determineAmountNegDigit(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_amountPosDigit")
    public void determineAmountPosDigitTest(CustomArray customArray, int expected) throws CustomException {
        int actual = calculateService.determineAmountPosDigit(customArray);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void nullExceptionSumArrayElementsTest() throws CustomException {
        calculateService.sumArrayElements(null);
    }

    @Test(expectedExceptions = CustomException.class)
    public void nullExceptionAverageArrayElementsTest() throws CustomException {
        calculateService.averageArrayElements(null);
    }

    @Test(expectedExceptions = CustomException.class)
    public void nullExceptionDetermineAmountNegDigitTest() throws CustomException {
        calculateService.determineAmountNegDigit(null);
    }

    @Test(expectedExceptions = CustomException.class)
    public void nullExceptionDetermineAmountPosDigitTest() throws CustomException {
        calculateService.determineAmountPosDigit(null);
    }

    @AfterClass
    public void deleteCalculateService() {
        calculateService = null;
    }
}
