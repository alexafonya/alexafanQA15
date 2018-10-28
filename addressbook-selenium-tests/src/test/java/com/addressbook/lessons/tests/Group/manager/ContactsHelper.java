package com.addressbook.lessons.tests.Group.manager;

import com.addressbook.lessons.tests.Group.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsHelper extends HelperBase{

    public ContactsHelper(WebDriver wd) {
        super(wd);
    }



    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.cssSelector("[name='submit']:last-child"));
    }

    public void fillFormContact(Contacts contacts) {
        type(By.name("firstname"), contacts.getFirstname());
        type(By.name("lastname"), contacts.getLastname());
        type(By.name("address"), contacts.getAddress());
        type(By.name("mobile"), contacts.getMobile());
        type(By.name("email"), contacts.getEmail());
    }

    public void deleteContact() {
        click(By.cssSelector("[value='Delete']"));
    }


    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void submitContactModification() {
        click(By.cssSelector("[value='Update']:last-child"));
    }

    public void initContactModification() {
        click(By.xpath("//a/img[@title='Edit']"));
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



    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }


}
