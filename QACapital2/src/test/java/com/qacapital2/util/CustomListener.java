package com.qacapital2.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomListener implements ITestListener {
    private FileWriter writer;

    public CustomListener() {
        String fileName = "custom-report.html";
        try {
            writer = new FileWriter(fileName, true);
            writer.write("<html><head><title>Test Report</title></head><body>");
            writer.write("<h1>Test Execution Report</h1>");
            writer.write("<table border='1' style='width:100%'>");
            writer.write("<tr><th>Test Name</th><th>Status</th><th>Time</th></tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logTestResult(result, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logTestResult(result, "FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logTestResult(result, "SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            writer.write("</table></body></html>");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test Execution Completed");
    }

    private void logTestResult(ITestResult result, String status) {
        try {
            String testName = result.getName();
            String time = new SimpleDateFormat("HH:mm:ss").format(new Date(result.getEndMillis()));
            writer.write("<tr><td>" + testName + "</td><td>" + status + "</td><td>" + time + "</td></tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    public void onStart(ITestContext context) {}
}