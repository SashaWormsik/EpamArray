package org.chervyakovsky.customarray.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.creator.CustomerArrayFactory;
import org.chervyakovsky.customarray.creator.impl.CustomerArrayFactoryImpl;
import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.parser.ParserToIntArray;
import org.chervyakovsky.customarray.parser.impl.ParserToIntArrayImpl;
import org.chervyakovsky.customarray.reader.CustomReader;
import org.chervyakovsky.customarray.reader.impl.CustomReaderImpl;
import org.chervyakovsky.customarray.repository.Repository;
import org.chervyakovsky.customarray.repository.impl.RepositoryImpl;

import java.util.List;

public class RepositoryConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    public static Repository configure(String fileName) {
        Repository repository = RepositoryImpl.getInstance();
        CustomReader customReader = new CustomReaderImpl();
        ParserToIntArray parser = new ParserToIntArrayImpl();
        CustomerArrayFactory factory = new CustomerArrayFactoryImpl();
        try {
            List<String> strings = customReader.readAllFile(fileName);
            List<int[]> intList = parser.parseAll(strings);
            List<CustomArray> customArrayList = factory.createCustomArray(intList);
            repository.addAll(customArrayList);
        } catch (CustomException exception) {
            LOGGER.error("The repository is not configured, exception.", exception);
        }
        LOGGER.info("The repository is configured");
        return repository;
    }
}
