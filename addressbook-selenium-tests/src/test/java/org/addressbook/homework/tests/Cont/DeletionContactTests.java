package org.addressbook.homework.tests.Cont;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletionContactTests extends TestBase {

    @BeforeClass
    public void preconditions(){
        if(!isContactPresent())
            createContact();
            returnToHomePage();

    }

    @Test
    public void testContactDelition() {
        initContactModification();
        deleteContact();
    }

}
