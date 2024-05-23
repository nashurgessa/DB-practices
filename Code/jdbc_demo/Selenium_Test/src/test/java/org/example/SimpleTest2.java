package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SimpleTest2 {
    static WebDriver driver;
    @BeforeAll
    static void setup() throws InterruptedException {
        driver = new EdgeDriver();

        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
    }
    @Test
    void testKeyEnter() throws InterruptedException {
        // //*[@id="kw"]
        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
        Thread.sleep(2000); // Wait for 2 seconds

        textArea.sendKeys("Neusoft Institute Guangdong");
        Thread.sleep(3000);

        textArea.sendKeys(Keys.ENTER);
        Thread.sleep(4000); // Waits for 4 seconds
    }
    @AfterAll
    static void tearDown() {
        driver.quit();
    }

}
