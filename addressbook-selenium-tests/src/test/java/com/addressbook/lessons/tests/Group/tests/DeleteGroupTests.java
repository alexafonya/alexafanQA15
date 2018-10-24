package com.addressbook.lessons.tests.Group.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteGroupTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getGroupHelper().openGroupsPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup();
        }
    }

    @Test
    public void testGroupDeletion() {
        app.getGroupHelper().openGroupsPage();
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(before-1,after);
    }

}
