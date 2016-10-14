package com.apress.springenterpriserecipes.report;

public class ReportService {

    private ReportGenerator reportGenerator;

    public ReportService() {}

    public ReportService(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void setReportGenerator(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void generateAnnualReport(int year) {
        String[][] statistics = null;
        //
        // Gather statistics for the year ...
        //
        reportGenerator.generate(statistics);
    }

    public void generateMonthlyReport(int year, int month) {
        String[][] statistics = null;
        //
        // Gather statistics for the month ...
        //
        reportGenerator.generate(statistics);
    }

    public void generateDailyReport(int year, int month, int day) {
        String[][] statistics = null;
        //
        // Gather statistics for the day ...
        //
        reportGenerator.generate(statistics);
    }
}
