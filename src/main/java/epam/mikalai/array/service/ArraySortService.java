package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;

public interface ArraySortService {
    void selectionSort(CustomArray customArray);

    void insertionSort(CustomArray customArray);

    void bubbleSort(CustomArray customArray);
}
