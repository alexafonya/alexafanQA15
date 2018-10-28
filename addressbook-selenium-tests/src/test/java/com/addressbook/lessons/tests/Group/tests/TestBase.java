package com.addressbook.lessons.tests.Group.tests;

import com.addressbook.lessons.tests.Group.manager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() {
        app.start();
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }

}
