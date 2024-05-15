package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableHandling {
    WebDriver driver;
    @BeforeClass
    void setUp() throws InterruptedException  {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("file:///Users/nashu/Desktop/Source_code/software_testing/DB-practices/Code/jdbc_demo/Selenium_Test/src/test/resources/table_handling.html");
        Thread.sleep(2000);
    }
    @Test
    void testTable() {
        // First let get the number or rows
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        //System.out.println(rows.size());
        for (WebElement row: rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for(WebElement col: cols) {
                System.out.print(col.getText() + "\t\t");
            }
            System.out.println();
        }
    }
    @AfterClass
    void terDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
