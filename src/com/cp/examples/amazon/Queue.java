package com.cp.examples.amazon;

import java.util.Stack;

/**
 * The Queue class is...
 * <p/>
 * Queue.java (c) 30 01 2011
 * @author jblum
 * @version $Revision: 1.1 $
 */
public class Queue<T> {

  private final Stack<T> front = new Stack<T>();
  private final Stack<T> back = new Stack<T>();

  public T engue(final T element) {
    while (!front.isEmpty()) {
      back.push(front.pop());
    }
    return back.push(element);
  }

  public T deque() {
    while (!back.isEmpty()) {
      front.push(back.pop());
    }
    return front.pop();
  }

  public boolean isEmpty() {
    return (front.isEmpty() && back.isEmpty());
  }

}
