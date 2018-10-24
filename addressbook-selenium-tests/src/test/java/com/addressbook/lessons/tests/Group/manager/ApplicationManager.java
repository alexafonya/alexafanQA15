package com.addressbook.lessons.tests.Group.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private GroupHelper groupHelper;
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");
        //login
        groupHelper = new GroupHelper(wd);
        login("admin", "secret");

    }

    public void login(String username, String password) {
        groupHelper.type(By.name("user"), username);
        groupHelper.type(By.name("pass"), password);
        groupHelper.click(By.cssSelector("input[type='submit']"));
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
