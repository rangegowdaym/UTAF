package com.rgacademy.selenium.autoframe.service;

import com.rgacademy.selenium.autoframe.annotation.LazyAutowired;
import com.rgacademy.selenium.autoframe.config.WebDriverWaitConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WindowSwitchService {

    @Autowired
    private ApplicationContext ctx;

    @LazyAutowired
    private WebDriverWaitConfig webDriverWaitConfig;

    public void switchByTitle(final String windowTitle) {
        WebDriver driver = this.ctx.getBean(WebDriver.class);
        driver.getWindowHandles().stream().map(handle -> driver.switchTo().window(handle).getTitle())
                .filter(title -> title.startsWith(windowTitle)).findFirst().orElseThrow(() -> {
            throw new RuntimeException("No such window opened");
        });
    }

    public void switchByIndex(final int index) {
        WebDriver driver = this.ctx.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[index]);
    }

    public WebDriver createNewWindow(WindowType windowType) {
        WebDriver driver = this.ctx.getBean(WebDriver.class);
        return driver.switchTo().newWindow(windowType);
    }

    public void switchToFrame(WebElement element) {
        WebDriver driver = this.ctx.getBean(WebDriver.class);
        webDriverWaitConfig.webDriverWait(driver).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }
}
