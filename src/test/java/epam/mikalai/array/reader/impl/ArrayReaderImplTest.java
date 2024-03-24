package epam.mikalai.array.reader.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayReaderImplTest {
    @Test
    public void testReadArray7() throws Exception {
        String filePath = "src/test/resources/validData.txt";
        ArrayReaderImpl arrayReader = new ArrayReaderImpl();
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = arrayReader.readArray7(filePath);
        Assert.assertEquals(actual, expected, "The array does not match the expected output.");
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadArray7Exception() throws Exception {
        String filePath = "src/test/resources/nonexistentFile.txt";
        ArrayReaderImpl arrayReader = new ArrayReaderImpl();
        arrayReader.readArray7(filePath);
    }
}