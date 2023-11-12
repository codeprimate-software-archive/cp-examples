package com.cp.examples.amazon;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The WebCrawler class is...
 * <p/>
 * WebCrawler.java (c) 30 January 2011
 * @author jblum
 * @version $Revision: 1.2 $
 */
public class WebCrawler {

  public static Collection<WebPage> getAllWebPagesAtDistance(final WebPage root, final int distance) {
    final Set<WebPage> atDistance = new TreeSet<WebPage>();
    final Set<WebPage> lessThanDistance = new TreeSet<WebPage>();
    getAllWebPagesAtDistance(root, distance, 0, atDistance, lessThanDistance);
    atDistance.removeAll(lessThanDistance);
    return atDistance;
  }

  public static void getAllWebPagesAtDistance(final WebPage page,
                                              final int distance,
                                              final int depth,
                                              final Set<WebPage> atDistance,
                                              final Set<WebPage> lessThanDistance)
  {
    if (depth < distance) {
      lessThanDistance.add(page);
      for (final WebPage link : page.getLinks()) {
        getAllWebPagesAtDistance(link, distance, depth + 1, atDistance, lessThanDistance);
      }
    }
    atDistance.add(page);
  }

  public static class WebPage implements Comparable<WebPage>, Serializable {

    private final String title;
    private Map<String, WebPage> links = new TreeMap<String, WebPage>();

    public WebPage(final String title) {
      assert title != null : "The web page title cannot be null!";
      this.title = title;
    }

    public String getTitle() {
      return title;
    }

    public WebPage addLink(final WebPage page) {
      assert page != null : "The web page to link this page with cannot be null!";
      return links.put(page.getTitle(), page);
    }

    public Collection<WebPage> getLinks() {
      return links.values();
    }

    @Override
    public int compareTo(final WebPage page) {
      return getTitle().compareTo(page.getTitle());
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
        return true;
      }

      if (!(obj instanceof WebPage)) {
        return false;
      }

      final WebPage that = (WebPage) obj;

      return getTitle().equals(that.getTitle());
    }

    @Override
    public int hashCode() {
      int hashValue = 17;
      hashValue = 37 * hashValue + getTitle().hashCode();
      return hashValue;
    }

    @Override
    public String toString() {
      return getTitle();
    }
  }

}
