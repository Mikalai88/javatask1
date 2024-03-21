package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.service.ArrayCalculateSumService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCalculateSumServiceImpl implements ArrayCalculateSumService {
    static Logger logger = LogManager.getLogger();

    @Override
    public int calculateSum(CustomArray customArray) {
        int[] arr = customArray.getCustomArray();
        if (arr.length == 0) {
            logger.error("Array is empty");
            throw new IllegalArgumentException("Array is empty");
        }
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        logger.info("Calculated sum: {}", sum);
        return sum;
    }
}
