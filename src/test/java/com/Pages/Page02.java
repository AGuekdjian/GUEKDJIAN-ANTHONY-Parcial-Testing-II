package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page02 extends BasePage {
    private By searchBox = By.name("search");
    private By searchBtn = By.cssSelector("button[type='button'].btn.btn-default.btn-lg i.fa.fa-search");
    private By addCartBtn = By.cssSelector("div.button-group > button > i.fa.fa-shopping-cart");

    public Page02(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void search(String article) throws InterruptedException{
        this.sendText(article, searchBox);
        this.sendKey(Keys.ENTER, searchBox);
    }

    public void clickSearch() throws InterruptedException{
        this.click(searchBtn);
    }

    public void addCart() throws InterruptedException{
        this.click(addCartBtn);
    }
}