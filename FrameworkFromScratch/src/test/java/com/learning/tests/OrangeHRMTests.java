package com.learning.tests;

import com.learning.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

public final class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {
    }

    @Test
    public void loginLogout(HashMap<String, String> data) throws InterruptedException {
        String title = new OrangeHRMLoginPage()
                .enterUsername(data.get("UserName"))
                .enterPassword(data.get("Password"))
                .clickLogin()
                .logoutPage()
                .getTitle();

        Assertions.assertThat(title).isEqualTo("OrangeHRM");
    }

    @Test
    public void searchValue(HashMap<String, String> data) {
        String topSearchResult = new OrangeHRMLoginPage()
                .enterUsername(data.get("UserName"))
                .enterPassword("admin123")
                .clickLogin()
                .searchTab(data.get("SearchValue"))
//                .searchTab(data.get("searchValue"))
                .getTopSearchTabList();

        Assertions.assertThat(topSearchResult).contains(data.get("SearchValue"));
    }


//    @Test(priority = 1, alwaysRun = true, enabled = true, dataProvider = "getTestDataFromDataProvider")
//    public void loginLogout(String username, String password) throws InterruptedException {
//
//        String title = new OrangeHRMLoginPage()
//                .enterUsername(username)
//                .enterPassword(password)
////                .enterUsername("Admin")
////                .enterPassword("admin123")
//                .clickLogin()
//                .logoutPage()
//                .getTitle();
//
//        Assertions.assertThat(title).isEqualTo("OrangeHRM");
//    }
//
//
//    //    @Test(priority = 2, dataProvider = "getTestDataFromDataProvider")
//    public void searchValue(String username, String searchValue) {
//        String topSearchResult = new OrangeHRMLoginPage()
//                .enterUsername(username)
//                .enterPassword("admin123")
//                .clickLogin()
//                .searchTab(searchValue)
//                .getTopSearchTabList();
//
//        Assertions.assertThat(topSearchResult).contains(searchValue);
//    }
//    @Test(priority = 3)
//    @Parameters({"username", "password"})
//    public void addEmployee(String username, String password) throws InterruptedException {
//        new OrangeHRMLoginPage()
//                .enterUsername(username)
//                .enterPassword(password)
//                .clickLogin()
//                .clickAdminLink();
//    }

    @DataProvider(parallel = true)
    public Object[][] getTestDataFromDataProvider(Method m) {
        if (m.getName().equalsIgnoreCase("loginLogout")) {
            return new Object[][]{
                    {"Admin", "admin123"}
            };
        } else {
            return new Object[][]{
                    {"Admin", "Admin"},
                    {"Admin", "Leave"},
                    {"Admin", "PIM"}
            };

        }
    }

//    @DataProvider()
//    public Object[][] getTestDataForSearchInputField() {
//        //test data Admin, PIM, Leave
//        return new Object[][]{  // username and search values
//                {"Admin", "Admin"},
//                {"Admin", "Leave"},
//                {"Admin", "PIM"}
//        };
//    }


}
