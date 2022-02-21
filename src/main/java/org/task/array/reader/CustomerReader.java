package org.task.array.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.task.array.exception.CustomException;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerReader {

    Logger logger = LogManager.getLogger();

    public List<String> fileReader(String fileName) throws CustomException {
        logger.info("Method to read data from file start");
        File file = new File(fileName);
        ArrayList<String> arrayList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                arrayList.add(scanner.nextLine());
            }
        } catch (Exception e) {
            throw new CustomException("File not found", e);
        }
        return arrayList;
    }
}
