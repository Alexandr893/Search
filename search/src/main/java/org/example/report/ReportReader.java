package org.example.report;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ReportReader {
    List<Report> readReports(InputStream csvStream) throws IOException;
}
