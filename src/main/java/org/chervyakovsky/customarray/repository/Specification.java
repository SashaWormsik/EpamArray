package org.chervyakovsky.customarray.repository;

import org.chervyakovsky.customarray.entity.CustomArray;

public interface Specification {

    boolean specify(CustomArray customArray);

}
