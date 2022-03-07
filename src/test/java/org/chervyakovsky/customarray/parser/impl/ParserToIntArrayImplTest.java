package org.chervyakovsky.customarray.parser.impl;

import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.parser.ParserToIntArray;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ParserToIntArrayImplTest {

    private ParserToIntArray parser;

    @DataProvider(name = "data_with_invalid_strings")
    public Object[][] createDataWithInvalidString() {
        Object[][] data = new Object[1][1];
        data[0] = new Object[]{
                Arrays.asList("sgsg", "sb   664  gfr", "//", "  *")
        };
        return data;
    }

    @DataProvider(name = "data_with_valid_strings_for_parse_all")
    public Object[][] createDataWithValidStringForParseAll() {
        Object[][] data = new Object[2][2];
        data[0] = new Object[]{
                Arrays.asList("1, 2, 3", "55, 66", "1fd, 55", "  "),
                Arrays.asList(new int[]{1, 2, 3}, new int[]{55, 66}, new int[0])
        };
        data[1] = new Object[]{
                Arrays.asList("", "sdfg sg sg", "    44", "  "),
                Arrays.asList(new int[0], new int[]{44}, new int[0])
        };
        return data;
    }

    @DataProvider(name = "data_with_valid_strings_for_parse_first")
    public Object[][] createDataWithValidStringForParseFirst() {
        Object[][] data = new Object[2][2];
        data[0] = new Object[]{
                Arrays.asList("1, 2, 3", "55, 66", "1fd, 55", "  "),
                new int[]{1, 2, 3}
        };
        data[1] = new Object[]{
                Arrays.asList("", "sdfg sg sg", "    44", "  "),
                new int[0]
        };
        return data;
    }

    @BeforeClass
    public void setParser() {
        parser = new ParserToIntArrayImpl();
    }

    @Test(dataProvider = "data_with_invalid_strings", expectedExceptions = CustomException.class)
    public void withInvalidStringsParseAllTest(List<String> noValidStrings) throws CustomException {
        parser.parseAll(noValidStrings);
    }

    @Test(dataProvider = "data_with_invalid_strings", expectedExceptions = CustomException.class)
    public void withInvalidStringsParseFirstTest(List<String> noValidStrings) throws CustomException {
        parser.parseFirst(noValidStrings);
    }

    @Test(dataProvider = "data_with_valid_strings_for_parse_all")
    public void testParseAll(List<String> stringList, List<int[]> expected) throws CustomException {
        List<int[]> actual = parser.parseAll(stringList);
        boolean result = Arrays.deepEquals(actual.toArray(), expected.toArray());
        Assert.assertTrue(result);
    }

    @Test(dataProvider = "data_with_valid_strings_for_parse_first")
    public void testParseFirst(List<String> stringList, int[] expected) throws CustomException {
        int[] actual = parser.parseFirst(stringList);
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void deleteParser() {
        parser = null;
    }
}