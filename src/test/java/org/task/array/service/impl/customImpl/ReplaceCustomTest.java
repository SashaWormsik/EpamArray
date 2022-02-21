package org.task.array.service.impl.customImpl;

import org.task.array.entity.CustomArray;
import org.task.array.exception.CustomException;
import org.task.array.service.ReplaceService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReplaceCustomTest {

    ReplaceService replaceService = new ReplaceCustom();


    @Test
    public void replaceAllTest() throws CustomException {
        int[] expect = new int[] {0, 2, 3, -4};
        CustomArray customArray = new CustomArray(1, 2, 3, -4);
        replaceService.replaceAll(customArray, 0, 1);
        int[] actual = customArray.getArray();
        Assert.assertEquals(actual, expect);
    }

    @Test
    public void replaceNegativeValueTest() throws CustomException {
        int[] expect = new int[] {1, 2, 3, 0};
        CustomArray customArray = new CustomArray(1, 2, 3, -4);
        replaceService.replaceNegativeValue(customArray, 0);
        int[] actual = customArray.getArray();
        Assert.assertEquals(actual, expect);
    }
}
