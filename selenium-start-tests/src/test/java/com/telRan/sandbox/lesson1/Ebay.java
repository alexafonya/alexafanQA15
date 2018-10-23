package com.telRan.sandbox.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ebay {
  WebDriver wd;

  @BeforeMethod
  public void setUp() {
    wd = new ChromeDriver();

  }

  @Test
  public void openSiteTest() {
    wd.navigate().to("https://www.ebay.com/");
    wd.findElement(By.linkText("Sign in")).click();
    wd.findElement(By.name("userid")).clear();
    wd.findElement(By.name("userid"))
            .sendKeys("alex.afonya.84@gmail.com");
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("2e3r4t5y");
    wd.findElement(By.id("sgnBt")).click();
  }

  @AfterMethod
  public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
  }


}
