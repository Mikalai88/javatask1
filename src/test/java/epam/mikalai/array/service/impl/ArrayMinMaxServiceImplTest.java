package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayCalculateAverageService;
import epam.mikalai.array.service.ArrayMinMaxService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayMinMaxServiceImplTest {

    @Test
    public void testFindMax() throws CustomArrayException {
        int[] arr = {1, 3, 2, 5, 9};
        CustomArray customArray = new CustomArray(arr);
        ArrayMinMaxService service = new ArrayMinMaxServiceImpl();
        int actual = service.findMax(customArray);
        int expected = 9;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindMin() throws CustomArrayException {
        int[] arr = {1, 3, 2, 5, 9};
        CustomArray customArray = new CustomArray(arr);
        ArrayMinMaxService service = new ArrayMinMaxServiceImpl();
        int actual = service.findMin(customArray);
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMaxException() throws CustomArrayException {
        int[] arr = {};
        CustomArray customArray = new CustomArray(arr);
        ArrayMinMaxService service = new ArrayMinMaxServiceImpl();
        service.findMax(customArray);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMinException() throws CustomArrayException {
        int[] arr = {};
        CustomArray customArray = new CustomArray(arr);
        ArrayMinMaxService service = new ArrayMinMaxServiceImpl();
        service.findMin(customArray);
    }
}