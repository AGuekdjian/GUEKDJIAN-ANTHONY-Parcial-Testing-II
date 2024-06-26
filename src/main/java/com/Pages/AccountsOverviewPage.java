package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage extends BasePage {

    private By accountsOverviewLink = By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a");
    private By balanceText = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void openAccountsOverview() {
        click(accountsOverviewLink);
    }

    public String getBalanceText() {
        return getText(balanceText);
    }
}
