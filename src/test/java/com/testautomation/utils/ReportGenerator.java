package com.testautomation.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.Collections;

public class ReportGenerator {
    public static void generateReport() {
        File reportOutputDirectory = new File("target/cucumber-reports");
        java.util.List<String> jsonFiles = Collections.singletonList("target/cucumber-reports/cucumber.json");
        Configuration configuration = new Configuration(reportOutputDirectory, "TestAuto");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
