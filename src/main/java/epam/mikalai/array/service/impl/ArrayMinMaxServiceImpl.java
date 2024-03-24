package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayMinMaxService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayMinMaxServiceImpl implements ArrayMinMaxService {
    static Logger logger = LogManager.getLogger();

    @Override
    public int findMax(CustomArray customArray) throws CustomArrayException {
        int[] arr = customArray.getCustomArray();

        if (arr.length == 0) {
            logger.error("Array is empty");
            throw new CustomArrayException("Array is empty");
        }

        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        logger.info("Calculated max value: {}", max);
        return max;
    }

    @Override
    public int findMin(CustomArray customArray) throws CustomArrayException {
        int[] arr = customArray.getCustomArray();

        if (arr.length == 0) {
            logger.error("Array is empty");
            throw new CustomArrayException("Array is empty");
        }

        int min = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        logger.info("Calculated min value: {}", min);
        return min;
    }
}
