package com.cp.examples.amazon;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The NumberUtilsTest class is...
 * <p/>
 * NumberUtilsTest.java (c) 19 01 2011
 * @author jblum
 * @version $Revision: 1.1 $
 */
public class NumberUtilsTest extends TestCase {

  public NumberUtilsTest(final String testName) {
    super(testName);
  }

  public static Test suite() {
    final TestSuite suite = new TestSuite();
    suite.addTestSuite(NumberUtilsTest.class);
    //suite.addTest(new NumberUtilsTest("testName"));
    return suite;
  }

  public void testFindValueWithAnOddNumberOfOccurrences() throws Exception {
    final Integer[] array = { 0, 0, 9, 9, 9, 9, 9, 9, 4, 4, 4, 4, 2, 2, 3, 3, 3, 8, 8, 8, 8, 8, 8, 8, 8 };
    assertEquals(new Integer(3), NumberUtils.findValueWithAnOddNumberOfOccurrences(array));
  }

  public void testFindValueWithAnOddNumberOfOccurrencesOptimized() throws Exception {
    final Integer[] array = { 0, 0, 9, 9, 9, 9, 9, 9, 4, 4, 4, 4, 2, 2, 3, 3, 3, 8, 8, 8, 8, 8, 8, 8, 8 };
    assertEquals(new Integer(3), NumberUtils.findValueWithAnOddNumberOfOccurrencesOptimized(array));
  }

}
