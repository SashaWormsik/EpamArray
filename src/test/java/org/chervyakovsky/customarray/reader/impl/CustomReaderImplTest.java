package org.chervyakovsky.customarray.reader.impl;

import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.reader.CustomReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomReaderImplTest {

    private static final String FILENAME_DATA_EMPTY = "./src/test/resources/data/dataEmpty.txt";
    private static final String FILENAME_DATA_WITH_STRINGS = "./src/test/resources/data/dataWithStrings.txt";
    private static final String INCORRECT_FILENAME = "./src/test/resources/data/data.txt";

    private CustomReader reader;

    @DataProvider(name = "data_with_strings")
    public Object[][] createDataWithStrings() {
        Object[][] data = new Object[2][2];
        data[0] = new Object[]{
                FILENAME_DATA_WITH_STRINGS,
                Arrays.asList("", "1, 2, 3, -4", "54, 6")
        };
        data[1] = new Object[]{
                FILENAME_DATA_EMPTY,
                new ArrayList<String>()
        };
        return data;
    }

    @BeforeClass
    public void setReader() {
        reader = new CustomReaderImpl();
    }

    @Test(dataProvider = "data_with_strings")
    public void readAllFileTest(String fileName, List<String> expected) throws CustomException {
        List<String> stringsFromFile = reader.readAllFile(fileName);
        boolean result = Arrays.deepEquals(stringsFromFile.toArray(), expected.toArray());
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "The problem with reading the file")
    public void incorrectReadAllFileTest() throws CustomException {
        reader.readAllFile(INCORRECT_FILENAME);
    }
}