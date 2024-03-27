package epam.mikalai.array.repository;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.repository.specification.ArraySpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomArrayRepository {
  private List<CustomArray> arrays = new ArrayList<>();
  private static CustomArrayRepository instance;

  private CustomArrayRepository() {}

  // Singleton
  public static CustomArrayRepository getInstance() {
    if (instance == null) {
      instance = new CustomArrayRepository();
    }
    return instance;
  }

  public boolean add(CustomArray customArray) {
    return arrays.add(customArray);
  }

  public boolean remove(CustomArray o) {
    return arrays.remove(o);
  }

  public CustomArray get(int index) {
    CustomArray original = arrays.get(index);
    return new CustomArray(original.getCustomArray());
  }

  public CustomArray set(int index, CustomArray element) {
    return arrays.set(index, new CustomArray(element.getCustomArray()));
  }

  public void add(int index, CustomArray element) {
    arrays.add(index, new CustomArray(element.getCustomArray()));
  }

  public CustomArray remove(int index) {
    return arrays.remove(index);
  }

  public List<CustomArray> query(ArraySpecification specification) {
    List<CustomArray> result = new ArrayList<>();
    for (CustomArray array : arrays) {
      if (specification.specified(array)) {
        result.add(new CustomArray(array.getCustomArray()));
      }
    }
    return result;
  }

  public List<CustomArray> getCustomArrays() {
    List<CustomArray> copyList = new ArrayList<>();
    for (CustomArray array : this.arrays) {
      copyList.add(new CustomArray(array.getCustomArray()));
    }
    return copyList;
  }

  public void setCustomArray(List<CustomArray> arrays) {
    List<CustomArray> copyList = new ArrayList<>();
    for (CustomArray array : arrays) {
      copyList.add(new CustomArray(array.getCustomArray()));
    }
    this.arrays = copyList;
  }

}
