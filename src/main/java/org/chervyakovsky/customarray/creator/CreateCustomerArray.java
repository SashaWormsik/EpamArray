package org.chervyakovsky.customarray.creator;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.exception.CustomException;

public interface CreateCustomerArray {

    public CustomArray createArray(int... array) throws CustomException;
}
