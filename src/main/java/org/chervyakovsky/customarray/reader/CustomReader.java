package org.chervyakovsky.customarray.reader;

import org.chervyakovsky.customarray.exception.CustomException;

import java.util.List;

public interface CustomReader {

    public List<String> readAllFile(String fileName) throws CustomException;
}
