package org.addressbook.homework.tests.Cont.tests;

import org.addressbook.homework.tests.Cont.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @BeforeClass
    public void preconditions() {
        if (!app.getContacts().isContactPresent())
            app.getContacts().createContact();
        app.returnToHomePage();
    }

    @Test
    public void testContactModification() {
        int before = app.getContacts().getContactCount();
        app.getContacts().initContactModification();
        app.getContacts().fillFormContact(
                new Contacts()
                        .setAddress("Yalta")
                        .setFirstname("Vasya")
                        .setLastname("Pupkin")
                        .setMobile("0542334433")
                        .setEmail("vasya@gmail.com"));
        app.getContacts().submitContactModification();
        int after = app.getContacts().getContactCount();
        Assert.assertEquals(after,before);
    }

}
