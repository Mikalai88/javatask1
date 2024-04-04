package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySortServiceImpl implements ArraySortService {
    static Logger logger = LogManager.getLogger();

    public void sort(CustomArray customArray) {
        int[] arr = customArray.getCustomArray();

        int[] sortedArr = Arrays.stream(arr).sorted().toArray();

        customArray.setCustomArray(sortedArr);

        logger.info("Array was sorted using Stream API.");
    }

    public void sortById(List<CustomArray> customArrayList) {
        Comparator<CustomArray> byId = Comparator.comparing(CustomArray::getCustomArrayId);
        customArrayList.sort(byId);
    }

    public void sortByFirstElement(List<CustomArray> customArrayList) {
        Comparator<CustomArray> byFirstElement = (array1, array2) -> {
            int[] arr1 = array1.getCustomArray();
            int[] arr2 = array2.getCustomArray();

            if (arr1.length == 0 && arr2.length == 0) {
                return 0;
            } else if (arr1.length == 0) {
                return -1;
            } else if (arr2.length == 0) {
                return 1;
            } else {
                return Integer.compare(arr1[0], arr2[0]);
            }
        };
        customArrayList.sort(byFirstElement);
    }

    public void sortByNumberOfElements(List<CustomArray> customArrayList) {
        Comparator<CustomArray> byNumberOfElements = Comparator.comparingInt(a -> a.getCustomArray().length);
        customArrayList.sort(byNumberOfElements);
    }

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

// Есть набор строк Отсортировать строки по длине а те строки которые имеют
