package com.cp.examples.amazon;

import org.junit.Test;
import junit.framework.TestCase;

/**
 * The QueueTest class is...
 * <p/>
 * QueueTest.java (c) 30 01 2011
 * @author jblum
 * @version $Revision: 1.1 $
 */
public class QueueTest extends TestCase {

  @Test
  public void testQueue() throws Exception {
    final String[] elements = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    final Queue<String> queue = new Queue<String>();

    for (final String element : elements) {
      queue.engue(element);
    }

    int index = 0;

    while (!queue.isEmpty()) {
      assertEquals(elements[index++], queue.deque());
    }
  }

}
