package com.addressbook.lessons.tests.Group.tests;

import com.addressbook.lessons.tests.Group.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        int before = app.getContacts().getCount();
        app.getContacts().initContactCreation();
        app.getContacts().fillFormContact(
                new Contacts()
                        .setAddress("Yalta")
                        .setFirstname("Vasya")
                        .setLastname("Pupkin")
                        .setMobile("0542334433")
                        .setEmail("vasya@gmail.com"));
        app.getContacts().submitContactCreation();
        int after = app.getContacts().getCount();
        Assert.assertEquals(after, before + 1);
    }


}
