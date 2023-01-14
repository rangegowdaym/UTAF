package com.rgacademy.selenium.googleTest;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rgacademy.selenium.SpringBaseTestNGTest;
import com.rgacademy.selenium.page.google.GooglePage;
import com.rgacademy.selenium.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Google1Test extends SpringBaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt(), "Google page is not loaded!");

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt(), "Search result page is not loaded!");
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);

        this.screenShotUtil.takeScreenShot();
    }

}
