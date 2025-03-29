package org.example;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LoadQueries {

    public List<String> loadQueries(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Ошибка: файл запросов не найден.");
            return null;
        }

        try (InputStream queriesStream = new FileInputStream(file)) {
            long queriesReadStartTime = System.currentTimeMillis();
            List<String> queries = new BufferedReader(new InputStreamReader(queriesStream))
                    .lines().collect(Collectors.toList());
            long queriesReadTime = System.currentTimeMillis() - queriesReadStartTime;
            System.out.println("Время чтения запросов: " + queriesReadTime + " миллисекунд");
            return queries;
        }
    }
}
