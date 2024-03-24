package epam.mikalai.array.reader.impl;

import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.reader.ArrayReader;
import epam.mikalai.array.validator.StringArrayValidator;
import epam.mikalai.array.validator.impl.StringArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {

    static Logger logger = LogManager.getLogger();
    private static final String DEFAULT_FILENAME = "data\\arrays.txt";
    private static final String SPACE_DELIMITER = "\\s+";
    @Override
    public int[] readArray7(String filename) throws CustomArrayException {
        Path path = Path.of(filename);
        if (!Files.exists(path)) {
            logger.error("File " + filename + " not exist");
            filename = DEFAULT_FILENAME;
        }
        Path path2 = FileSystems.getDefault().getPath(filename);
        int[] result;
        try {
            List<String> lines = Files.readAllLines(path2);
            logger.info("File " + filename + " was read successfully. Number of lines: " + lines.size());
            System.out.println(lines);
            StringArrayValidator validator = new StringArrayValidatorImpl();
            for (int i = 0; i < lines.size(); i++) {
                String strNum = lines.get(i);
                if (validator.stringArrayValidate(strNum)) {
                    String[] numArr = strNum.split(SPACE_DELIMITER);
                    result = new int[numArr.length];
                    for (int j = 0; j < numArr.length; j++) {
                        result[j] = Integer.parseInt(numArr[j]);
                    }
                    logger.info("Array successfully created from file " + filename + ". Number of elements: " + result.length);
                    return result;
                } else {
                    logger.warn("Line " + (i + 1) + " from file " + filename + " is not a valid array format.");
                }
            }
        } catch (IOException e) {
            logger.error("Error reading file " + filename, e);
            throw new CustomArrayException(" msg", e);
        }
        logger.error("File " + filename + " does not contain any valid array lines.");
        throw new CustomArrayException("File " + filename + " does not contain any valid array lines.");
    }

//    @Override
//    public int[] readArray(String filename, Charset... charset) {
//        Path path = Path.of(filename);
//        if (!Files.exists(path)) {
//            System.out.println("file " + filename + " not exist");
//            filename = DEFAULT_FILENAME;// or ArrayException
//        }
//        BufferedReader reader = null;
//        int[] arrTemp = null;
////    if (charset.length == 0) {
////      charset[0] = StandardCharsets.UTF_8;
////    }
//        try {
//            reader = new BufferedReader(new FileReader(filename));
//            String tmp;
//            if ((tmp = reader.readLine()) != null) {
//                System.out.println(tmp);
//                String[] str = tmp.split(SPACE_DELIMITER);
//                System.out.println(Arrays.toString(str));
//                System.out.println(str.length);
//                arrTemp = new int[str.length];
//                int counter = 0;
//                StringArrayValidator validator = new StringArrayValidatorImpl();
//                for (int i = 0; i < str.length; i++) {
//                    if (validator.stringNumberValidate(str[i])) {
//                        arrTemp[counter] = Integer.parseInt(str[i]);
//                        counter++;
//                    }
//                }
//                System.out.println(Arrays.toString(arrTemp));
//                int[] arrRes = Arrays.copyOf(arrTemp, counter);
//                System.out.println(Arrays.toString(arrRes));
//            }
//        } catch (IOException e) {
//            System.err.println(e);
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    //
//                }
//            }
//        }
//        return arrTemp;
//    }

}