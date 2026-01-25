package com.analyser.resumeanalyzer.service.analysersupport;

import java.util.*;
import java.util.stream.Collectors;


public class TextPreprocessor {
	 private static final List<String> STOPWORDS = Arrays.asList(
		        "the", "and", "is", "in", "to", "of", "a", "an", "for", "with", "on", "as", "by", "at"
		    );

		    public static Set<String> preprocess(String text) {
		        return Arrays.stream(text.toLowerCase().split("[\\s,;:.()\\[\\]\\-{}]+"))
		                .filter(token -> token.length() > 1 && !STOPWORDS.contains(token))
		                .collect(Collectors.toSet());
		    }
	
	
}
