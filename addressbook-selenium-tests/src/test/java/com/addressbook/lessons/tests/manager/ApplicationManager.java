package com.addressbook.lessons.tests.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    NavigationHelper navigationHelper;
    public WebDriver wd;
    GroupHelper groupHelper;
    SessionHelper sessionHelper;
    ContactsHelper contacts;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void start() {
        if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX )){
            wd = new FirefoxDriver();
        } else if(browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        }else if(browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

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
