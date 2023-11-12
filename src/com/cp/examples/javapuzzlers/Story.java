package com.cp.examples.javapuzzlers;

public class Story {

  private static void story(Object... o) {
    if (o != null) {
      System.out.println("O noes!");
    }
  }

  public static void main(final String[] args) {
    Object o = null;
    story(o);
  }

}
