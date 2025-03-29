package org.example.result;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JSONResultWriter implements ResultWriter {
    @Override
    public void writeResults(String filePath, long initTime, Map<String, Result> results) throws IOException {
        JsonArray jsonArray = new JsonArray();

        results.forEach((query, searchResult) -> {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("search", query);
            jsonObject.add("result", convertListToJsonArray(searchResult.getResult()));
            jsonObject.addProperty("time", searchResult.getTime());
            jsonArray.add(jsonObject);
        });

        JsonObject output = new JsonObject();
        output.addProperty("initTime", initTime);
        output.add("result", jsonArray);


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter file = new FileWriter(filePath)) {
            gson.toJson(output, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON файл успешно создан: " + filePath);
    }


    private JsonArray convertListToJsonArray(List<String> list) {
        JsonArray jsonArray = new JsonArray();
        Set<String> uniqueGuids = new HashSet<>();
        for (String guid : list) {
            if (uniqueGuids.add(guid)) {
                jsonArray.add(guid);
            }
        }
        return jsonArray;
    }

}
