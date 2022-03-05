package org.chervyakovsky.customarray.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.reader.CustomReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomReaderImpl implements CustomReader {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> readAllFile(String fileName) throws CustomException {
        LOGGER.info("Method to read data from file start");
        checkFile(fileName);
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            while (reader.ready()) {
                arrayList.add(reader.readLine());
            }
        } catch (IOException e) {
            LOGGER.error("The problem with reading the file", e);
            throw new CustomException("The problem with reading the file", e);
        }
        return arrayList;
    }

    private void checkFile(String fileName) throws CustomException {
        LOGGER.info("Checking file");
        if (fileName == null || fileName.trim().isEmpty()) {
            LOGGER.error("FileName is null or empty string");
            throw new CustomException("FileName is null or empty string");
        }
    }
}
