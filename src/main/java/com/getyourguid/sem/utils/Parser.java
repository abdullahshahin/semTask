package com.getyourguid.sem.utils;

import com.getyourguid.sem.models.KeywordSearch;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abshahin on 5/15/18.
 */
@Component
public class Parser {

  private static final CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
  private CSVParser parser;
  private List<KeywordSearch> keywordSearches;

  public List<KeywordSearch> extract(String fileName) throws IOException {
    List<KeywordSearch> keywordSearches = new ArrayList<>();
    parser = new CSVParser(new FileReader(fileName), format);
    for(CSVRecord record : parser){
      KeywordSearch keywordSearch = new KeywordSearch(record.get(0),
          Integer.valueOf(record.get("Impressions")),
          Float.valueOf(record.get("CTR")),
          Float.valueOf(record.get("Cost")),
          Integer.valueOf(record.get("Position")),
          record.get("Company"),
          Float.valueOf(record.get("Revenue")));
      keywordSearches.add(keywordSearch);
    }
    parser.close();
    return keywordSearches;
  }

  public List<KeywordSearch> getKeywordSearches() {
    return keywordSearches;
  }
}
