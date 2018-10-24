package com.addressbook.lessons.tests.Group;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");
        //login
        login("admin", "secret");
    }

    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.cssSelector("input[type='submit']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
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

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void openGroupsPage() {
        click(By.cssSelector("a[href='group.php']"));
    }

    public void stop() {
        wd.quit();
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

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void deleteGroup() {

        click(By.cssSelector("[name='delete']:nth-child(2)"));
    }

    public void createGroup() {
        submitGroupCreation();
        returnToGroupsPage();
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
}
