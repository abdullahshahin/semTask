package com.getyourguid.sem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnalyzerApplication {
	private int maxUploadSizeInMb = 20 * 1024 * 1024; // 20 MB
	public static void main(String[] args) {
		SpringApplication.run(AnalyzerApplication.class, args);
	}
}
