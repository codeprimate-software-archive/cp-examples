package com.cp.examples.amazon;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The InfiniteBinarySearch class is...
 * <p/>
 * InfiniteBinarySearch.java (c) 21 February 2011
 * @author jblum
 * @version $Revision: 1.1 $
 */
public class InfiniteBinarySearch {

  private static final Random RANDOM = new Random(Calendar.getInstance().getTimeInMillis());

  public static int search(final Integer[] array, final Integer searchValue) {
    //return search(sort(array), searchValue, null, null);
    return search(array, searchValue, null, null);
  }

  static int search(final Integer[] array,
                    final Integer searchValue,
                    final Integer lowIndex,
                    final Integer highIndex) {
    final Integer compareValueIndex = getRandomIndex(array, lowIndex, highIndex);

    if (array[compareValueIndex] < searchValue) {
      return search(array, searchValue, compareValueIndex, highIndex);
    }
    else if (array[compareValueIndex] > searchValue) {
      return search(array, searchValue, lowIndex, compareValueIndex);
    }
    else {
      return compareValueIndex;
    }
  }

  static Integer getRandomIndex(final Integer[] array,
                                final Integer lowIndex,
                                final Integer highIndex) {
    if (highIndex != null && lowIndex != null) {
      return (lowIndex + RANDOM.nextInt(highIndex - lowIndex));
    }
    else if (lowIndex != null) {
      return (lowIndex + RANDOM.nextInt(array.length - lowIndex));
    }
    else if (highIndex != null) {
      return RANDOM.nextInt(highIndex);
    }
    else {
      return RANDOM.nextInt(array.length);
    }
  }

  static Integer[] sort(final Integer[] array) {
    final List<Integer> arrayList = Arrays.asList(array);
    Collections.sort(arrayList);
    return arrayList.toArray(new Integer[arrayList.size()]);
  }

}
