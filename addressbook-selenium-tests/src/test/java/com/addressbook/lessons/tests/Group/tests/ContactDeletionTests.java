package com.addressbook.lessons.tests.Group.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @BeforeClass
    public void preconditions() {
        if (!app.getContacts().isContactPresent())
            app.getContacts().createContact();
        app.getNavigationHelper().returnToHomePage();

    }

    @Test
    public void testContactDeletion() {
        int before = app.getContacts().getCount();
        app.getContacts().initContactModification();
        app.getContacts().deleteContact();
        app.getNavigationHelper().returnToHomePage();
        int after = app.getContacts().getCount();
        Assert.assertEquals(after, before - 1);
    }

}
