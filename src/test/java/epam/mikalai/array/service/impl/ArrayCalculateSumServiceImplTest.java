package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayCalculateAverageService;
import epam.mikalai.array.service.ArrayCalculateSumService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCalculateSumServiceImplTest {

    @Test
    public void testCalculateSum() throws CustomArrayException {
        int[] arr = {1, 3, 2, 5, 9};
        CustomArray customArray = new CustomArray(arr);
        ArrayCalculateSumService service = new ArrayCalculateSumServiceImpl();
        int actual = service.calculateSum(customArray);
        int expected = 20;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testCalculateSumException() throws CustomArrayException {
        int[] arr = {};
        CustomArray customArray = new CustomArray(arr);
        ArrayCalculateSumService service = new ArrayCalculateSumServiceImpl();
        service.calculateSum(customArray);
    }
}