package com.cp.examples.amazon;

import java.util.Arrays;

/**
 * The ArrayUtils class is...
 * <p/>
 * ArrayUtils.java (c) 19 January 2011
 * @author jblum
 * @version $Revision: 1.1 $
 */
public class ArrayUtils {

  public static boolean containmentMatch(Object[] arrayOne, Object[] arrayTwo) {
    assert arrayOne != null : "The first array in the containment matching comparison cannot be null!";
    assert arrayTwo != null : "The second array in the containment matching comparison cannot be null!";
    return Arrays.asList(arrayOne).containsAll(Arrays.asList(arrayTwo));
  }

  private static boolean equalHashCodes(final Object[] arrayOne, final Object[] arrayTwo) {
    return (hashCode(arrayOne) == hashCode(arrayTwo));
  }

  private static boolean equalSize(final Object[] arrayOne, final Object[] arrayTwo) {
    return (arrayOne.length == arrayTwo.length);
  }

  private static int hashCode(final Object... array) {
    assert array != null : "The array to compute a hash code for cannot be null!";
    int hashValue = 0;
    for (final Object element : array) {
      hashValue += element.hashCode();
    }
    return hashValue;
  }

  public static boolean hashMatch(final Object[] arrayOne, final Object[] arrayTwo) {
    assert arrayOne != null : "The first array in the hash matching comparison cannot be null!";
    assert arrayTwo != null : "The second array in the hash matching comparison cannot be null!";
    return (equalSize(arrayOne, arrayTwo) && equalHashCodes(arrayOne, arrayTwo));
  }

  public static boolean indexedMatch(final int[] arrayOne, final int[] arrayTwo) {
    assert arrayOne != null : "The first array in the indexed matching comparison cannot be null!";
    assert arrayTwo != null : "The second array in the indexed matching comparison cannot be null!";

    // short circuit match comparison
    if (arrayOne.length != arrayTwo.length) {
      return false;
    }

    int[] indexArray = new int[101];
    int negativeNumberCount = 0;

    for (int number : arrayOne) {
      negativeNumberCount += (number < 0 ? 1 : 0);
      indexArray[Math.abs(number) % indexArray.length]++;
    }

    for (int number : arrayTwo) {
      negativeNumberCount -= (number < 0 ? -1 : 0);
      indexArray[Math.abs(number) % indexArray.length]--;
    }

    for (int number : indexArray) {
      if (number != 0) {
        return false;
      }
    }

    return (negativeNumberCount == 0);
  }

}
