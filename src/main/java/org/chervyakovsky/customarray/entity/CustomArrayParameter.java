package org.chervyakovsky.customarray.entity;

public class CustomArrayParameter {

    private int max;
    private int min;
    private double average;
    private int sum;

    public CustomArrayParameter() {
    }

    public CustomArrayParameter(int max, int min, double average, int sum) {

        this.max = max;
        this.min = min;
        this.average = average;
        this.sum = sum;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArrayParameter that = (CustomArrayParameter) o;
        return max == that.max &&
                min == that.min &&
                average == that.average &&
                sum == that.sum;
    }

    @Override
    public int hashCode() {
        int resultHash = Double.hashCode(this.average) * Integer.hashCode(sum);
        resultHash += Integer.hashCode(min) * Integer.hashCode(max);
        return resultHash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parameters {max=").append(max).
                append(", min=").append(min).
                append(", average=").append(average).
                append(", sum=").append(sum).
                append('}');
        return stringBuilder.toString();
    }
}
