package org.task.array.entity;

import java.util.Arrays;

public class CustomArray {

    private int[] array;

    public CustomArray() {
    }

    public CustomArray(int... array) {
        this.array = array;
    }

    public int[] getArray() {
        return Arrays.copyOf(this.array, this.array.length);
    }

    public void setArray(int... array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "CustomArray{ array=" + Arrays.toString(array) + "}";
    }
}
