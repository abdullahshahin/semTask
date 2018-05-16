package com.getyourguid.sem.models;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by abshahin on 5/15/18.
 */
public class CompanyMetrics {
  private List<KeywordSearch> keywordSearchList;
  private long totalRevenue = 0;
  private float totalCost = 0;
  private float semImpressionsMean = 0;
  private float semCtrMean = 0;

  private float firstPositionHitPercentage = 0;
  private float secondPositionHitPercentage = 0;
  private float thirdPositionHitPercentage = 0;
  private float behindThirdPositionHitPercentage = 0;

  private float firstPositionCostRatio = 0;
  private float secondPositionCostRatio = 0;
  private float thirdPositionCostRatio = 0;
  private float behindThirdPositionCostRatio = 0;

  private int profit = 0;

  private final Locale locale = new Locale("en", "US");
  private final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

  public CompanyMetrics(List<KeywordSearch> keywordSearchList) {
    this.keywordSearchList = keywordSearchList;
    calculate();
  }

  private void calculate() {
    int length = keywordSearchList.size();
    keywordSearchList.forEach(keywordSearch -> {
      if(keywordSearch.getPosition() == 1) {
        firstPositionHitPercentage++;
        firstPositionCostRatio += keywordSearch.getCost();
      }
      else if(keywordSearch.getPosition() == 2) {
        secondPositionHitPercentage++;
        secondPositionCostRatio += keywordSearch.getCost();
      }
      else if(keywordSearch.getPosition() == 3) {
        thirdPositionHitPercentage++;
        thirdPositionCostRatio += keywordSearch.getCost();
      }
      else {
        behindThirdPositionHitPercentage++;
        behindThirdPositionCostRatio += keywordSearch.getCost();
      }
      totalRevenue += keywordSearch.getRevenue();
      totalCost += keywordSearch.getCost();
      semImpressionsMean += keywordSearch.getImpressions();
      semCtrMean += keywordSearch.getCtr();
    });

    profit = (int) (totalRevenue - totalCost);
    semImpressionsMean = semImpressionsMean/length;
    semCtrMean = semCtrMean/length;

    firstPositionHitPercentage = (firstPositionHitPercentage/length)*100;
    secondPositionHitPercentage = (secondPositionHitPercentage/length)*100;
    thirdPositionHitPercentage = (thirdPositionHitPercentage/length)*100;
    behindThirdPositionHitPercentage = (behindThirdPositionHitPercentage/length)*100;

    firstPositionCostRatio = firstPositionCostRatio/length;
    secondPositionCostRatio = secondPositionCostRatio/length;
    thirdPositionCostRatio = thirdPositionCostRatio/length;
    behindThirdPositionCostRatio = behindThirdPositionCostRatio/length;
  }

  public float getFirstPositionHitPercentage() {
    return firstPositionHitPercentage;
  }

  public float getSecondPositionHitPercentage() {
    return secondPositionHitPercentage;
  }

  public float getThirdPositionHitPercentage() {
    return thirdPositionHitPercentage;
  }

  public float getBehindThirdPositionHitPercentage() {
    return behindThirdPositionHitPercentage;
  }

  public String  getFirstPositionCostRatio() {
    return currencyFormatter.format(firstPositionCostRatio);
  }

  public String getSecondPositionCostRatio() {
    return currencyFormatter.format(secondPositionCostRatio);
  }

  public String getThirdPositionCostRatio() {
    return currencyFormatter.format(thirdPositionCostRatio);
  }

  public String getBehindThirdPositionCostRatio() {
    return currencyFormatter.format(behindThirdPositionCostRatio);
  }

  public String getTotalRevenue() {
    return currencyFormatter.format(totalRevenue);
  }

  public String getTotalCost() {
    return currencyFormatter.format(totalCost);
  }

  public float getSemImpressionsMean() {
    return semImpressionsMean;
  }

  public float getSemCtrMean() {
    return semCtrMean;
  }

  public String getProfit() {
    return currencyFormatter.format(profit);
  }

  public int getProfitNumber() {
    return profit;
  }

  public float getTotalRevenueNumber() {
    return totalRevenue;
  }

  public float getTotalCostNumber() {
  return totalCost;
}

  public float getFirstPositionCostRatioNumber() {
  return firstPositionCostRatio;
}

  public float getSecondPositionCostRatioNumber() {
  return secondPositionCostRatio;
}

  public float getThirdPositionCostRatioNumber () {
  return thirdPositionCostRatio;
}

  public float getBehindThirdPositionCostRatioNumber() {
  return behindThirdPositionCostRatio;
}
}
