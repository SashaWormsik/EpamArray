package org.chervyakovsky.customarray.comparator;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.util.ComparatorUtil;

import java.util.Comparator;

public enum CustomerArrayComparator implements Comparator<CustomArray> {

    ID {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            int resultComparison = Integer.compare(o1.getId(), o2.getId());
            return resultComparison;
        }
    }, AVERAGE {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            int resultComparison = Double.compare(ComparatorUtil.findAverage(o1), ComparatorUtil.findAverage(o2)); //FIXME имеено про утилитный класс, уместно ли так
            return resultComparison;                                          // FIXME или написать тут статический метод и обратиться CustomerArrayComparator.method
        }
    }, SUM {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            int resultComparison = Double.compare(ComparatorUtil.findSum(o1), ComparatorUtil.findSum(o2)); //FIXME имеено про утилитный класс, уместно ли так
            return resultComparison;
        }
    }, FIRST_ELEMENT {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            int resultComparison = Integer.compare(o1.getArray()[0], o1.getArray()[0]); //FIXME надо ли проверять на null и нулевую длину
            return resultComparison;
        }
    }, COUNT_ELEMENT {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            int resultComparison =Integer.compare(o1.getArray().length, o2.getArray().length);
            return resultComparison;
        }
    };
}
