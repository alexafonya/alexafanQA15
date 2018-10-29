package com.addressbook.lessons.tests.Group.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void openSite() {
        wd.get("http://localhost/addressbook");
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.cssSelector("input[type='submit']"));
    }



}
