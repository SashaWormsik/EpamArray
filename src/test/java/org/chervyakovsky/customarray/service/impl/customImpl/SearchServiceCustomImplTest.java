package org.chervyakovsky.customarray.service.impl.customImpl;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.SearchService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchServiceCustomImplTest {
    SearchService searchService = new SearchServiceCustomImpl();
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
