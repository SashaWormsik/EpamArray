package org.task.array.service.impl.customImpl;

import org.task.array.entity.CustomArray;
import org.task.array.exception.CustomException;
import org.task.array.service.CalculateService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculateCustomTest {

    CalculateService calculateService = new CalculateCustom();
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
