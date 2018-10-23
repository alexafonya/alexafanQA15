package org.alex.homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
  WebDriver wd;

  @BeforeMethod
  public void setUp(){
    wd = new ChromeDriver();
    wd.get("https://www.wikipedia.org/");

  }

  public void languageClick() {
    wd.findElement(By.id("searchLanguage")).click();
    wd.findElement(By.xpath("//option[@value='en']")).click();
  }

  public void clickToSearch() {
    wd.findElement(By.cssSelector("i.sprite.svg-search-icon")).click();
  }

  public void rightJava() {
    wd.findElement(By.id("searchInput")).click();
    wd.findElement(By.id("searchInput")).clear();
    wd.findElement(By.id("searchInput")).sendKeys("java");
  }

  @AfterMethod
  public void tearDown(){
    //wd.quit();
  }

  public void Verify() {
    String currentUrl = wd.getCurrentUrl();
    Assert.assertEquals(currentUrl, "https://en.wikipedia.org/wiki/Java");
  }
}
