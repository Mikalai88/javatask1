package epam.mikalai.array.creator;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;

public class CustomArrayFactory {
    public static CustomArray createCustomArray(int[] array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array is empty.");
        }

        CustomArray customArray = new CustomArray(array);
        return customArray;
    }
}
