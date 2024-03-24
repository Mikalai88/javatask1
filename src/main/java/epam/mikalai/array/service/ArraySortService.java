package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;

public interface ArraySortService {
    void selectionSort(CustomArray customArray) throws CustomArrayException;

    void insertionSort(CustomArray customArray) throws CustomArrayException;

    void bubbleSort(CustomArray customArray) throws CustomArrayException;
}
