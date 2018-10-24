package com.addressbook.lessons.tests.Group.tests;

import com.addressbook.lessons.tests.Group.model.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getGroupHelper().openGroupsPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup();
        }
    }

    @Test
    public void testGroupModification() {
        app.getGroupHelper().openGroupsPage();
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupName("Modifico")
                .setGroupHeder("heder2")
                .setGroupFooter("chenged"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after,before);

    }


}
