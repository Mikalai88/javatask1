package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArraySortServiceImplTest {

    private ArraySortServiceImpl arraySortService = new ArraySortServiceImpl();
    private CustomArray testArray;
    private final int[] sortedArray = {1,2,3,4,5};
    @BeforeMethod
    public void setUp() {
        testArray = new CustomArray(new int[]{4,3,5,1,2});
    }

    @Test
    public void testSelectionSort() throws CustomArrayException {
        arraySortService.selectionSort(testArray);
        Assert.assertEquals(testArray.getCustomArray(), sortedArray, "Selection sort failed");
    }

    @Test
    public void testInsertionSort() throws CustomArrayException {
        arraySortService.insertionSort(testArray);
        Assert.assertEquals(testArray.getCustomArray(), sortedArray, "Insertion sort failed");
    }

    @Test
    public void testBubbleSort() throws CustomArrayException {
        arraySortService.bubbleSort(testArray);
        Assert.assertEquals(testArray.getCustomArray(), sortedArray, "Bubble sort failed");
    }
}