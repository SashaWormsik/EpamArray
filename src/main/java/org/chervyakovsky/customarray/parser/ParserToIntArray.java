package org.chervyakovsky.customarray.parser;

import org.chervyakovsky.customarray.exception.CustomException;

import java.util.List;

public interface ParserToIntArray {

    List<int[]> parseAll(List<String> dataString) throws CustomException;

    int[] parseFirst(List<String> dataString) throws CustomException;
}
