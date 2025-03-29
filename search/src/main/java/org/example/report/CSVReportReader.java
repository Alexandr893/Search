package org.example.report;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReportReader implements ReportReader {
    @Override
    public List<Report> readReports(InputStream csvStream) throws IOException {
        List<Report> reports = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(csvStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    reports.add(new Report((parts[0].trim()), parts[1].trim(), parts[2].trim()));
                }
            }
        }
        return reports;
    }
}
