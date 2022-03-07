package org.chervyakovsky.customarray.creator.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.creator.CustomArrayFactory;
import org.chervyakovsky.customarray.entity.CustomArray;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayFactoryImpl implements CustomArrayFactory {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public CustomArray createCustomArray() {
        LOGGER.info("Method to create CustomArray start");
        return new CustomArray();
    }

    @Override
    public CustomArray createCustomArray(int... array) {
        LOGGER.info("Method to create CustomArray start");
        return array == null ? createCustomArray() : new CustomArray(array);
    }

    @Override
    public List<CustomArray> createCustomArray(List<int[]> arrays) {
        LOGGER.info("Method to create CustomArray start");
        List<CustomArray> customArrayList = new ArrayList<>();
        if (arrays == null || arrays.isEmpty()) {
            return customArrayList;
        }
        for (int[] element : arrays) {
            customArrayList.add(new CustomArray(element));
        }
        return customArrayList;
    }
}
