package com.tests;

import com.Pages.OpenAccountPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OpenAccountTest extends BaseTest {

    @Test
    @Tag("Open Account")
    public void testOpenNewAccount() {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.openNewAccount();
        openAccountPage.selectSavingsAccount();
        openAccountPage.submitOpenAccount();
        String successMessage = openAccountPage.getSuccessMessage();
        System.out.println("Success message: " + successMessage);
        Assertions.assertTrue(successMessage.contains("Congratulations, your account is now open."));
    }
}
