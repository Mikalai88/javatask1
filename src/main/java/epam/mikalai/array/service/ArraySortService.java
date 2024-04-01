package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;

import java.util.List;

public interface ArraySortService {
    void sort(CustomArray customArray);
    void sortById(List<CustomArray> customArrayList);
    void sortByFirstElement(List<CustomArray> customArrayList);
    void sortByNumberOfElements(List<CustomArray> customArrayList);

//    void selectionSort(CustomArray customArray);
//
//    void insertionSort(CustomArray customArray);
//
//    void bubbleSort(CustomArray customArray);
}
