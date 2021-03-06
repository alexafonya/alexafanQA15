package com.telRan.sandbox.lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenFirefoxTest {
  WebDriver wd;

  @BeforeMethod
  public void setUp() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

  }

  @Test
  public void openSiteTest() {
    wd.navigate().to("https://htmlacademy.ru/");
  }

  @AfterMethod
  public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
  }


}
