/*
  Copyright (c) 2011, TopCoder

  Problem Statement
      
  ***Note:  Please keep programs under 7000 characters in length.  Thank you

  Class Name: Prerequisites
  Mathod Name: orderClasses
  Parameters: String[]
  Returns: String[]

  You are a student at a college with the most unbelievably complex prerequisite
  structure ever. To help you schedule your classes, you decided to put together
  a program that returns the order in which the classes should be taken.

  Implement a class Prerequisites which contains a method orderClasses.  The
  method takes a String[] that contains the classes you must take and returns a
  String[] of classes in the order the classes should be taken so that all
  prerequisites are met.

  String[] elements will be of the form (and TopCoder will ensure this):
  "CLASS: PRE1 PRE2 ..." where PRE1 and PRE2 are prerequisites of CLASS.  CLASS,
  PRE1, PRE2, ... consist of a department name (3 or 4 capital letters, A-Z
  inclusive) followed by a class number (an integer between 100 and 999,
  inclusive).  The department name should be immediately followed by the class
  number with no additional characters, numbers or spaces (i.e. MATH217).  It is
  not necessary for a class to have prerequisites.  In such a case, the colon is
  the last character in the String.

  You can only take one class at a time, therefore, use the following rules to
  determine which class to take :
  1) Any prerequisite class(es) listed for a class must be taken before the class
  can be taken.
  2) If multiple classes can be taken at the same time, you take the one with the
  lowest number first, regardless of department.
  3) If multiple classes with the same number can be taken at the same time, you
  take the department name which comes first in alphabetical order.
  4) If the inputted course schedule has errors, return a String[] of length 0.
  There is an error if it is impossible to return the classes in an order such
  that all prerequisites are met, or if a prerequisite is a course that does not
  have its own entry in the inputted String[].

  Examples of valid input Strings are:
  "CSE111: CSE110 MATH101"
  "CSE110:"

  Examples of invalid input Strings are:
  "CS117:" (department name must consist of 3 - 4 capital letters, inclusive)
  "cs117:" (department name must consist of 3 - 4 capital letters, inclusive)
  "CS9E11:" (department name must be letters only)
  "CSE110: " (no trailing spaces allowed)
  "CSE110: CSE101 " (no trailing spaces allowed)
  "MATH211: MAM2222" (class number to large)
  "MATH211: MAM22" (class number to small)
  "ENGIN517: MATH211" (department name to large)

  Here is the method signature (be sure your method is public):
  String[] orderClasses(String[] classSchedule);

  TopCoder will make sure classSchedule contains between 1 and 20 Strings,
  inclusive, all of the form above.  The Strings will have between 1 and 50
  characters, inclusive.  TopCoder will check that the syntax of the Strings are
  correct: The Strings will contain a valid class name, followed by a colon,
  possibly followed by a series of unique prerequisite classes separated by
  single spaces.  Also, TopCoder will ensure that each class has at most one
  entry in the String[].

  Examples:
  If classSchedule={
  "CSE121: CSE110",
  "CSE110:",
  "MATH122:",
  }
  The method should return: {"CSE110","CSE121","MATH122"}

  If classSchedule={
  "ENGL111: ENGL110",
  "ENGL110: ENGL111"
  }
  The method should return: {}

  If classSchedule=[
  "ENGL111: ENGL110"
  }
  The method should return: {}

  If classSchedule={
  "CSE258: CSE244 CSE243 INTR100"
  "CSE221: CSE254 INTR100"
  "CSE254: CSE111 MATH210 INTR100"
  "CSE244: CSE243 MATH210 INTR100"
  "MATH210: INTR100"
  "CSE101: INTR100"
  "CSE111: INTR100"
  "ECE201: CSE111 INTR100"
  "ECE111: INTR100"
  "CSE243: CSE254"
  "INTR100:"
  }

  If classSchedule={
  "INTR100:"
  "CSE101: INTR100"
  "CSE111: INTR100"
  "ECE111: INTR100"
  "ECE201: CSE111 INTR100"
  "MATH210: INTR100"
  "CSE254: CSE111 MATH210 INTR100"
  "CSE221: CSE254 INTR100"
  "CSE243: CSE254"
  "CSE244: CSE243 MATH210 INTR100"
  "CSE258: CSE244 CSE243 INTR100"
  }

  The method should return:
  {"INTR100","CSE101","CSE111","ECE111","ECE201","MATH210","CSE254","CSE221","CSE2
  43","CSE244","CSE258"}
  Definition

  Class: Prerequisites
  Method: orderClasses
  Parameters: String[]
  Returns: String[]
  Method signature: String[] orderClasses(String[] param0)

  This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */

package com.cp.examples.topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The Prerequisites class is...
 * <p/>
 * Prerequisites.java (c) 17 January 2011
 * @author jblum
 * @version $Revision: 1.1 $
 */
public class Prerequisites {

