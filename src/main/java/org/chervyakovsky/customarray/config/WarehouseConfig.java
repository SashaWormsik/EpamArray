package org.chervyakovsky.customarray.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.entity.CustomArrayParameter;
import org.chervyakovsky.customarray.entity.Warehouse;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.service.SearchService;
import org.chervyakovsky.customarray.service.impl.customImpl.CalculateServiceCustomImpl;
import org.chervyakovsky.customarray.service.impl.customImpl.SearchServiceCustomImpl;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class WarehouseConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    public static Warehouse configure(List<CustomArray> customArrays) {
        Warehouse warehouse = Warehouse.getInstance();
        CalculateService calculateService = new CalculateServiceCustomImpl();
        SearchService searchService = new SearchServiceCustomImpl();
        for (CustomArray customArray : customArrays) {
            try {
                OptionalInt min = searchService.searchMin(customArray);
                OptionalInt max = searchService.searchMax(customArray);
                OptionalDouble average = calculateService.averageArrayElements(customArray);
                OptionalInt sum = calculateService.sumArrayElements(customArray);
                CustomArrayParameter parameter = new CustomArrayParameter(max, min, average, sum);
                warehouse.put(customArray.getId(), parameter);
            } catch (CustomException exception) {
                LOGGER.error("Parameters of CustomArray " + customArray + "not added", exception);
            }
        }
        LOGGER.info("The warehouse is configured");
        return warehouse;
    }
}
