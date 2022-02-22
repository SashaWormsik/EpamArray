package org.chervyakovsky.customarray;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.creator.impl.CreatorCustomerArrayImpl;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.parser.impl.ParserToCustomArrayImpl;
import org.chervyakovsky.customarray.reader.impl.CustomerReaderImpl;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.service.ReplaceService;
import org.chervyakovsky.customarray.service.SortingService;
import org.chervyakovsky.customarray.service.impl.customImpl.CalculateServiceCustomImpl;
import org.chervyakovsky.customarray.service.impl.customImpl.ReplaceServiceCustomImpl;
import org.chervyakovsky.customarray.service.impl.customImpl.SortingServiceCustomImpl;

import java.util.List;


public class application {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PATH = "./src/main/resources/data/data.txt";

    public static void main(String[] args) {

        CustomerReaderImpl customerReaderImpl = new CustomerReaderImpl();
        ParserToCustomArrayImpl parserToCustomArrayImpl = new ParserToCustomArrayImpl();
        CreatorCustomerArrayImpl creatorCustomerArrayImpl = new CreatorCustomerArrayImpl();

        try {
            List<String> stringsFromFile = customerReaderImpl.fileReader(PATH);
            int[] parsedArray = parserToCustomArrayImpl.parse(stringsFromFile);
            CustomArray customArray = creatorCustomerArrayImpl.createArray(parsedArray);
            //CustomArray customArray = creatorCustomerArrayImpl.createArray(parserToCustomArrayImpl.parse(customerReaderImpl.fileReader(PATH)));
            System.out.println(customArray);

            CalculateService calculateService = new CalculateServiceCustomImpl();
            SortingService sortingService = new SortingServiceCustomImpl();
            ReplaceService replaceService = new ReplaceServiceCustomImpl();

            replaceService.replaceNegativeValue(customArray, 0);
            System.out.println(customArray);
            calculateService.averageArrayElements(customArray);
            calculateService.sumArrayElements(customArray);
            calculateService.determineAmountNegDigit(customArray);
            sortingService.bubbleSort(customArray);
            System.out.println(customArray);

        } catch (CustomException e) {
            LOGGER.info(e);
        }

    }
}
