package epam.mikalai.array.reader;

import epam.mikalai.array.exception.CustomArrayException;

public interface ArrayReader {
    int[] readArray(String filename) throws CustomArrayException;
}
