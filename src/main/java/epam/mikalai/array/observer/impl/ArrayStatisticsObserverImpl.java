package epam.mikalai.array.observer.impl;

import epam.mikalai.array.entity.ArrayStatistics;
import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.entity.Warehouse;
import epam.mikalai.array.exception.CustomArrayException;
import epam.mikalai.array.observer.ArrayStatisticsObserver;

public class ArrayStatisticsObserverImpl implements ArrayStatisticsObserver {
  @Override
  public void changeArrayElement(CustomArray customArray) throws CustomArrayException {
    ArrayStatistics statistics = new ArrayStatistics(customArray);

    Warehouse warehouse = Warehouse.getInstance();
    warehouse.put(customArray.getCustomArrayId(), statistics);
  }
}
