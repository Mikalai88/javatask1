package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;

import java.util.OptionalDouble;

public interface ArrayBasicService {
  double calculateAverage(CustomArray customArray) throws CustomArrayException;
  int calculateSum(CustomArray customArray) throws CustomArrayException;
  int findCountPositive(CustomArray customArray) throws CustomArrayException;
  int findCountNegative(CustomArray customArray) throws CustomArrayException;
  void replaceElements(CustomArray customArray, int oldValue, int newValue) throws CustomArrayException;
  int findMax(CustomArray customArray) throws CustomArrayException;
  int findMin(CustomArray customArray) throws CustomArrayException;
}
