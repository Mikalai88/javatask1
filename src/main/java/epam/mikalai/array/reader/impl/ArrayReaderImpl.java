package epam.mikalai.array.reader.impl;

import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.reader.ArrayReader;
import epam.mikalai.array.validator.StringArrayValidator;
import epam.mikalai.array.validator.impl.StringArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {

    static Logger logger = LogManager.getLogger();
    private static final String DEFAULT_FILENAME = "data\\arrays.txt";
    private static final String SPACE_DELIMITER = "\\s+";
    @Override
    public int[] readArray(String filename) throws CustomArrayException {
        if (filename == null) {
            logger.warn("Filename is null.");
            throw new CustomArrayException("Filename is null.");
        }

        Path path = Path.of(filename);

        if (!Files.exists(path)) {
            logger.warn("File " + filename + " not exist and was replaced.");
            filename = DEFAULT_FILENAME;
            path = Path.of(filename);
        }

        List<Integer> numbers = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(path);
            logger.info("File " + filename + " was read successfully. Number of lines: " + lines.size());
            StringArrayValidator validator = new StringArrayValidatorImpl();

            for (String line : lines) {
                if (validator.stringArrayValidate(line)) {
                    String[] numArr = line.split(SPACE_DELIMITER);
                    for (String numStr : numArr) {
                        numbers.add(Integer.parseInt(numStr));
                    }
                    logger.info("Valid array format found in file " + filename);
                } else {
                    logger.warn("Line is not a valid array format.");
                }
            }
        } catch (IOException e) {
            logger.error("Error reading file " + filename, e);
            throw new CustomArrayException("Error reading file " + filename, e);
        }

        if (numbers.isEmpty()) {
            logger.error("File " + filename + " does not contain any valid array lines.");
            throw new CustomArrayException("File " + filename + " does not contain any valid array lines.");
        }


        int[] result = numbers.stream().mapToInt(i -> i).toArray();
        logger.info("Array successfully created from file " + filename + ". Number of elements: " + result.length);
        return result;
    }
}

// 2-й вариант:
//public List<int[]> readArray(String filename) throws CustomArrayException {
//    if (filename == null) {
//        logger.warn("Filename is null.");
//        throw new CustomArrayException("Filename is null.");
//    }
//
//    Path path = Path.of(filename);
//
//    if (!Files.exists(path)) {
//        logger.warn("File " + filename + " not exist and was replaced.");
//        filename = DEFAULT_FILENAME;
//        path = Path.of(filename);
//    }
//
//    try {
//        List<String> lines = Files.readAllLines(path);
//        logger.info("File " + filename + " was read successfully. Number of lines: " + lines.size());
//
//        StringArrayValidator validator = new StringArrayValidatorImpl();
//
//        List<int[]> arrays = lines.stream()
//                .filter(validator::stringArrayValidate)
//                .map(line -> Arrays.stream(line.split(SPACE_DELIMITER))
//                        .mapToInt(Integer::parseInt)
//                        .toArray())
//                .collect(Collectors.toList());
//
//        if (arrays.isEmpty()) {
//            logger.error("File " + filename + " does not contain any valid array lines.");
//            throw new CustomArrayException("File does not contain any valid array lines.");
//        }
//
//        // Логирование информации о количестве найденных валидных массивов и их размерах
//        logger.info("Successfully created " + arrays.size() + " arrays from file " + filename);
//        for (int i = 0; i < arrays.size(); i++) {
//            logger.info("Array " + (i + 1) + " has " + arrays.get(i).length + " elements.");
//        }
//
//        return arrays;
//    } catch (IOException e) {
//        logger.error("Error reading file " + filename, e);
//        throw new CustomArrayException("Error reading file " + filename, e);
//    }
//}


