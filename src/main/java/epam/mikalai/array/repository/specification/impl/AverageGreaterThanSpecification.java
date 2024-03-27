package epam.mikalai.array.repository.specification.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.service.ArrayBasicService;
import epam.mikalai.array.service.impl.ArrayBasicServiceImpl;
import epam.mikalai.array.repository.specification.ArraySpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AverageGreaterThanSpecification implements ArraySpecification {
  static Logger logger = LogManager.getLogger();
  private final double average;

  public AverageGreaterThanSpecification(int average) {
    this.average = average;
    logger.debug("AverageGreaterThanSpecification created with average = {}", average);
  }

  @Override
  public boolean specified(CustomArray customArray) {
    ArrayBasicService service = new ArrayBasicServiceImpl();
    try {
      double arrayAverage = service.calculateAverage(customArray);
      boolean result = arrayAverage > average;
      if (result) {
        logger.info("CustomArray ID {} satisfies the condition with average = {}", customArray.getCustomArrayId(), arrayAverage);
      } else {
        logger.info("CustomArray ID {} does not satisfy the condition with average = {}", customArray.getCustomArrayId(), arrayAverage);
      }
      return result;
    } catch (Exception e) {
      logger.error("An error occurred while calculating average for CustomArray ID {}: {}", customArray.getCustomArrayId(), e.getMessage());
      return false;
    }
  }
}
