package epam.mikalai.array.entity;

import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayBasicService;
import epam.mikalai.array.service.impl.ArrayBasicServiceImpl;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayStatistics {
  private int sum;
  private OptionalInt max;
  private OptionalInt min;
  private OptionalDouble average;

  public ArrayStatistics(CustomArray customArray) throws CustomArrayException {
    calculateStatistics(customArray.getCustomArray());
  }

  private void calculateStatistics(int[] customArray) throws CustomArrayException {
    if (customArray.length == 0 || customArray == null) {
      throw new CustomArrayException("Array null.");
    }

    sum = Arrays.stream(customArray).sum();
    max = Arrays.stream(customArray).max();
    min = Arrays.stream(customArray).min();
    average = Arrays.stream(customArray).average();
  }

}
