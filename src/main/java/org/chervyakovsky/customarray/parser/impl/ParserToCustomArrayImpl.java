package org.chervyakovsky.customarray.parser.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.parser.ParserToCustomArray;
import org.chervyakovsky.customarray.validator.CustomerArrayValidator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ParserToCustomArrayImpl implements ParserToCustomArray {

    private static final String SEPARATOR = ",";
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int[] parse(List<String> dataString) throws CustomException {
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
            } else if (CustomerArrayValidator.isValid(string)) {
                array = Stream.of(string.split(SEPARATOR))
                        .map(String::trim)
                        .mapToInt(Integer::valueOf)
                        .toArray();
                break;
            }
        }
        return array;
    }
}
