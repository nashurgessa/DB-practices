package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    void testOpenBrowser() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.baidu.com");
        Thread.sleep(3000); // Wait for 3 seconds
        // //*[@id="kw"]
        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
        Thread.sleep(2000); // Wait for 2 seconds

        textArea.sendKeys("Neusoft Institute Guangdong");
        Thread.sleep(3000);

        textArea.sendKeys(Keys.ENTER);
        Thread.sleep(4000); // Waits for 4 seconds
        driver.quit();
    }

}
