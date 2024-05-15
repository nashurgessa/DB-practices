package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        driver = new EdgeDriver();
        Thread.sleep(2000);

        driver.get("file:///Users/nashu/Desktop/Source_code/software_testing/DB-practices/Code/jdbc_demo/Selenium_Test/src/test/resources/table_handling.html");
        Thread.sleep(2000);

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

        if (driver != null) {
            driver.quit();
        }
    }
}