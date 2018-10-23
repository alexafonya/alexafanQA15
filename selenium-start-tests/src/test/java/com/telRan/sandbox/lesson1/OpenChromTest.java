package com.telRan.sandbox.lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenChromTest {
  WebDriver wd;

  @BeforeMethod
  public void setUp() {
    wd = new ChromeDriver();

  }

  @Test
  public void testOpenBrowser() {
    wd.navigate().to("https://www.google.com/");
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();

  }

}
