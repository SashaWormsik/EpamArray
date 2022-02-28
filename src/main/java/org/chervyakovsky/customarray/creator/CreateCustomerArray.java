package org.chervyakovsky.customarray.creator;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

import java.util.List;

public interface CreateCustomerArray {

    CustomArray createCustomArray();

    CustomArray createCustomArray(int... array) throws CustomException;

    List<CustomArray> createCustomArray(List<int[]> arrays);
}
