package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayCalculateAverageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCalculateAverageServiceImpl implements ArrayCalculateAverageService {

    static Logger logger = LogManager.getLogger();

    @Override
    public double calculateAverage(CustomArray customArray) throws CustomArrayException {
        int[] arr = customArray.getCustomArray();
        if (arr.length == 0) {
            logger.error("Array is empty");
            throw new CustomArrayException("Array is empty");
        }
        double sum = 0;
        for (int value : arr) {
            sum += value;
        }
        logger.info("Calculated average: {}", sum / arr.length);
        return sum / arr.length;
    }
}
