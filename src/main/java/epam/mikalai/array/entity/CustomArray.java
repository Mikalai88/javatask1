package epam.mikalai.array.entity;

import java.util.Arrays;

public class CustomArray {
    private int[] customArray;

    public CustomArray() {
        this.customArray = new int[0];
    }

    public CustomArray(int... customArray) {
        this.customArray = Arrays.copyOf(customArray, customArray.length);
    }

    public int[] getCustomArray() {
        return Arrays.copyOf(customArray, customArray.length);
    }

    public void setCustomArray(int[] customArray) {
        this.customArray = customArray;
    }
}
