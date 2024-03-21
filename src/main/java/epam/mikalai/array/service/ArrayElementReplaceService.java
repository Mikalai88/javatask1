package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;

public interface ArrayElementReplaceService {

    void replaceElements(CustomArray customArray, int oldValue, int newValue);
}
