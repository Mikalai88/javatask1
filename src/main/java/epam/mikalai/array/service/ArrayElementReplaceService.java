package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;

public interface ArrayElementReplaceService {
    void replaceElements(CustomArray customArray, int oldValue, int newValue) throws CustomArrayException;
}
