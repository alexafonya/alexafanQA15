package org.addressbook.homework.tests.Cont.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletionContactTests extends TestBase {

    @BeforeClass
    public void preconditions(){
        if(!app.getContacts().isContactPresent())
            app.getContacts().createContact();
            app.returnToHomePage();

    }

    @Test
    public void testContactDelition() {
        int before = app.getContacts().getContactCount();
        app.getContacts().initContactModification();
        app.getContacts().deleteContact();
        int after = app.getContacts().getContactCount();
        Assert.assertEquals(after,before-1);
    }

}
