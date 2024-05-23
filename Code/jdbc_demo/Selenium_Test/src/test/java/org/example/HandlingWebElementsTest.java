package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class HandlingWebElementsTest {

    WebDriver driver;

    @BeforeClass
    void setUp() throws InterruptedException {
        driver = new EdgeDriver();

        driver.get("file:///Users/nashu/Desktop/Source_code/software_testing/DB-practices/Code/jdbc_demo/Selenium_Test/src/test/resources/index.html");
        Thread.sleep(2000);

         // To maximize the window
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    void webElements() throws InterruptedException {
        // Test the link
        driver.findElement(By.linkText("Bing")).click();
        Thread.sleep(3000);
        // back to main page
        driver.navigate().back();
        Thread.sleep(2000);


        // Test the dropDrown
        // 1. Select by visible text
        Select colorType = new Select(driver.findElement(By.id("colorSelector")));
        colorType.selectByVisibleText("Green");
        Thread.sleep(2000);

        // 2. Select by value
        Select fruitType = new Select(driver.findElement(By.id("fruitSelector")));
        fruitType.selectByValue("orange");
        Thread.sleep(2000);

        //
        // TextField
        WebElement textField = driver.findElement(By.id("nameInput"));
        textField.sendKeys("Neusoft");
        Thread.sleep(2000);

        // RadioButton
        WebElement maleRadioButton = driver.findElement(By.xpath("/html/body/fieldset[1]/label[1]/input"));
        maleRadioButton.click();
        Thread.sleep(2000);

        WebElement femaleRadioButton = driver.findElement(By.xpath("/html/body/fieldset[1]/label[2]/input"));
        femaleRadioButton.click();
        Thread.sleep(2000);

        // Hobby Check box
        WebElement sportHobby =driver.findElement(By.xpath("/html/body/fieldset[2]/label[1]"));
        if (!sportHobby.isSelected()) {
            sportHobby.click();
        }
        Thread.sleep(2000);

        WebElement readingHobby =driver.findElement(By.xpath("/html/body/fieldset[2]/label[2]"));
        readingHobby.click();
        Thread.sleep(2000);

        // 3. Select by index
        Select countries = new Select(driver.findElement(By.id("countrySelect")));
        countries.selectByIndex(3);
        Thread.sleep(2000);

        // Button
        WebElement btnSubmit = driver.findElement(By.id("submitBtn"));
        btnSubmit.click();
        Thread.sleep(2000);
    }

    @AfterClass
    void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }

}
