package com.addressbook.lessons.tests.Group.tests;

import com.addressbook.lessons.tests.Group.model.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getGroupHelper().openGroupsPage();
        int before = app.getGroupHelper().getGroupsCount();

        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupName("test name")
                .setGroupHeder("chico")
                .setGroupFooter("Footer"));
        app.getGroupHelper().createGroup();

        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before + 1);
    }


}
