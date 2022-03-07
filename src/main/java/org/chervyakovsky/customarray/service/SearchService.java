package org.chervyakovsky.customarray.service;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

import java.util.OptionalInt;

public interface SearchService {

    OptionalInt searchMin(CustomArray customArray) throws CustomException;

    OptionalInt searchMax(CustomArray customArray) throws CustomException;
}
