package org.chervyakovsky.customarray.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chervyakovsky.customarray.exception.CustomException;
import org.chervyakovsky.customarray.reader.CustomerReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerReaderImpl implements CustomerReader {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> fileReader(String fileName) throws CustomException {
        LOGGER.info("Method to read data from file start");
        checkFile(fileName);
        File file = new File(fileName);
        ArrayList<String> arrayList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                arrayList.add(scanner.nextLine());
            }
        } catch (Exception e) {
            LOGGER.error("The problem with reading the file", e);
            throw new CustomException("The problem with reading the file", e);
        }
        return arrayList;
    }

    private void checkFile(String fileName) throws CustomException {
        LOGGER.info("Checking file");
        if (fileName == null || fileName.isEmpty()) {
            LOGGER.error("FileName is null or empty string");
            throw new CustomException("FileName is null or empty string");
        }
        File file = new File(fileName);
        if (!file.exists()) {
            LOGGER.error("The file does not exist");
            throw new CustomException("The file does not exist");
        }
        if (file.length() == 0 || !file.canRead()) {
            LOGGER.error("The file cannot be read or is empty");
            throw new CustomException("The file cannot be read or is empty");
        }
    }
}
