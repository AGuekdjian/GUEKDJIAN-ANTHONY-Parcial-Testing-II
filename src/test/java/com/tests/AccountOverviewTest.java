package com.tests;

import com.Pages.AccountsOverviewPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountOverviewTest extends BaseTest {

    @Test
    public void testAccountsOverview() {
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
        accountsOverviewPage.openAccountsOverview();
        String balanceText = accountsOverviewPage.getBalanceText();
        Assertions.assertTrue(balanceText.contains("*Balance includes deposits that may be subject to holds"));
    }
}
