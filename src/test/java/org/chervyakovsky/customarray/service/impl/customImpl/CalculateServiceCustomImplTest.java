package org.chervyakovsky.customarray.service.impl.customImpl;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.CalculateService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculateServiceCustomImplTest {

    CalculateService calculateService = new CalculateServiceCustomImpl();
    CustomArray customArray = new CustomArray(1, 2, 3, 4);

    @Test
    public void sumArrayElementsTest() throws CustomException {
        int actual  = calculateService.sumArrayElements(customArray);
        Assert.assertEquals(actual, 10);
    }


    @Test
    public void averageArrayElementsTest() throws CustomException {
        double actual = calculateService.averageArrayElements(customArray);
        Assert.assertEquals(actual, 2.5);
    }

    @Test
    public void determineAmountNegDigitTest() throws CustomException {
        int actual = calculateService.determineAmountNegDigit(customArray);
        Assert.assertEquals(actual, 0);
    }

    @Test
    public void determineAmountPosDigitTest()throws CustomException {
        int actual = calculateService.determineAmountPosDigit(customArray);
        Assert.assertEquals(actual, 4);
    }


}
