package com.addressbook.lessons.tests.Group;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.openGroupsPage();
        int before = app.getGroupsCount();

        app.initGroupCreation();
        app.fillGroupForm(new Group()
                .setGroupName("test name")
                .setGroupHeder("chico")
                .setGroupFooter("Footer"));
        app.createGroup();

        int after = app.getGroupsCount();
        Assert.assertEquals(after, before + 1);
    }


}
