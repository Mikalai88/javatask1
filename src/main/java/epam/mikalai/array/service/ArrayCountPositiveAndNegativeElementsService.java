package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;

public interface ArrayCountPositiveAndNegativeElementsService {
    int findCountPositive(CustomArray customArray) throws CustomArrayException;

    int findCountNegative(CustomArray customArray) throws CustomArrayException;
}
