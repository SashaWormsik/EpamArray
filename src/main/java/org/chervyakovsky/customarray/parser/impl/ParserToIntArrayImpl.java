package org.chervyakovsky.customarray.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.parser.ParserToIntArray;
import org.chervyakovsky.customarray.validator.CustomArrayValidator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ParserToIntArrayImpl implements ParserToIntArray {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SEPARATOR = ",";

    @Override
    public List<int[]> parseAll(List<String> dataString) throws CustomException {
        LOGGER.info("Parse all valid strings in List<String>");
        validateListString(dataString);
        List<int[]> listInt = new ArrayList<>();
        CustomArrayValidator validator = CustomArrayValidator.getInstance();
        Iterator<String> dataStringIterator = dataString.listIterator();
        while (dataStringIterator.hasNext()) {
            String string = dataStringIterator.next();
            if (validator.isValid(string)) {
                int[] arrayInt = parseToIntArrayFromString(string);
                listInt.add(arrayInt);
            }
        }
        return listInt;
    }

    @Override
    public int[] parseFirst(List<String> dataString) throws CustomException {
        LOGGER.info("Parse first valid string in List<String>");
        validateListString(dataString);
        int[] arrayInt = new int[0];
        CustomArrayValidator validator = CustomArrayValidator.getInstance();
        Iterator<String> dataStringIterator = dataString.listIterator();
        while (dataStringIterator.hasNext()) {
            String string = dataStringIterator.next();
            if (validator.isValid(string)) {
                arrayInt = parseToIntArrayFromString(string);
                break;
            }
        }
        return arrayInt;
    }

    private void validateListString(List<String> dataString) throws CustomException {
        CustomArrayValidator validator = CustomArrayValidator.getInstance();
        if (dataString == null) {
            LOGGER.error("List<String> is NULL");
            throw new CustomException("List strings is NULL in validateListString method");
        }
        boolean noValidString = true;
        for (String string : dataString) {
            if (validator.isValid(string)) {
                noValidString = false;
            }
        }
        if (noValidString) {
            LOGGER.error("Incorrect string");
            throw new CustomException("List strings is incorrect in validateListString method");
        }
    }

    private int[] parseToIntArrayFromString(String string) {
        LOGGER.info("Parse from String to int[]");
        int[] arrayInt;
        if (string.trim().isEmpty()) {
            arrayInt = new int[0];
        } else {
            arrayInt = Stream.of(string.split(SEPARATOR))
                    .map(String::trim)
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }
        return arrayInt;
    }

}
