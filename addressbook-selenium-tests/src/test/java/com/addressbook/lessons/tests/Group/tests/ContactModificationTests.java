package com.addressbook.lessons.tests.Group.tests;

import com.addressbook.lessons.tests.Group.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @BeforeClass
    public void preconditions() {
        if (!app.getContacts().isContactPresent())
            app.getContacts().createContact();
        app.getNavigationHelper().returnToHomePage();
    }

    @Test
    public void testContactModification() {
        int before = app.getContacts().getCount();
        app.getContacts().initContactModification();
        app.getContacts().fillFormContact(
                new Contacts()
                        .setAddress("Gomel")
                        .setFirstname("Jeka")
                        .setLastname("Hropkin")
                        .setMobile("0542334433")
                        .setEmail("jenya@gmail.com"));
        app.getContacts().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
        int after = app.getContacts().getCount();
        Assert.assertEquals(after, before);
    }

}
