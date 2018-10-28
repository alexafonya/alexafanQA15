package com.addressbook.lessons.tests.Group.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @BeforeClass
    public void preconditions() {
        app.getGroupHelper().openGroupsPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup();
        }
    }

    @Test
    public void testGroupDeletion() {
        app.getGroupHelper().openGroupsPage();
        int before = app.getGroupHelper().getCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getCount();
        Assert.assertEquals(before - 1, after);
    }

}
