package epam.mikalai.array.observer;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.exception.CustomArrayException;

public interface ArrayStatisticsObserver {
  void changeArrayElement(CustomArray customArray);
}
