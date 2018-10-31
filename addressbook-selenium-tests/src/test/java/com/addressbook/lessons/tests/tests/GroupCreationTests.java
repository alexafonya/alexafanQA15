package com.addressbook.lessons.tests.tests;

import com.addressbook.lessons.tests.model.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getGroupHelper().openGroupsPage();
        int before = app.getGroupHelper().getCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupName("test name")
                .setGroupHeder("chico")
                .setGroupFooter("Footer"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getCount();
        Assert.assertEquals(after, before + 1);
        app.getNavigationHelper().returnToHomePage();
    }


}
