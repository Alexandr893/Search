package org.example;

import org.example.report.Report;
import org.example.result.JSONResultWriter;
import org.example.result.ResultWriter;
import org.example.result.Result;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String dataResourcePath = "src/main/data/test.csv";
        String inputResourcePath = "src/main/temp/input1.txt";
        String outputFilePath = "src/main/temp/result1.json";

        LoadReports loadReports = new LoadReports();
        LoadQueries loadQueries = new LoadQueries();
        ProcessQueries processQueries = new ProcessQueries();
        ResultWriter resultWriter = new JSONResultWriter();

        long programStartTime = System.currentTimeMillis();

        try {

            List<Report> reports = loadReports.loadReports(dataResourcePath);
            List<String> queries = loadQueries.loadQueries(inputResourcePath);

            if (reports == null || queries == null) {
                System.err.println("Ошибка: один или несколько входных файлов не обработаны.");
                return;
            }

            long initTime = System.currentTimeMillis() - programStartTime;
            System.out.println("Время инициализации: " + initTime + " миллисекунд");

            Map<String, Result> resultMap = processQueries.processQueries(reports, queries);

            resultWriter.writeResults(outputFilePath, initTime, resultMap);
            System.out.println("Результаты успешно записаны в " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Ошибка при обработке файлов: " + e.getMessage());
        } finally {
            printProgramDuration(programStartTime);
        }
    }

    private static void printProgramDuration(long programStartTime) {
        long programEndTime = System.currentTimeMillis();
        long programTotalTime = programEndTime - programStartTime;
        System.out.println("Общее время работы программы: " + programTotalTime + " миллисекунд");
    }
}

