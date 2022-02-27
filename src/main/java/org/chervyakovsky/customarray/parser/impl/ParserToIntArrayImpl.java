package org.chervyakovsky.customarray.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.parser.ParserToIntArray;
import org.chervyakovsky.customarray.validator.CustomerArrayValidator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ParserToIntArrayImpl implements ParserToIntArray {

    private static final String SEPARATOR = ",";
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<int[]> parseAll(List<String> dataString) throws CustomException {
        LOGGER.info("Parse all valid strings in List<String>");
        validateListString(dataString);
        List<int[]> listInt = new ArrayList<>();
        CustomerArrayValidator validator = CustomerArrayValidator.getInstance();
        Iterator<String> dataStringIterator = dataString.listIterator();
        while (dataStringIterator.hasNext()){
            String string = dataStringIterator.next();
            if (validator.isValid(string)){
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
        int[] arrayInt = new int [0]; //FIXME
        CustomerArrayValidator validator = CustomerArrayValidator.getInstance();
        Iterator<String> dataStringIterator = dataString.listIterator();
        while (dataStringIterator.hasNext()){
            String string = dataStringIterator.next();
            if (validator.isValid(string)){
                arrayInt = parseToIntArrayFromString(string);
                break;
            }
        }
        return arrayInt;
    }

    private void validateString(String string) throws CustomException { //FIXME
        CustomerArrayValidator validator = CustomerArrayValidator.getInstance();
        if (string == null) {
            LOGGER.error("String is NULL");
            throw new CustomException("String is NULL in validateString method");
        }
        if (!validator.isValid(string)) {
            LOGGER.error("Incorrect string");
            throw new CustomException("Incorrect string: " + string);
        }
    }

    private void validateListString(List<String> dataString) throws CustomException { //FIXME
        CustomerArrayValidator validator = CustomerArrayValidator.getInstance();
        if (dataString == null) {
            LOGGER.error("String is NULL");
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

    private int[] parseToIntArrayFromString(String string) { // FIXME
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

     /* public List<int[]> parseAll(List<String> dataString) throws CustomException {
        LOGGER.info("Method to parse data from string start");
        if (dataString == null) {
            LOGGER.log(Level.ERROR, "Incorrect line dataString");
            throw new CustomException("The passed array of strings is NULL");
        }
        int[] array = new int[0];
        Iterator<String> dataStringIterator = dataString.listIterator();
        while (dataStringIterator.hasNext()) {
            String string = dataStringIterator.next();
            if (string.trim().isEmpty()) {
                break;
            } else if (true) {
                array = Stream.of(string.split(SEPARATOR))
                        .map(String::trim)
                        .mapToInt(Integer::valueOf)
                        .toArray();
                break;
            }
        }
        return null;
    }*/

}
