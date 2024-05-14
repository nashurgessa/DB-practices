package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SauceDemoTest {
    
    private WebDriver driver;
    private WebDriverWait myWait;
    @BeforeClass
    void setUp() {
        driver = new EdgeDriver();
        myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void testSwagLabs() {
        WebElement userName = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
        userName.sendKeys("standard_user");
        WebElement password = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        password.sendKeys("secret_sauce");
        WebElement btnLogin = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        btnLogin.click();

        // Verify that after login, the URL changes to the inventory page
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @DataProvider(name="userCredentials")
    public static Object[][] getUserCredentials() throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader("/Users/nashu/Desktop/Source_code/software_testing/DB-practices/Code/jdbc_demo/Selenium_Test/src/test/resources/user_name_password.csv"));
        List<String[]> allRows = reader.readAll();
        // Remove the header, skip the first Line
        allRows.remove(0);
        // return the Array format new Object [# rows][]
        return allRows.toArray(new Object[allRows.size()][]);
    }

    // @DataProvider(name="userCredentials")
    @ParameterizedTest
    @CsvFileSource(resources = "/user_name_password.csv", numLinesToSkip = 1)
    void testUserCredentials() {
        //
    }

    @Test(dataProvider = "userCredentials")
    public void testLogin(String username, String password) throws InterruptedException {
        WebElement usernameField = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        //usernameField.sendKeys("");
        //usernameField.sendKeys(username);

        WebElement passwordField = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        //passwordField.sendKeys("");
        //passwordField.sendKeys(password);

        WebElement loginBtn = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        // loginBtn.click();

        if ("locked_out_user".equals(username)) {
            usernameField.clear();
            passwordField.clear();
            Thread.sleep(3000);
            usernameField.sendKeys(username);
            passwordField.sendKeys(password);

            loginBtn.click();

            WebElement errorMessage = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message-container.error")));
            System.out.println(errorMessage.getText());
            Assert.assertTrue(errorMessage.getText().contains("Sorry, this user has been locked out."),
                    "Expect error message for locked out user is not displayed");
        }
        //else if () {
        //    // ...
        //}
        else {
            // ...
        }
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }

}
