package epam.mikalai.array.reader;

import epam.mikalai.array.exception.CustomArrayException;

public interface ArrayReader {
    int[] readArray7(String filename) throws CustomArrayException;
//    int[] readArray(String filename, Charset... charset);
}
