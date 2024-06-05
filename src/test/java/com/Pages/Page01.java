package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page01 extends BasePage {

    private By myAccountLink = By.cssSelector("body > footer > div > div > div:nth-child(4) > ul > li:nth-child(1) > a");

    private By register = By.cssSelector("a.btn.btn-primary[href='https://opencart.abstracta.us:443/index.php?route=account/register']");

    private By searchBoxFirstName = By.name("firstname");
    private By searchBoxLastName = By.name("lastname");
    private By searchBoxMail = By.name("email");
    private By searchPhone = By.name("telephone");
    private By searchBoxPass = By.name("password");
    private By searchConfirmPass = By.name("confirm");
    private By checkBoxPrivacyPolicy = By.name("agree");
    private By loginButtom = By.cssSelector("input[type='submit'][value='Continue'].btn.btn-primary");


    public Page01(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }


    public void completeFirstName(String firstName)  throws InterruptedException{
        this.sendText(firstName, searchBoxFirstName);
    }

    public void completeLastName(String lastName) throws InterruptedException{
        this.sendText(lastName, searchBoxLastName);
    }

    public void completeMail (String mail) throws InterruptedException{
        this.sendText(mail, searchBoxMail);
    }

    public void completePhone (String phone) throws InterruptedException{
        this.sendText(phone, searchPhone);
    }

    public void completePass (String pass) throws InterruptedException{
        this.sendText(pass,searchBoxPass);
    }

    public void completeRePass (String rePass) throws InterruptedException{
        this.sendText(rePass,searchConfirmPass);
    }

    public void clickPrivacyPolicy() throws InterruptedException{
        this.click(checkBoxPrivacyPolicy);
    }

    public void clickContinue() throws InterruptedException{
        this.click(loginButtom);
    }

    public void clickMyAcount() throws InterruptedException{
        this.click(myAccountLink);
    }

    public void clickRegister() throws InterruptedException{
        this.click(register);
    }
}