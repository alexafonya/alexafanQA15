package org.addressbook.homework.tests.Cont.manager;

import org.addressbook.homework.tests.Cont.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ContactsHelper {
    public WebDriver wd;

    public ContactsHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void initContactCreation() {
        wd.findElement(By.cssSelector("[href='edit.php']")).click();
    }

    public void submitContactCreation() {
        wd.findElement(By.cssSelector("[name='submit']:last-child")).click();
    }

    public void fillFormContact(Contacts contacts) {
        type(By.name("firstname"), contacts.getFirstname());
        type(By.name("lastname"), contacts.getLastname());
        type(By.name("address"), contacts.getAddress());
        type(By.name("mobile"), contacts.getMobile());
        type(By.name("email"), contacts.getEmail());
    }

    public void deleteContact() {
        wd.findElement(By.cssSelector("[value='Delete']")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void submitContactModification() {
        wd.findElement(By.cssSelector("[value='Update']:last-child")).click();
    }

    public void initContactModification() {
        wd.findElement(By.xpath("//a/img[@title='Edit']")).click();
    }

    public void createContact() {
        initContactCreation();
        fillFormContact(
                new Contacts()
                        .setAddress("Yalta")
                        .setFirstname("Vasya")
                        .setLastname("Pupkin")
                        .setMobile("0542334433")
                        .setEmail("vasya@gmail.com"));
        submitContactCreation();
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
