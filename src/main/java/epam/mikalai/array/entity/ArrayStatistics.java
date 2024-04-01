package epam.mikalai.array.entity;

import epam.mikalai.array.service.ArrayBasicService;
import epam.mikalai.array.service.impl.ArrayBasicServiceImpl;

import java.util.Arrays;

public class ArrayStatistics {
  private int sum;
  private int max;
  private int min;
  private double average;

  public ArrayStatistics(CustomArray customArray) {
    calculateStatistics(customArray.getCustomArray());
  }

  private void calculateStatistics(int[] customArray) {
    if (customArray.length == 0) {
      sum = 0;
      max = Integer.MIN_VALUE;
      min = Integer.MAX_VALUE;
      average = 0;
      return;
    }

    sum = Arrays.stream(customArray).sum();
    max = Arrays.stream(customArray).max().orElse(Integer.MIN_VALUE);
    min = Arrays.stream(customArray).min().orElse(Integer.MAX_VALUE);
    average = Arrays.stream(customArray).average().orElse(0);
  }

}
