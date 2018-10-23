package org.addressbook.homework.tests.Cont;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @BeforeClass
    public void preconditions() {
        if (!isContactPresent())
            createContact();
        returnToHomePage();
    }

    @Test
    public void testContactModification() {
        initContactModification();
        fillFormContact(
                new Contacts()
                        .setAddress("Yalta")
                        .setFirstname("Vasya")
                        .setLastname("Pupkin")
                        .setMobile("0542334433")
                        .setEmail("vasya@gmail.com"));
        submitContactModification();
    }

}
