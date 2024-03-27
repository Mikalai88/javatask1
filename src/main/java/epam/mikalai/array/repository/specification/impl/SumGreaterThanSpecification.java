package epam.mikalai.array.repository.specification.impl;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.service.ArrayBasicService;
import epam.mikalai.array.service.impl.ArrayBasicServiceImpl;
import epam.mikalai.array.repository.specification.ArraySpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumGreaterThanSpecification implements ArraySpecification {
  static Logger logger = LogManager.getLogger();
  private final int sum;

  public SumGreaterThanSpecification(int sum) {
    this.sum = sum;
    logger.debug("SumGreaterThanSpecification created with sum = {}", sum);
  }

  @Override
  public boolean specified(CustomArray customArray) {
    ArrayBasicService service = new ArrayBasicServiceImpl();
    try {
      int arraySum = service.calculateSum(customArray);
      boolean result = arraySum > sum;
      if (result) {
        logger.info("CustomArray ID {} satisfies the condition with sum = {}", customArray.getCustomArrayId(), arraySum);
      } else {
        logger.info("CustomArray ID {} does not satisfy the condition with sum = {}", customArray.getCustomArrayId(), arraySum);
      }
      return result;
    } catch (Exception e) {
      logger.error("An error occurred while calculating sum for CustomArray ID {}: {}", customArray.getCustomArrayId(), e.getMessage());
      return false;
    }
  }
}
