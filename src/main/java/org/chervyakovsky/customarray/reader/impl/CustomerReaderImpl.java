package org.chervyakovsky.customarray.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.reader.CustomerReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerReaderImpl implements CustomerReader {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> readAllFile(String fileName) throws CustomException {
        LOGGER.info("Method to read data from file start");
        checkFile(fileName);
        ArrayList<String> arrayList = new ArrayList<>();
        String currentString;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {//FIXME
            while ((currentString = bufferedReader.readLine()) != null) {
                arrayList.add(currentString);
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
        File file = new File(fileName);
        if (!file.exists()) {
            LOGGER.error("The file does not exist");
            throw new CustomException("The file " + fileName + " does not exist");
        }
        if (!file.canRead()) {
            LOGGER.error("The file cannot be read or is empty");
            throw new CustomException("The file " + fileName + " cannot be read or is empty");
        }
    }
}
