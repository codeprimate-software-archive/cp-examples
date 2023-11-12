/*
 * Foo.java (c) 28 December 2006
 *
 * Copyright (c) 2003, Code Primate
 * All Rights Reserved
 * @author John J. Blum
 * @version 2007.10.19
 */

package com.cp.examples.jivesoftware;

import java.util.LinkedList;
import java.util.List;

public class Foo {

  private static List<String> strings;

  /**
   * Counts the number of times the given input string occurs in an internal list.
   * @param input String to check.
   * @return the number of times the given string exists in the list, or 0 if it does not exist.
   */
  public static int getStringCount(String input) {
    int count = 0;
    input = (input == null ? input : input.trim());
    for (String str : strings) {
      if (str != null && str.trim().equals(input)) {
        count++;
      }
    }
    return count;
  }

  public static void main(final String[] args) {
    strings = new LinkedList<String>(); // new ArrayList<String>(<some arbitrary number if known>);
    strings.add("foo");
    strings.add(null);
    strings.add("bar");
    strings.add("bar");

    System.out.println("count of 'foo' in list = " + getStringCount("foo"));
    assert (getStringCount("foo") == 1) : "The List only contains 1 foo!";
    System.out.println("count of 'bar' in list = " + getStringCount("bar"));
    assert (getStringCount("bar") == 2) : "The List contains 2 bar!";
    System.out.println("count of 'bar   ' in list = " + getStringCount("bar   "));
    assert (getStringCount("bar   ") == 2) : "The List contains 2 bar!";
    System.out.println("count of 'nothing' in list = " + getStringCount("nothing"));
    assert (getStringCount("nothing") == 0) : "The List does not contain 'nothing'!";
  }

}
