package org.task.array.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.task.array.validator.CustomerValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserToIntArray {

    Logger logger = LogManager.getLogger();

    public int[] parsing(List<String> dataString) {
        logger.info("Method to parse data from string start");
        List<Integer> integers = new ArrayList<>();
        for (String string : dataString) {
            if (CustomerValidator.isValid(string)) {
                integers.addAll(Stream.of(string.split(","))
                        .map(String::trim)
                        .mapToInt(Integer::valueOf)
                        .boxed()
                        .collect(Collectors.toList()));
            }
        }
        return integers.stream().mapToInt(Integer::valueOf).toArray();
    }
}
