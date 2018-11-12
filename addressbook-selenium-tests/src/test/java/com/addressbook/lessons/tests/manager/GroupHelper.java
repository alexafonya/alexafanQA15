package com.addressbook.lessons.tests.manager;

import com.addressbook.lessons.tests.model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupsPage() {
        click(By.cssSelector("i>a[href='group.php']"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeder());
        type(By.name("group_footer"), group.getGroupFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }


    public void openGroupsPage() {
        click(By.linkText("groups"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void initGroupModification() {
        click(By.cssSelector("[name='edit']:nth-child(3)"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));

    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void deleteGroup() {

        click(By.cssSelector("[name='delete']:nth-child(2)"));
    }

    public void createGroup() {
        initGroupCreation();
        fillGroupForm(new Group()
                .setGroupName("test name")
                .setGroupHeder("chico")
                .setGroupFooter("Footer"));
        submitGroupCreation();
        returnToGroupsPage();
    }





}
