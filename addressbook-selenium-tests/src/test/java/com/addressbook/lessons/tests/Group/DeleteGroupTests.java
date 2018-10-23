package com.addressbook.lessons.tests.Group;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteGroupTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup();
        }
    }

    @Test
    public void testGroupDeletion() {
        openGroupsPage();
        selectGroup();
        deleteGroup();
        returnToGroupsPage();
    }

}
