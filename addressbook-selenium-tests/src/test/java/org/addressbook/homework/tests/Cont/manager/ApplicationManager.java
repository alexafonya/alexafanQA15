package org.addressbook.homework.tests.Cont.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private ContactsHelper contacts;
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");
        contacts = new ContactsHelper(wd);
        login("admin", "secret");
    }

    public void login(String userName, String password) {
        contacts.type(By.name("user"), userName);
        contacts.type(By.name("pass"), password);
        wd.findElement(By.cssSelector("input[type='submit']")).click();
    }

    public void stop() {
        wd.quit();
    }

    public void returnToHomePage() {
        wd.findElement(By.xpath("//a[contains(text(),'home')]")).click();
    }

    public ContactsHelper getContacts() {
        return contacts;
    }
}
