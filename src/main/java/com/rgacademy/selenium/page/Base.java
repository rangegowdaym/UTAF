package com.rgacademy.selenium.page;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Base {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    private void init() {
        this.driver.manage().window().maximize();
        PageFactory.initElements(this.driver, this);
    }

    public abstract boolean isAt();

    @PreDestroy
    private void teardown() {
        if (this.driver != null) {
            this.driver.close();
            this.driver.quit();
        }
    }
}
