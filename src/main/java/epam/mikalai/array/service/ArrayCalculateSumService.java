package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;

public interface ArrayCalculateSumService {
    int calculateSum(CustomArray customArray) throws CustomArrayException;
}
