package com.getyourguid.sem.models;

/**
 * Created by abshahin on 5/15/18.
 */
public class KeywordSearch {
  private String keyword;
  private int impressions;
  private float ctr;
  private float cost;
  private int position;
  private int rank;
  private String companyName;
  private float revenue;
  private float quality;
  private float maxBid;

  public KeywordSearch(String keyword, int impressions, float ctr, float cost, int position, String companyName, float revenue) {
    this.keyword = keyword;
    this.impressions = impressions;
    this.ctr = ctr;
    this.cost = cost;
    this.position = position;
    this.companyName = companyName;
    this.revenue = revenue;
    // below values could be mathematically valid assumptions but
    // I don't think its good to depend on them to define a pattern
    // as we have at least 2 unknown variables in one equation
    this.rank = (10 - position);
    maxBid = 2;
    quality = (rank / maxBid);
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public int getImpressions() {
    return impressions;
  }

  public void setImpressions(int impressions) {
    this.impressions = impressions;
  }

  public float getCtr() {
    return ctr;
  }

  public void setCtr(float ctr) {
    this.ctr = ctr;
  }

  public float getCost() {
    return cost;
  }

  public void setCost(float cost) {
    this.cost = cost;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public float getRevenue() {
    return revenue;
  }

  public void setRevenue(float revenue) {
    this.revenue = revenue;
  }

  public float getQuality() {
    return quality;
  }

  public void setQuality(float quality) {
    this.quality = quality;
  }

  public float getMaxBid() {
    return maxBid;
  }

  public void setMaxBid(float maxBid) {
    this.maxBid = maxBid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    KeywordSearch that = (KeywordSearch) o;

    if (impressions != that.impressions) return false;
    if (Float.compare(that.ctr, ctr) != 0) return false;
    if (Float.compare(that.cost, cost) != 0) return false;
    if (position != that.position) return false;
    if (Float.compare(that.revenue, revenue) != 0) return false;
    if (!keyword.equals(that.keyword)) return false;
    return companyName.equals(that.companyName);
  }

  @Override
  public int hashCode() {
    int result = keyword.hashCode();
    result = 31 * result + impressions;
    result = 31 * result + (ctr != +0.0f ? Float.floatToIntBits(ctr) : 0);
    result = 31 * result + (cost != +0.0f ? Float.floatToIntBits(cost) : 0);
    result = 31 * result + position;
    result = 31 * result + companyName.hashCode();
    result = 31 * result + (revenue != +0.0f ? Float.floatToIntBits(revenue) : 0);
    return result;
  }
}
