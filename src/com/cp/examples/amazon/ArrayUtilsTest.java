package com.cp.examples.amazon;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The ArrayUtilsTest class is...
 * <p/>
 * ArrayUtilsTest.java (c) 19 01 2011
 * @author jblum
 * @version $Revision: 1.1 $
 */
public class ArrayUtilsTest extends TestCase {

  public ArrayUtilsTest(final String testName) {
    super(testName);
  }

  public static Test suite() {
    final TestSuite suite = new TestSuite();
    suite.addTestSuite(ArrayUtilsTest.class);
    //suite.addTest(new ArrayUtilsTest("testName"));
    return suite;
  }

  public void testIndexedMatchWithMatchingArrays() throws Exception {
    int[] arrayOne = { 5, 2, 6, 6, 8, 9, 3, 4, 4 };
    int[] arrayTwo = { 2, 6, 5, 8, 6, 4, 3, 4, 9 };

    assertTrue(ArrayUtils.indexedMatch(arrayOne, arrayTwo));
  }

  public void testIndexedMatchWithDifferentLengthArrays() throws Exception {
    int[] arrayOne = { 5, 2, 6, 6, 8, 9, 3, 4 };
    int[] arrayTwo = { 5, 2, 6, 6, 8, 9, 3, 4, 9 };

    assertFalse(ArrayUtils.indexedMatch(arrayOne, arrayTwo));
  }

  public void testIndexedMatchWithNonMatchingArraysSameNumberOfElements() throws Exception {
    int[] arrayOne = { 6, 10 };
    int[] arrayTwo = { 9, 7 };

    assertFalse(ArrayUtils.indexedMatch(arrayOne, arrayTwo));
  }

  public void testIndexedMatchWithInverseArrays() throws Exception {
    int[] arrayOne = { -1, -2, -3 };
    int[] arrayTwo = { 1, 2, 3 };

    assertFalse(ArrayUtils.indexedMatch(arrayOne, arrayTwo));
  }

  public void testIndexedMatchWithOneValue() throws Exception {
    int[] arrayOne = { 1 };
    int[] arrayTwo = { 102 };

    assertFalse(ArrayUtils.indexedMatch(arrayOne, arrayTwo));
  }

}
