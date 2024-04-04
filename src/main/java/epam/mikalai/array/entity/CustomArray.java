package epam.mikalai.array.entity;

import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.observer.ArrayStatisticsObserver;
import epam.mikalai.array.observer.impl.ArrayStatisticsObserverImpl;
import epam.mikalai.array.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

public class CustomArray {
    static Logger logger = LogManager.getLogger();
    private final int customArrayId = IdGenerator.increment();
    private int[] customArray;
    private ArrayStatisticsObserver observer;

    public CustomArray() {
        this.customArray = new int[0];
    }

    public CustomArray(int... customArray) {
        this.customArray = customArray.clone();
        observer = new ArrayStatisticsObserverImpl();
    }

    public void removeObserver() { observer = null; }
    public void addObserver() { observer = new ArrayStatisticsObserverImpl(); }

    public int[] getCustomArray() {
        return customArray.clone();
    }

    public void setCustomArray(int[] customArray) {

        this.customArray = customArray.clone();
        notifyObserver();
    }

    public int getCustomArrayId() {
        return customArrayId;
    }

    private void notifyObserver()  {
        if (observer != null) {
            observer.changeArrayElement(this);
        }
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
