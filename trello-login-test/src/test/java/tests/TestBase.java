package tests;

import manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    ApplicationManager app;
    WebDriver wd;

    @BeforeClass

    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        app = new ApplicationManager(wd);
        app.openSite();

    }

    @AfterClass

    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        wd.quit();
    }


}
