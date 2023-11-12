package com.cp.examples.tripwire;

/**
 * The RangeFinder class is...
 * <p/>
 * RangeFinderTest.java (c) 30 January 2011
 * @author jblum
 * @version $Revision: 1.1 $
 */
public class RangeFinder {

  public static Range<String> findLongestRange(final String sequence) {
    assert sequence != null : "The sequence of values cannot be null!";

    if (sequence.length() > 0) {
      Range<String> currentRange = new Range<String>(String.valueOf(sequence.charAt(0)), 0);
      Range<String> longestRange = currentRange;

      for (int index = 1, length = sequence.length(); index < length; index++) {
        final String charAsString = String.valueOf(sequence.charAt(index));

        if (!currentRange.isSameValue(charAsString)) {
          currentRange.setEndIndex(index - 1);
          longestRange = getLongerRanger(currentRange, longestRange);
          currentRange = new Range<String>(charAsString, index);
        }
      }

      currentRange.setEndIndex(sequence.length() - 1);
      longestRange = getLongerRanger(currentRange, longestRange);

      return longestRange;
    }

    return null;
  }

  private static <T> Range<T> getLongerRanger(final Range<T> left, final Range<T> right) {
    assert left != null : "The Range on the left side of the length comparison cannot be null!";
    assert right != null : "The Range on the right side of the length comparison cannot be null!";
    return (left.getLength() > right.getLength() ? left : right);
  }

  public static class Range<T> {

    private final T value;

    private int beginIndex;
    private int endIndex;

    public Range(final T value, final int beginIndex) {
      assert value != null : "The value tracked cannot be null!";
      this.value = value;
      setBeginIndex(beginIndex);
      setEndIndex(beginIndex);
    }

    public Range(final T value, final int beginIndex, final int endIndex) {
      assert value != null : "The value tracked cannot be null!";
      this.value = value;
      setBeginIndex(beginIndex);
      setEndIndex(endIndex);
    }

    public int getBeginIndex() {
      return beginIndex;
    }

    public void setBeginIndex(final int beginIndex) {
      assert beginIndex > -1 : "The begin index cannot be less than 0!";
      this.beginIndex = beginIndex;
    }

    public int getEndIndex() {
      return endIndex;
    }

    public void setEndIndex(final int endIndex) {
      assert endIndex >= this.beginIndex : "The end index cannot be less than begin index!";
      this.endIndex = endIndex;
    }

    public int getLength() {
      return ((getEndIndex() - getBeginIndex()) + 1);
    }
    public boolean isSameValue(final T value) {
      return getValue().equals(value);
    }

    public T getValue() {
      return value;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
        return true;
      }

      if (!(obj instanceof Range)) {
        return false;
      }

      final Range that = (Range) obj;

      return (getValue().equals(that.getValue()))
        && (getBeginIndex() == that.getBeginIndex())
        && (getEndIndex() == that.getEndIndex());
    }

    @Override
    public int hashCode() {
      int hashValue = 17;
      hashValue = 37 * hashValue + getValue().hashCode();
      hashValue = 37 * hashValue + getBeginIndex();
      hashValue = 37 * hashValue + getEndIndex();
      return hashValue;
    }

    @Override
    public String toString() {
      final StringBuffer buffer = new StringBuffer("The value (");
      buffer.append(getValue());
      buffer.append(") occurs at (");
      buffer.append(getBeginIndex());
      buffer.append(") and ends at (");
      buffer.append(getEndIndex());
      buffer.append(") with a total length of (");
      buffer.append(getLength());
      buffer.append(")");
      return buffer.toString();
    }
  }

}
