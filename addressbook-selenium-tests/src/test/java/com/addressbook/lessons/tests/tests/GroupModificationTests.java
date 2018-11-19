package com.addressbook.lessons.tests.tests;

import com.addressbook.lessons.tests.model.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeClass
    public void preconditions() {
        app.getGroupHelper().openGroupsPage();
        if (!app.getGroupHelper().isGroupPresent())
            app.getGroupHelper().createGroup();

    }

    @Test
    public void testGroupModification() {
        app.getGroupHelper().openGroupsPage();
        int before = app.getGroupHelper().getCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupName("Modifico")
                .setGroupHeader("heder2")
                .setGroupFooter("chenged"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupHelper().getCount();
        Assert.assertEquals(after, before);
        app.getNavigationHelper().returnToHomePage();

    }


}
