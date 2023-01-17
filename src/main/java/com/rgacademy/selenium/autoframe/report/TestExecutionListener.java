/*
package com.rgacademy.selenium.report;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestExecutionListener implements ITestListener {

    @Autowired
    protected WebDriver driver;
    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] saveScreenshot(String name, WebDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(result.getName(), driver);
    }
}
*/
