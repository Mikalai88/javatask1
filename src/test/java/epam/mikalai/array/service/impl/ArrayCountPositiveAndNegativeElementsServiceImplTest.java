package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.service.ArrayCalculateSumService;
import epam.mikalai.array.service.ArrayCountPositiveAndNegativeElementsService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCountPositiveAndNegativeElementsServiceImplTest {

    @Test
    public void testFindCountPositive() {
        int[] arr = {1, 3, -2, 5, 9};
        CustomArray customArray = new CustomArray(arr);
        ArrayCountPositiveAndNegativeElementsService service = new ArrayCountPositiveAndNegativeElementsServiceImpl();
        int actual = service.findCountPositive(customArray);
        int expected = 4;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindCountNegative() {
        int[] arr = {1, 3, -2, 5, 9};
        CustomArray customArray = new CustomArray(arr);
        ArrayCountPositiveAndNegativeElementsService service = new ArrayCountPositiveAndNegativeElementsServiceImpl();
        int actual = service.findCountNegative(customArray);
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }
}