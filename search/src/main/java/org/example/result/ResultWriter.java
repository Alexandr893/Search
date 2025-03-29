package org.example.result;

import java.io.IOException;
import java.util.Map;

public interface ResultWriter {
    void writeResults(String filePath, long initTime, Map<String, Result> results) throws IOException;
}
