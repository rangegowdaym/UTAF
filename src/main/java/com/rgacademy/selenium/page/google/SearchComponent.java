package com.rgacademy.selenium.page.google;

import com.rgacademy.selenium.autoframe.annotation.PageFragment;
import com.rgacademy.selenium.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchComponent extends Base {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchButtons;

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }

    public void search(final String keyword) {
        this.searchBox.clear();
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchButtons
                .stream()
                .filter(webElement -> webElement.isDisplayed() && webElement.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
