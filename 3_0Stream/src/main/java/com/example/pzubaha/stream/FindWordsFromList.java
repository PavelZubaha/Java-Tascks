package com.example.pzubaha.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Task:
 * Create a stream that will detect bad words in a text according to a bad words list.
 * All words in the text are divided by whitespaces (always only one whitespace between two words).
 *
 * After calling collect(Collectors.toList())
 * the stream must return the list of bad words which were found in the text.
 * The result should be dictionary ordered (in lexicographical order, i.e. sorted)
 * and bad words shouldn't repeat.
 *
 * Use ignore case comparison. Take into consideration punctuation marks.
 *
 * Important. You need return a prepared stream from the template method,
 * not a list of bad words. Pay attention to the method template.
 * Do not change it!
 * Template:
 * public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
 *         return // code here;
 *     }
 */

public class FindWordsFromList {
    public static void main(String[] args) {
        List<String> badList = Arrays.asList("a", "b", "c", "x", "sd");
        String text = "c, sd, fsfg hfshfks A a. d. x";
        System.out.println(createBadWordsDetectingStream(text, badList).collect(Collectors.toList()));
    }

    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        return Stream.of(text.split("\\S\\s")).
                filter(s -> badWords.stream().anyMatch(s::equalsIgnoreCase)).
                sorted(String::compareToIgnoreCase).distinct();
    }
}
