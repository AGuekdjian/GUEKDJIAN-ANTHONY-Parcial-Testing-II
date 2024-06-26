package com.tests;

import com.Pages.AccountActivityPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountActivityTest extends BaseTest {

    @Test
    public void testAccountActivity() {
        AccountActivityPage accountActivityPage = new AccountActivityPage(driver);

        accountActivityPage.goToAccountsOverview();
        Assertions.assertTrue(accountActivityPage.isBalanceIncludesTextPresent(), "*Balance includes deposits that may be subject to holds text not found");

        accountActivityPage.clickFirstAccount();
        Assertions.assertTrue(accountActivityPage.isAccountDetailsTitlePresent(), "Account Details title not found");

        accountActivityPage.selectMonth("All");
        accountActivityPage.selectTransactionType("All");
        accountActivityPage.clickGo();

    }
}