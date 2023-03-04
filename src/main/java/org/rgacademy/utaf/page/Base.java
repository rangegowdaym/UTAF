package org.rgacademy.utaf.page;

import org.rgacademy.utaf.autoframe.config.WebDriverWaitConfig;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Base {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @Autowired
    protected WebDriverWaitConfig webDriverWaitConfig;

    @PostConstruct
    private void init() {
        this.driver.manage().window().maximize();
        PageFactory.initElements(this.driver, this);
    }

    public abstract boolean isAt();

    public void closeDriver() {
        Capabilities cap = ((RemoteWebDriver) this.driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        if (this.driver != null) {
            this.driver.close();
            if (!browserName.equalsIgnoreCase("firefox")) {
                this.driver.quit();
            }
        }
    }
}
