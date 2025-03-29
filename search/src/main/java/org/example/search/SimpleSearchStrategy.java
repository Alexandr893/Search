package org.example.search;

import org.example.report.Report;

import java.util.*;

public class SimpleSearchStrategy implements SearchStrategy {

    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList("и", "в", "на", "с", "а", "из", "к", "от", "до", "у", "об", "по"));

    private boolean isStopWord(String word) {
        return STOP_WORDS.contains(word);
    }

    @Override
    public List<String> search(List<Report> reports, String query) {
        List<String> resultGuids = new ArrayList<>();

        String[] queryWords = query.toLowerCase().split("\\s+");

        for (Report report : reports) {
            String description = report.getDescription().toLowerCase();
            int matchCount = 0;

            for (String word : queryWords) {
                if (description.contains(word)&&!isStopWord(word)) {
                    matchCount++;
                }
            }
            if (matchCount >= queryWords.length / 2) {
                resultGuids.add(report.getGuid());
            }

                System.out.println("Запрос: " + query);
                System.out.println("Текущая проверка отчета: " + report.getGuid());
                System.out.println("Описание: " + report.getDescription());
                System.out.println("Число совпадений: " + matchCount);
        }

        return resultGuids;
    }
}
