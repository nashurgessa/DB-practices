package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginSuccessTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // WebDriverManager.chromedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void testSuccessfulLogin() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        username.sendKeys("student");
        password.sendKeys("Password123");
        loginButton.click();

        WebElement logoutLink = driver.findElement(By.linkText("Log out"));
        assert logoutLink.isDisplayed();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
