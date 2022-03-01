package org.chervyakovsky.customarray.entity;

import java.util.Arrays;

public class CustomArray {

    private int[] array;

    public CustomArray() {
        this.array = new int[0];
    }

    public CustomArray(int... array) {
        this.array = (array == null ? null : Arrays.copyOf(array, array.length));
    }

    public int[] getArray() {
        return this.array == null ? null : Arrays.copyOf(this.array, this.array.length);
    }

    public void setArray(int... array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        CustomArray customArray = (CustomArray) o;
        if (customArray.array == null || this.array == null) {
            return this.array == null && customArray.array == null;
        }
        if (customArray.array.length != this.array.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != customArray.array[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getSimpleName());
        stringBuilder.append(" {array =").append(Arrays.toString(this.array)).append("}");
        return stringBuilder.toString();
    }
}
