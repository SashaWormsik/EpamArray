package org.chervyakovsky.customarray.service.impl.customImpl;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.SearchService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.OptionalInt;

import static org.testng.Assert.assertEquals;

public class SearchServiceCustomImplTest {
    SearchService searchService;

    @DataProvider(name = "data_for_min")
    public Object[][] createDataForMinTest() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(1, 2, 3, -555, 0),
                OptionalInt.of(-555)};
        data[1] = new Object[]{
                new CustomArray(),
                OptionalInt.empty()};
        data[2] = new Object[]{
                new CustomArray(0, 0, 0),
                OptionalInt.of(0)};
        return data;
    }

    @DataProvider(name = "data_for_max")
    public Object[][] createDataForMaxTest() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(1, 2, 3, -555, 0),
                OptionalInt.of(3)};
        data[1] = new Object[]{
                new CustomArray(),
                OptionalInt.empty()};
        data[2] = new Object[]{
                new CustomArray(0, 0, 0),
                OptionalInt.of(0)};
        return data;
    }

    @BeforeClass
    public void setSearchService() {
        searchService = new SearchServiceCustomImpl();
    }

    @Test(dataProvider = "data_for_min")
    public void searchMinTest(CustomArray customArray, OptionalInt expected) throws CustomException {
        OptionalInt actual = searchService.searchMin(customArray);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_max")
    public void searchMaxTest(CustomArray customArray, OptionalInt expected) throws CustomException {
        OptionalInt actual = searchService.searchMax(customArray);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void nullExceptionSearchMinTest() throws CustomException {
        searchService.searchMin(null);
    }

    @Test(expectedExceptions = CustomException.class)
    public void nullExceptionSearchMaxTest() throws CustomException {
        searchService.searchMax(null);
    }

    @AfterClass
    public void deleteSearchService() {
        searchService = null;
    }
}
