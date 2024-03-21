package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;

public interface ArrayMinMaxService {

    int findMax(CustomArray customArray);

    int findMin(CustomArray customArray);
}