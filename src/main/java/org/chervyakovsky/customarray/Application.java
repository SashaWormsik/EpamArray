package org.chervyakovsky.customarray;

import org.chervyakovsky.customarray.exception.CustomException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) {


        Path path = Paths.get("./src/main/resources/data/data.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.ready()) {
                String string = reader.readLine();
                System.out.print(string.length());
                System.out.println(string);

            }
        } catch (IOException e) {
            System.out.println(new CustomException(e));
        }
    }
}
