package epam.mikalai.main;

import epam.mikalai.array.entity.CustomArray;
import epam.mikalai.array.repository.CustomArrayRepository;

public class Main {
  public static void main(String[] args) {
    CustomArrayRepository repository = CustomArrayRepository.getInstance();

    CustomArray array1 = new CustomArray(1, 2, 3);
    CustomArray array2 = new CustomArray(4, 5, 6);

    repository.add(array1);
    repository.add(array2);

    repository.remove(array1);

    repository.getCustomArrays().forEach(System.out::println);
  }
}
