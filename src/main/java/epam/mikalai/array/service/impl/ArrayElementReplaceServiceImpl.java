package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.service.ArrayElementReplaceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayElementReplaceServiceImpl implements ArrayElementReplaceService {
    static Logger logger = LogManager.getLogger();

    @Override
    public void replaceElements(CustomArray customArray, int oldValue, int newValue) throws CustomArrayException {
        int[] arr = customArray.getCustomArray();

        if (arr.length == 0) {
            logger.error("Array is empty");
            throw new CustomArrayException("Array is empty");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldValue) {
                arr[i] = newValue;
            }
        }
        logger.info("Array element replaced. Old element, new element:", oldValue, newValue);
        customArray.setCustomArray(arr);
    }
}
