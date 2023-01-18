package com.rgacademy.selenium.autoframe.aop;

import com.rgacademy.selenium.autoframe.annotation.Window;
import com.rgacademy.selenium.autoframe.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService switchService;

    @Before("@target(window) && within(com.rgacademy.selenium..*)")
    public void before(Window window){
        this.switchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.rgacademy.selenium..*)")
    public void after(Window window){
        this.switchService.switchByIndex(0);
    }
}