  private List<AClass> parse(final String[] requiredClasses) {
    final List<AClass> allClasses = new ArrayList<AClass>(requiredClasses.length);
    final List<String> classPrerequisites = new ArrayList<String>(requiredClasses.length);

    for (final String requiredClass : requiredClasses) {
      final String[] classesAndPrequisites = requiredClass.split(":");
      allClasses.add(new AClass(classesAndPrequisites[0]));
      classPrerequisites.add(Utility.valueAt(classesAndPrequisites, 1, ""));
    }

    int index = 0;

    for (final AClass clazz : allClasses) {
      for (final String prerequisite : classPrerequisites.get(index++).split(" ")) {
        clazz.addPrerequisite(prerequisite.trim());
      }
    }

    return allClasses;
  }

  public String[] orderClasses(final String[] requiredClasses) {
    final Object[] orderedClasses = new TreeSet<AClass>(parse(requiredClasses)).toArray();
    final String[] classSchedule = new String[orderedClasses.length];

    int index = 0;
    for (final Object clazz : orderedClasses) {
      classSchedule[index++] = clazz.toString();
    }

    return classSchedule;
  }

  public static void main(final String... args) {
    final String[] requiredClasses = {
      "CSE258: CSE244 CSE243 INTR100"
      , "CSE221: CSE254 INTR100"
      , "CSE254: CSE111 MATH210 INTR100"
      , "CSE244: CSE243 MATH210 INTR100"
      , "MATH210: INTR100"
      , "CSE101: INTR100"
      , "CSE111: INTR100"
      , "ECE201: CSE111 INTR100"
      , "ECE111: INTR100"
      , "CSE243: CSE254"
      , "INTR100:"
    };

    System.out.println(Arrays.asList(new Prerequisites().orderClasses(requiredClasses)));
  }

  private static class AClass implements Comparable<AClass> {

    private static final Map<String, AClass> cache = new TreeMap<String, AClass>();

    private final String name;

    private final Set<AClass> prerequisites = new TreeSet<AClass>();
    private final Set<String> prerequisiteClassNames = new TreeSet<String>();

    public AClass(final String name) {
      assert name != null && !"".equals(name.trim()) : "The name of the class cannot be null!";
      this.name = name;
      cache.put(name, this);
    }

    public int getCourseLevel() {
      return Integer.parseInt(Utility.getDigitsOnly(getName()));
    }

    public String getCourseName() {
      return Utility.getLettersOnly(getName());
    }

    public boolean isLeaf() {
      return prerequisites.isEmpty();
    }

    public String getName() {
      return name;
    }

    public boolean addPrerequisite(final String name) {
      final AClass prerequisite = cache.get(name);
      return (prerequisite != null && prerequisites.add(prerequisite));
    }

    private void allPrerequisites(final Set<String> prerequisiteClassNames) {
      for (final AClass prerequisiteClass : prerequisites) {
        prerequisiteClassNames.add(prerequisiteClass.getName());
        prerequisiteClass.allPrerequisites(prerequisiteClassNames);
      }
    }

    public int compareTo(final AClass anotherClass) {
      if (dependsOn(anotherClass)) {
        // detect circular dependencies
        if (anotherClass.dependsOn(this)) {
          throw new CircularDependencyException();
        }
        return 1;
      }

      int compareValue = (getCourseLevel() - anotherClass.getCourseLevel());

      return (compareValue != 0 ? compareValue : getCourseName().compareTo(anotherClass.getCourseName()));
    }

    public boolean dependsOn(final AClass anotherClass) {
      if (!isLeaf() && prerequisiteClassNames.isEmpty()) {
        allPrerequisites(prerequisiteClassNames);
      }
      return prerequisiteClassNames.contains(anotherClass.getName());
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
        return true;
      }

      if (!(obj instanceof AClass)) {
        return false;
      }

      final AClass that = (AClass) obj;

      return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
      int hashValue = 17;
      hashValue = 37 * hashValue + getName().hashCode();
      return hashValue;
    }

    @Override
    public String toString() {
      return name;
    }
  }

  private static class CircularDependencyException extends RuntimeException { }

  private static class NoLeafException extends RuntimeException { }

  private static final class Utility {

    public static String getDigitsOnly(final String text) {
      final StringBuffer buffer = new StringBuffer();
      for (char chr : text.toCharArray()) {
        if (Character.isDigit(chr)) {
          buffer.append(chr);
        }
      }
      return buffer.toString();
    }

    public static String getLettersOnly(final String text) {
      final StringBuffer buffer = new StringBuffer();
      for (char chr : text.toCharArray()) {
        if (Character.isLetter(chr)) {
          buffer.append(chr);
        }
      }
      return buffer.toString();
    }

    public static String valueAt(final String[] array, final int index, final String defaultValue) {
      assert array != null : "The String array cannot be null!";
      assert index > -1 : "The array index cannot be negative!";
      return (array.length > index ? array[index] : defaultValue);
    }
  }

}
