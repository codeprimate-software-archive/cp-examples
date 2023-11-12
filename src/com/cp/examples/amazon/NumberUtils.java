package com.cp.examples.amazon;

import java.util.Arrays;

/**
 * The NumberUtils class is...
 * <p/>
 * NumberUtils.java (c) 19 January 2011
 * @author jblum
 * @version $Revision: 1.1 $
 */
public class NumberUtils {

  public static Integer findValueWithAnOddNumberOfOccurrences(final Integer[] array) {
    assert array != null : "The array cannot be null!";

    Integer currentNumber = null;
    int count = 0;

    Arrays.sort(array);

    for (final Integer number : array) {
      if (!number.equals(currentNumber)) {
        if (count % 2 == 1) {
          return currentNumber;
        }
        currentNumber = number;
        count = 0;
      }
      count++;
    }

    return null;
  }

  public static Integer findValueWithAnOddNumberOfOccurrencesOptimized(final Integer[] array) {
    assert array != null : "The array cannot be null!";

    Arrays.sort(array);

    for (int index = 0; index < array.length; index += 2) {
      if (!array[index].equals(array[index + 1])) {
        return array[index];
      }
    }

    return (array.length % 2 == 1 ? array[array.length - 1] : null);
  }

}
