package com.addressbook.lessons.tests.tests;

import com.addressbook.lessons.tests.model.Group;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator <Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split=line.split(";");
            list.add(new Object[]{new Group()
                    .setGroupName(split[0])
                    .setGroupHeader(split[1])
                    .setGroupFooter(split[2])});
            line = reader.readLine();
        }



//        list.add(new Object[]{"test1","header1","footer1"});
//        list.add(new Object[]{"test2","header2","footer2"});
//        list.add(new Object[]{"t","h","f"});
//        list.add(new Object[]{"tH","hf","ft"});
//        list.add(new Object[]{"toooop","heeeeeeeeeeed","fooooooooot"});

        return list.iterator();

    }


    @Test(dataProvider = "validGroups")
    public void testGroupCreation(Group group) {
        app.getGroupHelper().openGroupsPage();
        int before = app.getGroupHelper().getCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getCount();
        Assert.assertEquals(after, before + 1);
        app.getNavigationHelper().returnToHomePage();
    }


}
