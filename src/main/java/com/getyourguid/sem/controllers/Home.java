package com.getyourguid.sem.controllers;

import com.getyourguid.sem.anaylzers.Analyzer;
import com.getyourguid.sem.models.KeywordSearch;
import com.getyourguid.sem.utils.Parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
/**
 * Created by abshahin on 5/15/18.
 */
@Controller
public class Home {

  @Autowired
  Parser CSVfileParser;

  @Value("upload.path")
  private String uploadedFolderPath;

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping({"/analysis"})
  public String analysis(Model model, @RequestParam(value="fileName", required=true) String fileName) throws IOException {
    List<KeywordSearch> keywordSearchList = CSVfileParser.extract(uploadedFolderPath + fileName);
    Analyzer analyzer = new Analyzer(keywordSearchList);
    model.addAttribute("companies", analyzer.calculateMetrics());
    model.addAttribute("sortedMap", analyzer.sortCompaniesPerformace());
    return "analysis";
  }

  @PostMapping("/upload")
  public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                 RedirectAttributes redirectAttributes) {

    if (file.isEmpty()) {
      redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
      return "redirect:uploadStatus";
    }

    String fileName = new java.util.Date().getTime() + file.getOriginalFilename();
    try {
      byte[] bytes = file.getBytes();

      Path path = Paths.get(uploadedFolderPath + fileName);
      Files.write(path, bytes);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "redirect:/analysis?fileName="+fileName;
  }
}
