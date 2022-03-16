package org.chervyakovsky.customarray.entity;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayParameter {

    private OptionalInt max;
    private OptionalInt min;
    private OptionalDouble average;
    private OptionalInt sum;

    public CustomArrayParameter() {
    }

    public CustomArrayParameter(OptionalInt max, OptionalInt min, OptionalDouble average, OptionalInt sum) {

        this.max = max;
        this.min = min;
        this.average = average;
        this.sum = sum;
    }

    public OptionalInt getMax() {
        return max;
    }

    public void setMax(OptionalInt max) {
        this.max = max;
    }

    public OptionalInt getMin() {
        return min;
    }

    public void setMin(OptionalInt min) {
        this.min = min;
    }

    public OptionalDouble getAverage() {
        return average;
    }

    public void setAverage(OptionalDouble average) {
        this.average = average;
    }

    public OptionalInt getSum() {
        return sum;
    }

    public void setSum(OptionalInt sum) {
        this.sum = sum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        CustomArrayParameter that = (CustomArrayParameter) o;
        return max.equals(that.max) &&
                min.equals(that.min) &&
                average.equals(that.average) &&
                sum.equals(that.sum);
    }

    @Override
    public int hashCode() {
        return min.hashCode() + max.hashCode() + average.hashCode() + sum.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parameters {max=").append(max.isPresent() ? max.getAsInt() : "empty").
                append(", min=").append(min.isPresent() ? min.getAsInt() : "empty").
                append(", average=").append(average.isPresent() ? average.getAsDouble() : "empty").
                append(", sum=").append(sum.isPresent() ? sum.getAsInt() : "empty").
                append('}');
        return stringBuilder.toString();
    }
}
