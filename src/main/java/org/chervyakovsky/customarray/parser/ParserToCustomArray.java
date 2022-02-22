package org.chervyakovsky.customarray.parser;

import org.chervyakovsky.customarray.exception.CustomException;

import java.util.List;

public interface ParserToCustomArray {

    public int[] parse(List<String> dataString) throws CustomException;
}
