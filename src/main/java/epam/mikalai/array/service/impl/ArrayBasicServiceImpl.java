package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayBasicService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayBasicServiceImpl implements ArrayBasicService {
  static Logger logger = LogManager.getLogger();

  @Override
  public double calculateAverage(CustomArray customArray) throws CustomArrayException {
    int[] arr = customArray.getCustomArray();
    if (arr.length == 0) {
      logger.error("Array is empty");
      throw new CustomArrayException("Array is empty");
    }
    double sum = 0;
    for (int value : arr) {
      sum += value;
    }
    logger.info("Calculated average: {}", sum / arr.length);
    return sum / arr.length;
  }

  @Override
  public int calculateSum(CustomArray customArray) throws CustomArrayException {
    int[] arr = customArray.getCustomArray();
    if (arr.length == 0) {
      logger.error("Array is empty");
      throw new CustomArrayException("Array is empty");
    }
    int sum = 0;
    for (int value : arr) {
      sum += value;
    }
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

    int positiveCount = 0;
    for (int value : arr) {
      if (value > 0) {
        positiveCount++;
      }
    }
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

    int negativeCount = 0;
    for (int value : arr) {
      if (value < 0) {
        negativeCount++;
      }
    }
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

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == oldValue) {
        arr[i] = newValue;
      }
    }
    logger.info("Array element replaced. Old element, new element:", oldValue, newValue);
    customArray.setCustomArray(arr);
  }

  @Override
  public int findMax(CustomArray customArray) throws CustomArrayException {
    int[] arr = customArray.getCustomArray();

    if (arr.length == 0) {
      logger.error("Array is empty");
      throw new CustomArrayException("Array is empty");
    }

    int max = arr[0];
    for (int value : arr) {
      if (value > max) {
        max = value;
      }
    }
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

    int min = arr[0];
    for (int value : arr) {
      if (value < min) {
        min = value;
      }
    }
    logger.info("Calculated min value: {}", min);
    return min;
  }
}
