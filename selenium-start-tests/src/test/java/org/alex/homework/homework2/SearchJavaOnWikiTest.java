package org.alex.homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchJavaOnWikiTest extends TestBase {

  @Test

  public void openingJavaOnWikipediaTest1() {
    //  Correct script:
    languageClick();
    rightJava();
    clickToSearch();
    Verify();
  }

  @Test
  public void openingJavaOnWikipediaTest2() {
    //  Invalid script:
    rightJava();
    clickToSearch();
    Verify();
  }


}
