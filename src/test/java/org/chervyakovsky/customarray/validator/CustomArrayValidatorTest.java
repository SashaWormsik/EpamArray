package org.chervyakovsky.customarray.validator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomArrayValidatorTest {

    private CustomArrayValidator validator;

    @DataProvider(name = "data_valid_strings")
    public Object[][] createDataValidStrings() {
        Object[][] data = new Object[3][1];
        data[0] = new Object[]{""};
        data[1] = new Object[]{"1, 2, 3  ,   -5"};
        data[2] = new Object[]{"5, 6  ,   88"};
        return data;
    }

    @DataProvider(name = "data_invalid_strings")
    public Object[][] createDataInvalidStrings() {
        Object[][] data = new Object[3][1];
        data[0] = new Object[]{"ert"};
        data[1] = new Object[]{"1, fd2, 3  ,   -5"};
        data[2] = new Object[]{"!"};
        return data;
    }

    @BeforeClass
    public void setValidator() {
        validator = CustomArrayValidator.getInstance();
    }

    @Test(dataProvider = "data_valid_strings")
    public void withValidStringIsValidStringForIntArrayTest(String checkString) {
        Assert.assertTrue(validator.isValidStringForIntArray(checkString));
    }

    @Test(dataProvider = "data_invalid_strings")
    public void withInvalidStringIsValidStringForIntArrayTest(String checkString) {
        Assert.assertFalse(validator.isValidStringForIntArray(checkString));
    }

    @AfterClass
    public void deleteValidator() {
        validator = null;
    }
}