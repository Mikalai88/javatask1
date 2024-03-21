package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.service.ArrayCalculateAverageService;
import epam.mikalai.array.service.ArrayMinMaxService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayMinMaxServiceImplTest {

    @Test
    public void testFindMax() {
        int[] arr = {1, 3, 2, 5, 9};
        CustomArray customArray = new CustomArray(arr);
        ArrayMinMaxService service = new ArrayMinMaxServiceImpl();
        int actual = service.findMax(customArray);
        int expected = 9;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindMin() {
        int[] arr = {1, 3, 2, 5, 9};
        CustomArray customArray = new CustomArray(arr);
        ArrayMinMaxService service = new ArrayMinMaxServiceImpl();
        int actual = service.findMin(customArray);
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }
}