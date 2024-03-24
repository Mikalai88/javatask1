package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;

public interface ArrayCalculateAverageService {
    double calculateAverage(CustomArray customArray) throws CustomArrayException;
}
