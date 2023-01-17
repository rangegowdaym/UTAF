package com.rgacademy.selenium.autoframe.config;

import com.rgacademy.selenium.autoframe.annotation.LazyConfiguration;
import com.rgacademy.selenium.autoframe.annotation.ThreadScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

@Profile("!remote")
@LazyConfiguration
public class WebDriverConfig {

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver chromeDriver() {
        return new ChromeDriver();
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        return new FirefoxDriver();
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "safari")
    public WebDriver safariDriver() {
        return new SafariDriver();
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver defaultDriver() {
        return new ChromeDriver();
    }
}
