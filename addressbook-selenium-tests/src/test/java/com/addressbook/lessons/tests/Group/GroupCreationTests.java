package com.addressbook.lessons.tests.Group;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        openGroupsPage();
        createGroup();

    }

}
