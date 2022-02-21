package org.task.array.service.impl.customImpl;

import org.task.array.entity.CustomArray;
import org.task.array.exception.CustomException;
import org.task.array.service.SearchService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCustomTest {
    SearchService searchService = new SearchCustom();
    CustomArray customArray = new CustomArray(1, 2, 3, -4);

    @Test
    public void searchMinTest() throws CustomException {
        int actual = searchService.searchMin(customArray);
        Assert.assertEquals(actual, -4);
    }

    @Test
    public void searchMaxTest() throws CustomException {
        int actual = searchService.searchMax(customArray);
        Assert.assertEquals(actual, 3);
    }
}
