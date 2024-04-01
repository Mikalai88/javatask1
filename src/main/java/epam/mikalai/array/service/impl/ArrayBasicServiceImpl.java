package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayBasicService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;

public class ArrayBasicServiceImpl implements ArrayBasicService {
  static Logger logger = LogManager.getLogger();

  @Override
  public double calculateAverage(CustomArray customArray) throws CustomArrayException {
    int[] arr = customArray.getCustomArray();
    if (arr.length == 0) {
      logger.error("Array is empty");
      throw new CustomArrayException("Array is empty");
    }
    double average = Arrays.stream(arr).average().orElseThrow(() -> new CustomArrayException("Cannot calculate average for an empty array"));
    logger.info("Calculated average: {}", average);
    return average;
  }

  @Override
  public int calculateSum(CustomArray customArray) throws CustomArrayException {
    int[] arr = customArray.getCustomArray();
    if (arr.length == 0) {
      logger.error("Array is empty");
      throw new CustomArrayException("Array is empty");
    }
    int sum = Arrays.stream(arr).sum();
    logger.info("Calculated sum: {}", sum);
    return sum;
  }

  @Override
  public int findCountPositive(CustomArray customArray) throws CustomArrayException {
    int[] arr = customArray.getCustomArray();
    if (arr.length == 0) {
      logger.error("Array is empty");
      throw new CustomArrayException("Array is empty");
    }
    int positiveCount = (int) Arrays.stream(arr).filter(value -> value > 0).count();
    logger.info("Calculated positive: {}", positiveCount);
    return positiveCount;
  }

  @Override
  public int findCountNegative(CustomArray customArray) throws CustomArrayException {
    int[] arr = customArray.getCustomArray();
    if (arr.length == 0) {
      logger.error("Array is empty");
      throw new CustomArrayException("Array is empty");
    }
    int negativeCount = (int) Arrays.stream(arr).filter(value -> value < 0).count();
    logger.info("Calculated negative: {}", negativeCount);
    return negativeCount;
  }

  @Override
  public void replaceElements(CustomArray customArray, int oldValue, int newValue) throws CustomArrayException {
    int[] arr = customArray.getCustomArray();
    if (arr.length == 0) {
      logger.error("Array is empty");
      throw new CustomArrayException("Array is empty");
    }
    arr = Arrays.stream(arr).map(value -> value == oldValue ? newValue : value).toArray();
    logger.info("Array elements replaced. Old value: {}, New value: {}", oldValue, newValue);
    customArray.setCustomArray(arr);
  }

  @Override
  public int findMax(CustomArray customArray) throws CustomArrayException {
    int[] arr = customArray.getCustomArray();
    if (arr.length == 0) {
      logger.error("Array is empty");
      throw new CustomArrayException("Array is empty");
    }
    int max = Arrays.stream(arr).max().orElseThrow(() -> new CustomArrayException("Cannot find max in an empty array"));
    logger.info("Calculated max value: {}", max);
    return max;
  }

  @Override
  public int findMin(CustomArray customArray) throws CustomArrayException {
    int[] arr = customArray.getCustomArray();
    if (arr.length == 0) {
      logger.error("Array is empty");
      throw new CustomArrayException("Array is empty");
    }
    int min = Arrays.stream(arr).min().orElseThrow(() -> new CustomArrayException("Cannot find min in an empty array"));
    logger.info("Calculated min value: {}", min);
    return min;
  }
}
