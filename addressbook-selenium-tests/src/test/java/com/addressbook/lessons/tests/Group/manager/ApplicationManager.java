package com.addressbook.lessons.tests.Group.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;
    GroupHelper groupHelper;
    SessionHelper sessionHelper;
    ContactsHelper contacts;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite();
        contacts = new ContactsHelper(wd);
        groupHelper = new GroupHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public void returnToHomePage() {
        sessionHelper.click(By.xpath("//a[contains(text(),'home')]"));
    }

    public ContactsHelper getContacts() {
        return contacts;
    }

    public GroupHelper getGroupHelper() {

        return groupHelper;
    }


}
