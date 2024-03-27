package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySortServiceImpl implements ArraySortService {
    static Logger logger = LogManager.getLogger();

    @Override
    public void selectionSort(CustomArray customArray) {
        int[] arr = customArray.getCustomArray();

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        logger.info("Array was sorted by selectionSort");
        customArray.setCustomArray(arr);
    }

    @Override
    public void insertionSort(CustomArray customArray) {
        int[] arr = customArray.getCustomArray();

        for (int i = 1;  i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        logger.info("Array was sorted by insertionSort");
        customArray.setCustomArray(arr);
    }

    @Override
    public void bubbleSort(CustomArray customArray) {
        int[] arr = customArray.getCustomArray();

        int n = arr.length;
        boolean isSorted;

        for (int i = 0; i < n - 1; i++) {
            isSorted = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
        logger.info("Array was sorted by bubbleSort");
        customArray.setCustomArray(arr);
    }
}
