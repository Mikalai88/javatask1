package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayBasicService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayBasicServiceImplTest {

  @Test
  public void testCalculateAverage() throws CustomArrayException {
    int[] arr = {1, 3, 2, 5, 9};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    double actual = service.calculateAverage(customArray);
    double expected = 4.0;
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void testCalculateSum() throws CustomArrayException {
    int[] arr = {1, 3, 2, 5, 9};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    int actual = service.calculateSum(customArray);
    int expected = 20;
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void testFindCountPositive() throws CustomArrayException {
    int[] arr = {1, 3, -2, 5, 9};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    int actual = service.findCountPositive(customArray);
    int expected = 4;
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void testFindCountNegative() throws CustomArrayException {
    int[] arr = {1, 3, -2, 5, 9};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    int actual = service.findCountNegative(customArray);
    int expected = 1;
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void testReplaceElements() throws CustomArrayException {
    int[] arr = {1, 3, -2, 5, 9};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    service.replaceElements(customArray, 1, 15);

    int[] actual = customArray.getCustomArray();
    int[] expected = new int[]{15, 3, -2, 5, 9};
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void testFindMax() throws CustomArrayException {
    int[] arr = {1, 3, 2, 5, 9};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    int actual = service.findMax(customArray);
    int expected = 9;
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void testFindMin() throws CustomArrayException {
    int[] arr = {1, 3, 2, 5, 9};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    int actual = service.findMin(customArray);
    int expected = 1;
    Assert.assertEquals(actual, expected);
  }

  @Test(expectedExceptions = CustomArrayException.class)
  public void testCalculateAverageException() throws CustomArrayException {
    int[] arr = {};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    service.calculateAverage(customArray);
  }

  @Test(expectedExceptions = CustomArrayException.class)
  public void testCalculateSumException() throws CustomArrayException {
    int[] arr = {};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    service.calculateSum(customArray);
  }

  @Test(expectedExceptions = CustomArrayException.class)
  public void testFindCountPositiveException() throws CustomArrayException {
    int[] arr = {};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    service.findCountPositive(customArray);
  }

  @Test(expectedExceptions = CustomArrayException.class)
  public void testFindCountNegativeException() throws CustomArrayException {
    int[] arr = {};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    service.findCountNegative(customArray);
  }

  @Test(expectedExceptions = CustomArrayException.class)
  public void testReplaceElementsException() throws CustomArrayException {
    int[] arr = {};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    service.replaceElements(customArray, 1, 15);
    customArray.getCustomArray();
  }

  @Test(expectedExceptions = CustomArrayException.class)
  public void testFindMaxException() throws CustomArrayException {
    int[] arr = {};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    service.findMax(customArray);
  }

  @Test(expectedExceptions = CustomArrayException.class)
  public void testFindMinException() throws CustomArrayException {
    int[] arr = {};
    CustomArray customArray = new CustomArray(arr);
    ArrayBasicService service = new ArrayBasicServiceImpl();
    service.findMin(customArray);
  }

}