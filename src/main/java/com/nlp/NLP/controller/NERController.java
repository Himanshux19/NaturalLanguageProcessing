package com.nlp.NLP.controller;

import com.nlp.NLP.model.Type;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "https://nlpextractor.netlify.app/")
@RestController
@RequestMapping("/api/v1")
public class NERController {

    @Autowired
    private StanfordCoreNLP stanfordCoreNLP;

    @PostMapping("/ner")
    public Set<String> ner(@RequestBody final String input, @RequestParam final Type type) {
        if (input == null || input.trim().isEmpty()) {
            return Collections.emptySet();
        }
        String processedInput = capitalizeText(input);
        CoreDocument document = new CoreDocument(processedInput);
        stanfordCoreNLP.annotate(document);
        List<CoreLabel> coreLabels = document.tokens();
        return new HashSet<>(collectList(coreLabels, type));
    }

    private List<String> collectList(List<CoreLabel> coreLabels, final Type type) {

        return coreLabels
                .stream()
                .filter(coreLabel -> type.getName().equalsIgnoreCase(coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class)))
                .map(CoreLabel::originalText)
                .collect(Collectors.toList());
    }

    private String capitalizeText(String input) {
        String[] words = input.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z@.]", "");
            if (cleanWord.length() > 0) {
                result.append(Character.toUpperCase(cleanWord.charAt(0)))
                        .append(cleanWord.substring(1).toLowerCase());
            }

            result.append(" ");
        }
        return result.toString().trim();
    }
}
