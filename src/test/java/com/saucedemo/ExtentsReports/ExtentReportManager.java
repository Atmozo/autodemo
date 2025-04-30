package com.saucedemo.ExtentsReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {

    private static String Report_dir = System.getProperty("user.dir") + "/Reports/SauceDemo Report";

    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;

    public static ExtentReports extentSetup(){
        extentReports= new ExtentReports();
        extentSparkReporter= new ExtentSparkReporter(new File(Report_dir));
        extentReports.attachReporter((extentSparkReporter));

         extentSparkReporter.config().setDocumentTitle("Extent Report");
         extentSparkReporter.config().setTheme(Theme.DARK);
         extentSparkReporter.config().setReportName("Sauce Demo Report");
         extentReports.setSystemInfo("OS",System.getProperty("os.name"));
         extentReports.setSystemInfo("Execution",System.getProperty("user.name"));

         return extentReports;

    }






}
