package com.cp.examples.tripwire;

import org.junit.Test;
import junit.framework.TestCase;


/**
 * The RangeFinderTest class is...
 * <p/>
 * RangeFinderTest.java (c) 30 01 2011
 * @author jblum
 * @version $Revision: 1.1 $
 */
public class RangeFinderTest extends TestCase {

  @Test
  public void testFindRangeWithNullSequence() throws Exception {
    try {
      RangeFinder.findLongestRange(null);
      fail("Calling findLongestRange with a null sequence should have thrown an AssertionError!");
    }
    catch (AssertionError e) {
      assertEquals("The sequence of values cannot be null!", e.getMessage());
    }
  }

  @Test
  public void testFindRangeWithEmptySequence() throws Exception {
    assertNull(RangeFinder.findLongestRange(""));
  }

  @Test
  public void testFindRangeWithOneCharacterSequence() throws Exception {
    final String sequence = "a";

    final RangeFinder.Range<String> expectedRange = new RangeFinder.Range<String>("a", 0, 0);
    final RangeFinder.Range<String> actualRange = RangeFinder.findLongestRange(sequence);

    assertNotNull(actualRange);
    assertEquals(expectedRange, actualRange);
  }

  @Test
  public void testFindRange() throws Exception {
    final String sequence = "abbcccccccccddddeeeeefff";

    final RangeFinder.Range<String> expectedRange = new RangeFinder.Range<String>("c", 3, 11);
    final RangeFinder.Range actualRange = RangeFinder.findLongestRange(sequence);

    assertNotNull(actualRange);
    assertEquals(expectedRange, actualRange);
  }

  @Test
  public void testFindRangeEdgeCase() throws Exception {
    String sequence = "aaaabbbccd";

    RangeFinder.Range<String> expectedRange = new RangeFinder.Range<String>("a", 0, 3);
    RangeFinder.Range<String> actualRange = RangeFinder.findLongestRange(sequence);

    assertNotNull(actualRange);
    assertEquals(expectedRange, actualRange);

    sequence = "abbccccdddddddd";
    expectedRange = new RangeFinder.Range<String>("d", 7, 14);
    actualRange = RangeFinder.findLongestRange(sequence);

    assertNotNull(actualRange);
    assertEquals(expectedRange, actualRange);
  }

}
