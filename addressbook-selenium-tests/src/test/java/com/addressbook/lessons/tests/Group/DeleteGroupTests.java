package com.addressbook.lessons.tests.Group;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteGroupTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.openGroupsPage();
        if (!app.isGroupPresent()) {
            app.createGroup();
        }
    }

    @Test
    public void testGroupDeletion() {
        app.openGroupsPage();
        int before = app.getGroupsCount();
        app.selectGroup();
        app.deleteGroup();
        app.returnToGroupsPage();
        int after = app.getGroupsCount();
        Assert.assertEquals(before-1,after);
    }

}
