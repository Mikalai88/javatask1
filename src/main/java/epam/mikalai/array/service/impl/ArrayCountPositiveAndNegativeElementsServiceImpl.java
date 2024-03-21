package epam.mikalai.array.service.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.service.ArrayCountPositiveAndNegativeElementsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCountPositiveAndNegativeElementsServiceImpl implements ArrayCountPositiveAndNegativeElementsService {
    static Logger logger = LogManager.getLogger();

    @Override
    public int findCountPositive(CustomArray customArray) {
        int[] arr = customArray.getCustomArray();
        int positiveCount = 0;
        for (int value : arr) {
            if (value > 0) {
                positiveCount++;
            }
        }
        logger.info("Calculated positive: {}", positiveCount);
        return positiveCount;
    }

    @Override
    public int findCountNegative(CustomArray customArray) {
        int[] arr = customArray.getCustomArray();
        int negativeCount = 0;
        for (int value : arr) {
            if (value < 0) {
                negativeCount++;
            }
        }
        logger.info("Calculated negative: {}", negativeCount);
        return negativeCount;
    }

}
