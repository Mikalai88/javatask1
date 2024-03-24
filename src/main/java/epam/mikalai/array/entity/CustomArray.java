package epam.mikalai.array.entity;

import epam.mikalai.array.util.IdGenerator;

import java.util.Arrays;

public class CustomArray {
    private final int customArrayId;
    private int[] customArray;

    public CustomArray() {
        this.customArray = new int[0];
        this.customArrayId = IdGenerator.increment();
    }

    public CustomArray(int... customArray) {
        this.customArray = Arrays.copyOf(customArray, customArray.length);
        this.customArrayId = IdGenerator.increment();
    }

    public int[] getCustomArray() {
        return Arrays.copyOf(customArray, customArray.length);
    }

    public void setCustomArray(int[] customArray) {
        this.customArray = customArray;
    }

    public int getCustomArrayId() {
        return customArrayId;
    }
}
