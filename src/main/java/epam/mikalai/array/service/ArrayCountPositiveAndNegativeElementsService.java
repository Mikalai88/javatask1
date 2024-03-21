package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;

public interface ArrayCountPositiveAndNegativeElementsService {
    int findCountPositive(CustomArray customArray);

    int findCountNegative(CustomArray customArray);
}
