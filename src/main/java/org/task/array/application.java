package org.task.array;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.task.array.creator.CreatorCustomerArray;
import org.task.array.entity.CustomArray;
import org.task.array.exception.CustomException;
import org.task.array.parser.ParserToIntArray;
import org.task.array.reader.CustomerReader;
import org.task.array.service.CalculateService;
import org.task.array.service.ReplaceService;
import org.task.array.service.SortingService;
import org.task.array.service.impl.customImpl.CalculateCustom;
import org.task.array.service.impl.customImpl.ReplaceCustom;
import org.task.array.service.impl.customImpl.SortingCustom;


public class application {

    private static final String PATH = "./src/main/resources/data/data.txt";

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        CustomerReader customerReader = new CustomerReader();
        ParserToIntArray parserToIntArray = new ParserToIntArray();
        CreatorCustomerArray creatorCustomerArray =new CreatorCustomerArray();

        try {
            CustomArray customArray = creatorCustomerArray.createArray(parserToIntArray.parsing(customerReader.fileReader(PATH)));
            System.out.println(customArray);

            CalculateService calculateService = new CalculateCustom();
            SortingService sortingService= new SortingCustom();
            ReplaceService replaceService = new ReplaceCustom();

            replaceService.replaceNegativeValue(customArray, 0);
            System.out.println(customArray);
            calculateService.averageArrayElements(customArray);
            calculateService.sumArrayElements(customArray);
            calculateService.determineAmountNegDigit(customArray);
            sortingService.bubbleSort(customArray);
            System.out.println(customArray);

        } catch (CustomException e) {
            logger.info(e);
        }


    }
}
