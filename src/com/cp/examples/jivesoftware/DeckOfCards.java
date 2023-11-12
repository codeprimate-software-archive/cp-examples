/*
 * DeckOfCards.java (c) 28 December 2006
 *
 * Copyright (c) 2003, Code Primate
 * All Rights Reserved
 * @author John J. Blum
 * @version 2007.10.19
 */

package com.cp.examples.jivesoftware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

  private final List<Card> deck = new ArrayList<Card>(52);

  public DeckOfCards() {
    for (Suite suite : Suite.values()) {
      for (Rank rank : Rank.values()) {
        deck.add(new Card(rank, suite));
      }
    }
  }

  public int getSize() {
    return deck.size();
  }

  public List<Card> draw(final int number) {
    if (number > getSize()) {
      throw new IllegalArgumentException("Cannot draw (" + number + ") card(s) from the deck; there are only ("
        + getSize() + ") card(s) in the deck!");
    }

    final List<Card> cardsDrawn = new ArrayList<Card>(number);

    for (int index = 0; index < number; index++ ) {
      cardsDrawn.add(deck.remove(index));
    }

    return cardsDrawn;
  }

  public void shuffle() {
    Collections.shuffle(deck);
  }

  public String toString() {
    final StringBuffer buffer = new StringBuffer();

    for (Card card : deck) {
      buffer.append(card);
      buffer.append("\n");
    }

    return buffer.toString();
  }

  public static void main(final String[] args) {
    final DeckOfCards deck = new DeckOfCards();
    //System.out.println(deck);
    int size = deck.getSize();

    assert (size == 52) : "Expected deck size is 52 cards; actual deck size was (" + size + ") card(s)!";

    deck.shuffle();
    final List<Card> cardsDrawn = deck.draw(5);
    size = deck.getSize();

    assert (size == 47) : "Expected deck size is 47 cards; actual deck size was (" + size + ") card(s)!";

    for (Card card : cardsDrawn) {
      System.out.println("card: " + card);
    }
  }

  public static final class Card {

    private final Rank rank;
    private final Suite suite;

    protected Card(final Rank rank, final Suite suite) {
      assert (rank != null) : "The card's rank cannot be null!";
      assert (suite != null) : "The card's suite cannot be null!";
      this.rank = rank;
      this.suite = suite;
    }

    public Rank getRank() {
      return rank;
    }

    public Suite getSuite() {
      return suite;
    }

    public boolean equals(final Object obj) {
      if (obj == this)  {
        return false;
      }

      if (!(obj instanceof Card)) {
        return false;
      }

      final Card that = (Card) obj;

      return getRank().equals(that.getRank())
        && getSuite().equals(that.getSuite());
    }

    public int hashCode() {
      int hashValue = 17;
      hashValue = 37 * hashValue + getRank().hashCode();
      hashValue = 37 * hashValue + getSuite().hashCode();
      return hashValue;
    }

    public String toString() {
      final StringBuffer buffer = new StringBuffer();
      buffer.append(getRank());
      buffer.append(" of ");
      buffer.append(getSuite());
      return buffer.toString();
    }
  }

  public static enum Rank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIZE("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace");

    private final String desciption;

    Rank(final String description) {
      this.desciption = description;
    }

    public String toString() {
      return desciption;
    }
  }

  public static enum Suite {
    CLUB("clubs"),
    DIAMOND("diamonds"),
    HEART("hearts"),
    SPADE("spades");

    private final String description;

    Suite(final String description) {
      this.description = description;
    }

    public String toString() {
      return description;
    }
  }

}
