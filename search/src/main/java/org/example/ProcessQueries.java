package org.example;
import org.example.result.Result;
import org.example.report.Report;
import org.example.search.SearchStrategy;
import org.example.search.SimpleSearchStrategy;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class ProcessQueries {

    SearchStrategy simpleSearchStrategy = new SimpleSearchStrategy();

    public Map<String, Result> processQueries(List<Report> reports, List<String> queries) {
        Map<String, Result> resultMap = new LinkedHashMap<>();
        for (String query : queries) {
            long searchStartTime = System.currentTimeMillis();
            List<String> results = simpleSearchStrategy.search(reports, query);
            long searchTime = System.currentTimeMillis() - searchStartTime;
            resultMap.put(query, new Result(query, results, searchTime));
            System.out.println("Время поиска для запроса '" + query + "': " + searchTime + " миллисекунд");
        }
        return resultMap;
    }

}
