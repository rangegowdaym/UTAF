package com.rgacademy.selenium.googleTest;

import com.rgacademy.selenium.SpringBaseTestNGTest;
import com.rgacademy.selenium.autoframe.annotation.LazyAutowired;
import com.rgacademy.selenium.autoframe.service.ScreenshotService;
import com.rgacademy.selenium.page.google.GooglePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google1Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test(priority = 0, description = "Google Search Test")
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt(), "Google page is not loaded!");

        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt(), "Search result page is not loaded!");
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);

        this.screenshotService.takeScreenShot();
        this.googlePage.closeDriver();
    }

}
