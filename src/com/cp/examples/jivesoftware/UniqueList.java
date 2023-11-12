/*
 * UniqueList.java (c) 27 December 2006
 *
 * Copyright (c) 2003, Code Primate
 * All Rights Reserved
 * @author John J. Blum
 * @version 2007.10.19
 */

package com.cp.examples.jivesoftware;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UniqueList<E> extends AbstractList<E> {

  private final List<E> backingList;

  public UniqueList() {
    this(new ArrayList<E>());
  }
  public UniqueList(final List<E> backingList) {
    this.backingList = backingList;
  }

  public void add(final int index, final E e) {
    if (contains(e)) {
      throw new IllegalArgumentException("Element (" + e + ") is already in the List!");
    }
    backingList.add(index, e);
  }

  public E get(final int index) {
    return backingList.get(index);
  }

  public E set(final int index, final E e) {
    if (contains(e)) {
      throw new IllegalArgumentException("Element (" + e + ") is already contained in the List!");
    }
    return backingList.set(index, e);
  }

  public E remove(final int index) {
    return backingList.remove(index);
  }

  public int size() {
    return backingList.size();
  }

  private static void printList(final List list) {
    for (Object element : list) {
      System.out.println(element);
    }
  }

  public static void main(final String[] args) {
    final List<String> animalList = new UniqueList<String>(new ArrayList<String>(5));
    animalList.add("Ape");
    animalList.add("Baboon");
    animalList.add("Chimpanzee");
    animalList.add("Orangutang");
    //animalList.add(10);

    try {
      animalList.add("Ape");
      assert false : "The List already contains 'Ape' and should have thrown an IllegalArgumentException!";
    }
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    printList(animalList);

    final List<Integer> primeNumberList = new UniqueList<Integer>(new LinkedList<Integer>());
    primeNumberList.add(1);
    primeNumberList.add(2);
    primeNumberList.add(3);
    primeNumberList.add(5);
    primeNumberList.add(7);

    try {
      primeNumberList.set(0, 5);
      assert false : "The List already contains 5 and should have thrown an IllegalArgumentException!";
    }
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    printList(primeNumberList);
  }

}
