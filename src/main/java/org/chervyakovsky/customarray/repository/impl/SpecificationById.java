package org.chervyakovsky.customarray.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.repository.Specification;

public class SpecificationById implements Specification {

    private static final Logger LOGGER = LogManager.getLogger();
    private final int id;

    public SpecificationById(int id) {
        this.id = id;
    }


    @Override
    public boolean specify(CustomArray customArray) {
        return customArray != null && this.id == customArray.getId();
    }
}
