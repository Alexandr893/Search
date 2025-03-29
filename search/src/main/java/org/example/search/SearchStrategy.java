package org.example.search;

import org.example.report.Report;

import java.util.List;

public interface SearchStrategy {
    List<String> search(List<Report> reports, String query);
}
