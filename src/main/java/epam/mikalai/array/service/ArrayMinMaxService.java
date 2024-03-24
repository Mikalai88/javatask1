package epam.mikalai.array.service;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;

public interface ArrayMinMaxService {

    int findMax(CustomArray customArray) throws CustomArrayException;

    int findMin(CustomArray customArray) throws CustomArrayException;
}