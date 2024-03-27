package epam.mikalai.array.entity;

import epam.mikalai.array.util.IdGenerator;

import java.util.Arrays;
import java.util.Objects;

public class CustomArray {
    private final int customArrayId = IdGenerator.increment();
    private int[] customArray;

    public CustomArray() {
        this.customArray = new int[0];
    }

    public CustomArray(int... customArray) {
        this.customArray = customArray.clone();
    }

    public int[] getCustomArray() {
        return customArray.clone();
    }

    public void setCustomArray(int[] customArray) {
        this.customArray = customArray.clone();
    }

    public int getCustomArrayId() {
        return customArrayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return customArrayId == that.customArrayId && Arrays.equals(customArray, that.customArray);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(customArrayId);
        result = 31 * result + Arrays.hashCode(customArray);
        return result;
    }

    @Override
    public String toString() {
        return "CustomArray{" +
                "customArrayId=" + customArrayId +
                ", customArray=" + Arrays.toString(customArray) +
                '}';
    }
}
