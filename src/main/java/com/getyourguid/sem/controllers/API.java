package com.getyourguid.sem.controllers;

import com.getyourguid.sem.anaylzers.Analyzer;
import com.getyourguid.sem.models.CompanyMetrics;
import com.getyourguid.sem.models.KeywordSearch;
import com.getyourguid.sem.utils.Parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by abshahin on 5/16/18.
 */
@RestController
public class API {

  @Autowired
  Parser CSVfileParser;

  @Value("${upload.path}")
  private String uploadedFolderPath;

  @GetMapping("/api")
  public HashMap<String, CompanyMetrics> apiChart(@RequestParam(value="fileName", required=true) String fileName) throws IOException, IOException {
    List<KeywordSearch> keywordSearchList = CSVfileParser.extract(uploadedFolderPath + fileName);
    Analyzer analyzer = new Analyzer(keywordSearchList);
    return analyzer.calculateMetrics();
  }
}
