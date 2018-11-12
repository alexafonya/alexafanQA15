package com.addressbook.lessons.tests.tests;

import com.addressbook.lessons.tests.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
   protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.IE));

    @BeforeSuite
    public void setUp() {
        app.start();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        app.stop();
    }

}
