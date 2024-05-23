package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginFailureTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // WebDriverManager.chromedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void testFailedLogin() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        username.sendKeys("student");
        password.sendKeys("wrongpassword");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("error"));
        assert errorMessage.getText().contains("Your password is invalid!");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}