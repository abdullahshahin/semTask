package com.getyourguid.sem.anaylzers;

import com.getyourguid.sem.models.CompanyMetrics;
import com.getyourguid.sem.models.KeywordSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by abshahin on 5/15/18.
 */
public class Analyzer {
  private List<KeywordSearch> keywordSearches = new ArrayList<>();
  private HashMap<String, List<KeywordSearch>> keywordSearcheGroups = new HashMap<>();
  private HashMap<String, CompanyMetrics> companyMetricsList = new HashMap<>();
  private HashMap<String, CompanyMetrics> sortedCompaniesperPerformance = new HashMap<>();
  public Analyzer(List<KeywordSearch> keywordSearches) {
    this.keywordSearches = keywordSearches;
    makeKeywordSearcheGroupPerCompany();
  }

  private void makeKeywordSearcheGroupPerCompany() {
    for(KeywordSearch keywordSearch: keywordSearches) {
      keywordSearcheGroups.computeIfAbsent(keywordSearch.getCompanyName(), k -> new ArrayList<>());
      List<KeywordSearch> currentCompanySearchGroup = keywordSearcheGroups.get(keywordSearch.getCompanyName());
      currentCompanySearchGroup.add(keywordSearch);
      keywordSearcheGroups.put(keywordSearch.getCompanyName(), currentCompanySearchGroup);
    }
  }

  public HashMap<String, CompanyMetrics> calculateMetrics() {
    keywordSearcheGroups.forEach((company, keywordSearch) -> {
      companyMetricsList.put(company, new CompanyMetrics(keywordSearch));
    });
    return companyMetricsList;
  }

  public HashMap<Integer, String> sortCompaniesPerformace() {
    HashMap<Integer, String> sorted = new HashMap<>();
    companyMetricsList.forEach((k, v) -> {
      sorted.put(v.getProfitNumber(), k);
    });
    TreeMap<Integer, String> sortedTree = new TreeMap<>(sorted);
    Set<Entry<Integer, String>> mappings = sortedTree.entrySet();
    HashMap<Integer, String> finalSort = new HashMap<>();
    for(Entry<Integer, String> mapping : mappings){
      finalSort.put(mapping.getKey(), mapping.getValue());
    }
    return finalSort;
  }

}

