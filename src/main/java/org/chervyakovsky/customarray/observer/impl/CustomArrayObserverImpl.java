package org.chervyakovsky.customarray.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.entity.CustomArrayParameter;
import org.chervyakovsky.customarray.entity.Warehouse;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.observer.CustomArrayEvent;
import org.chervyakovsky.customarray.observer.CustomArrayObserver;
import org.chervyakovsky.customarray.service.CalculateService;
import org.chervyakovsky.customarray.service.SearchService;
import org.chervyakovsky.customarray.service.impl.customImpl.CalculateServiceCustomImpl;
import org.chervyakovsky.customarray.service.impl.customImpl.SearchServiceCustomImpl;

public class CustomArrayObserverImpl implements CustomArrayObserver {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void updateCustomArrayParameter(CustomArrayEvent event) {
        CalculateService calculateService = new CalculateServiceCustomImpl();
        SearchService searchService = new SearchServiceCustomImpl();
        CustomArray customArray = event.getSource();
        try {
            int min = searchService.searchMin(customArray);
            int max = searchService.searchMax(customArray);
            double average = calculateService.averageArrayElements(customArray);
            int sum = calculateService.sumArrayElements(customArray);
            CustomArrayParameter parameter = new CustomArrayParameter(max, min, average, sum);
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.put(customArray.getId(), parameter);
            LOGGER.info("CustomArray " + customArray + " parameters updated. Parameters" + parameter);
        } catch (CustomException customerException) {
            LOGGER.error("Parameters not updated in " + customArray, customerException);
        }
    }
}
