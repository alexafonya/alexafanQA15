package com.addressbook.lessons.tests.Group.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    NavigationHelper navigationHelper;
    public WebDriver wd;
    GroupHelper groupHelper;
    SessionHelper sessionHelper;
    ContactsHelper contacts;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        navigationHelper.openSite("http://localhost/addressbook");
        contacts = new ContactsHelper(wd);
        groupHelper = new GroupHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }


    public ContactsHelper getContacts() {
        return contacts;
    }

    public GroupHelper getGroupHelper() {

        return groupHelper;
    }


    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
