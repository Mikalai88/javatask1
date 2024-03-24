package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayCountPositiveAndNegativeElementsService;
import epam.mikalai.array.service.ArrayElementReplaceService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayElementReplaceServiceImplTest {

    @Test
    public void testReplaceElements() throws CustomArrayException {
        int[] arr = {1, 3, -2, 5, 9};
        CustomArray customArray = new CustomArray(arr);
        ArrayElementReplaceService service = new ArrayElementReplaceServiceImpl();
        service.replaceElements(customArray, 1, 15);

        int[] actual = customArray.getCustomArray();
        int[] expected = new int[]{15, 3, -2, 5, 9};
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceElementsException() throws CustomArrayException {
        int[] arr = {};
        CustomArray customArray = new CustomArray(arr);
        ArrayElementReplaceService service = new ArrayElementReplaceServiceImpl();
        service.replaceElements(customArray, 1, 15);
        customArray.getCustomArray();
    }
}