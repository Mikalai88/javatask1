package epam.mikalai.array.observer.impl;

import epam.mikalai.array.entity.ArrayStatistics;
import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.entity.Warehouse;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.observer.ArrayStatisticsObserver;

public class ArrayStatisticsObserverImpl implements ArrayStatisticsObserver {
  @Override
  public void changeArrayElement(CustomArray customArray) {
    ArrayStatistics statistics = null;
    try {
      statistics = new ArrayStatistics(customArray);
    } catch (CustomArrayException e) {
      throw new RuntimeException(e);
    }

    Warehouse warehouse = Warehouse.getInstance();
    int id = customArray.getCustomArrayId();
    warehouse.put(id, statistics);
  }
}
