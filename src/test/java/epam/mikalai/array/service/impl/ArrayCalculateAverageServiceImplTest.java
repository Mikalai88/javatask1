package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayCalculateAverageService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static org.testng.Assert.*;

public class ArrayCalculateAverageServiceImplTest {
    @Test
    public void testCalculateAverage() throws CustomArrayException {
        int[] arr = {1, 3, 2, 5, 9};
        CustomArray customArray = new CustomArray(arr);
        ArrayCalculateAverageService service = new ArrayCalculateAverageServiceImpl();
        double actual = service.calculateAverage(customArray);
        double expected = 4.0;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testCalculateAverageException() throws CustomArrayException {
        int[] arr = {};
        CustomArray customArray = new CustomArray(arr);
        ArrayCalculateAverageService service = new ArrayCalculateAverageServiceImpl();
        service.calculateAverage(customArray);
    }
}