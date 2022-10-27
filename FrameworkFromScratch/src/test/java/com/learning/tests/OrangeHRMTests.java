package com.learning.tests;

import com.learning.pages.OrangeHRMHomePage;
import com.learning.pages.OrangeHRMLoginPage;
import org.testng.annotations.Test;

public final class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {
    }

    @Test
    public void loginLogout() throws InterruptedException {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
        Thread.sleep(5000);
//        loginPage.enterUsername("Admin");
//        loginPage.enterPassword("admin123");
//        loginPage.clickLogin();
//        loginPage.enterUsername("Admin").enterPassword("admin123").clickLogin();

//        OrangeHRMHomePage homePage = new OrangeHRMHomePage();
//        homePage.clickAddEmployee();

        loginPage.enterUsername("Admin").enterPassword("admin123").clickLogin().clickAddEmployee();
    }

}
