package com.learning.tests;

import com.learning.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

public final class HomepageTests extends BaseTest {

    private HomepageTests() {

    }

    @Test
    public void test3() {
        DriverManager.getDriver().findElement(By.xpath("//input[@name = 'q']")).sendKeys("test3", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();
        System.out.println(title);
        Assert.assertTrue(Objects.nonNull(title), " Verify if title is not null");   //check title non null
        Assert.assertTrue(title.toLowerCase().contains("google search"), "Verify if title contains google search");   // check if title contains google search
        Assert.assertTrue(title.length() > 15, " Verify if title length is more than 15");

        Assert.assertTrue(title.toLowerCase().matches("\\w.*" + "google search")); //w. is anything [a-zA-z0-9] , * is anything followed by it

        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));
        Assert.assertEquals(elements.size(), 10, "Verify number of links in page");

        //iterate through each link and validate if following link is present or not
        boolean isLinkPresent = false;
        for (WebElement elm : elements) {
            if (elm.getText().equalsIgnoreCase("test3 - YouTube")) {
                isLinkPresent = true;
                break;
            }
        }

        Assert.assertTrue(isLinkPresent, "Verify if link is present or not - test3 - YouTube");

    }
}
