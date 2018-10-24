package org.addressbook.homework.tests.Cont.tests;

import org.addressbook.homework.tests.Cont.model.Contacts;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        int before = app.getContacts().getContactCount();
        app.getContacts().initContactCreation();
        app.getContacts().fillFormContact(
                new Contacts()
                        .setAddress("Yalta")
                        .setFirstname("Vasya")
                        .setLastname("Pupkin")
                        .setMobile("0542334433")
                        .setEmail("vasya@gmail.com"));
        app.getContacts().submitContactCreation();
        int after = app.getContacts().getContactCount();
        Assert.assertEquals(after,before+1);
    }



}
