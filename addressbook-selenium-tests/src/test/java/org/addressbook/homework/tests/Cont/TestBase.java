package org.addressbook.homework.tests.Cont;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("http://localhost/addressbook");
        login("admin", "secret");

    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        wd.findElement(By.cssSelector("input[type='submit']")).click();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void initContactCreation() {
        wd.findElement(By.cssSelector("[href='edit.php']")).click();
    }

    public void submitContactCreation() {
        wd.findElement(By.cssSelector("[name='submit']:last-child")).click();
    }

    public void fillFormContact(Contacts contacts) {
        type(By.name("firstname"), contacts.getFirstname());
        type(By.name("lastname"), contacts.getLastname());
        type(By.name("address"), contacts.getAddress());
        type(By.name("mobile"), contacts.getMobile());
        type(By.name("email"), contacts.getEmail());
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    public void deleteContact() {
        wd.findElement(By.cssSelector("[value='Delete']")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void submitContactModification() {
        wd.findElement(By.cssSelector("[value='Update']:last-child")).click();
    }

    public void initContactModification() {
        wd.findElement(By.xpath("//a/img[@title='Edit']")).click();
    }

    public void createContact() {
        initContactCreation();
        fillFormContact(
                new Contacts()
                        .setAddress("Yalta")
                        .setFirstname("Vasya")
                        .setLastname("Pupkin")
                        .setMobile("0542334433")
                        .setEmail("vasya@gmail.com"));
        submitContactCreation();
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isContactPresent(){
        return isElementPresent(By.name("selected[]"));
    }

    public void returnToHomePage() {
        wd.findElement(By.xpath("//a[contains(text(),'home')]")).click();
    }
}
