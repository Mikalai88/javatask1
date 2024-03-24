package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayCalculateSumService;
import epam.mikalai.array.service.ArrayCountPositiveAndNegativeElementsService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCountPositiveAndNegativeElementsServiceImplTest {

    @Test
    public void testFindCountPositive() throws CustomArrayException {
        int[] arr = {1, 3, -2, 5, 9};
        CustomArray customArray = new CustomArray(arr);
        ArrayCountPositiveAndNegativeElementsService service = new ArrayCountPositiveAndNegativeElementsServiceImpl();
        int actual = service.findCountPositive(customArray);
        int expected = 4;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindCountNegative() throws CustomArrayException {
        int[] arr = {1, 3, -2, 5, 9};
        CustomArray customArray = new CustomArray(arr);
        ArrayCountPositiveAndNegativeElementsService service = new ArrayCountPositiveAndNegativeElementsServiceImpl();
        int actual = service.findCountNegative(customArray);
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindCountPositiveException() throws CustomArrayException {
        int[] arr = {};
        CustomArray customArray = new CustomArray(arr);
        ArrayCountPositiveAndNegativeElementsService service = new ArrayCountPositiveAndNegativeElementsServiceImpl();
        service.findCountPositive(customArray);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindCountNegativeException() throws CustomArrayException {
        int[] arr = {};
        CustomArray customArray = new CustomArray(arr);
        ArrayCountPositiveAndNegativeElementsService service = new ArrayCountPositiveAndNegativeElementsServiceImpl();
        service.findCountNegative(customArray);
    }
}