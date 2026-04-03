package com.nlp.NLP.controller;

import com.nlp.NLP.model.Type;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class NERController {

    @Autowired
    private StanfordCoreNLP stanfordCoreNLP;

    @PostMapping
    @RequestMapping(value = "/ner")
    public Set<String> ner(@RequestBody final String input, @RequestParam final Type type) {

        CoreDocument document = new CoreDocument(input);
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
}
