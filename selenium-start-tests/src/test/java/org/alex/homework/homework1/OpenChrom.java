package org.alex.homework.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenChrom {
  WebDriver wd;

  @BeforeMethod
  public void setUp() {
    wd = new ChromeDriver();

  }

  @Test
  public void openBrowser() {
    wd.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
    wd.findElement(By.id("pt-login")).click();
    wd.findElement(By.id("wpName1")).clear();
    wd.findElement(By.id("wpName1")).sendKeys("AlexeyAfanasev");
    wd.findElement(By.id("wpPassword1")).clear();
    wd.findElement(By.id("wpPassword1")).sendKeys("2e3r4t5y");
    wd.findElement(By.id("wpLoginAttempt")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }


}
