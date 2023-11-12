package com.cp.examples.amazon;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The InfiniteArrayBinarySearchTest class is...
 * <p/>
 * InfiniteArrayBinarySearchTest.java (c) 21 February 2011
 * @author jblum
 * @version $Revision: 1.1 $
 * @see InfiniteBinarySearch
 */
public class InfiniteArrayBinarySearchTest {

  @Test
  public void testSearch() throws Exception {
    final Integer[] array = {
      -10, -9, -9, -7, -4, -2, -2, -2, 0, 0,
      1, 3, 3, 4, 6, 6, 6, 6, 9, 10,
      11, 11, 11, 11, 11, 11, 13, 14, 14, 17,
      21, 21, 22, 23, 24, 24, 29, 31, 31, 35,
      39, 40, 40, 42, 42, 42, 42, 43, 48, 48,
      52, 52, 52, 53, 55, 55, 55, 55, 56, 59,
      60, 61, 61, 61, 61, 62, 66, 67, 68, 70,
      71, 71, 71, 72, 74, 74, 76, 77, 79, 79,
      81, 85, 87, 87, 87, 91, 96, 96, 99, 100,
      100, 100, 100, 100, 100, 100, 100, 100, 100, 100
    };

    final int locationIndex = InfiniteBinarySearch.search(array, 42);

    //System.out.println(locationIndex);
    assertTrue(locationIndex >= 43 && locationIndex <= 46);
  }

}
