package com.addressbook.lessons.tests.Group;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup();
        }
    }

    @Test
    public void testGroupModification() {
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(new Group()
                .setGroupName("Modifico")
                .setGroupHeder("heder2")
                .setGroupFooter("chenged"));
        submitGroupModification();
        returnToGroupsPage();

    }

}
