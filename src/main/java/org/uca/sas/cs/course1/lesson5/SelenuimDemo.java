package org.uca.sas.cs.course1.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class SelenuimDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();
        driver.get("http://www.google.com/");
//        driver.get("https://www.google.com/search?q=selenium");
//        driver.get("https://artoftesting.com/sampleSiteForSelenium");
//        driver.manage().window().maximize();
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("selenium");
        inputField.submit();

        List<WebElement> results = driver.findElements(By.tagName("a"));
//        List<WebElement> results = driver.findElements(By.cssSelector("div.g a"));
        System.out.println(results.size());

        for (WebElement element : results) {
            String link = element.getAttribute("href");
            System.out.println(link);
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
