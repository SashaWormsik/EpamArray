package org.chervyakovsky.customarray.comparator;

import org.chervyakovsky.customarray.entity.CustomArray;
import org.chervyakovsky.customarray.util.ComparatorUtils;

import java.util.Comparator;

public enum CustomArrayComparator implements Comparator<CustomArray> {

    ID {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }
    }, AVERAGE {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return Double.compare(ComparatorUtils.findAverage(o1), ComparatorUtils.findAverage(o2));
        }
    }, SUM {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return Double.compare(ComparatorUtils.findSum(o1), ComparatorUtils.findSum(o2));
        }
    }, FIRST_ELEMENT {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            Comparator<int[]> comparator = Comparator.comparingInt(x -> x.length != 0 ? x[0] : x.length);
            return Comparator.nullsLast(comparator).compare(o1.getArray(), o2.getArray()); // FIXME норм так?? если вдруг у нас array = null
        }
    }, COUNT_ELEMENT {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            Comparator<int[]> comparator = Comparator.comparingInt(x -> x.length);
            return Comparator.nullsLast(comparator).compare(o1.getArray(), o2.getArray()); // FIXME норм так?? если вдруг у нас array = null
        }
    }
}
