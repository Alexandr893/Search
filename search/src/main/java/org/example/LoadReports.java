package org.example;
import org.example.report.CSVReportReader;
import org.example.report.Report;
import org.example.report.ReportReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LoadReports {

    ReportReader reportReader = new CSVReportReader();

    public List<Report> loadReports(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Ошибка: файл отчетов не найден.");
            return null;
        }

        try (InputStream reportsStream = new FileInputStream(file)) {
            long csvReadStartTime = System.currentTimeMillis();
            List<Report> reports = reportReader.readReports(reportsStream);
            long csvReadTime = System.currentTimeMillis() - csvReadStartTime;
            System.out.println("Время чтения CSV: " + csvReadTime + " миллисекунд");
            return reports;
        }
    }
}