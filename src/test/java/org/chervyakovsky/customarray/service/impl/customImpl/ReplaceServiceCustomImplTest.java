package org.chervyakovsky.customarray.service.impl.customImpl;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.ReplaceService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReplaceServiceCustomImplTest {

    ReplaceService replaceService = new ReplaceServiceCustomImpl();


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
