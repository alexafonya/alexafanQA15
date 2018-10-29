package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplicationManager {

    WebDriver wd;

    public ApplicationManager(WebDriver wd) {
        this.wd = wd;
    }

    public void openSite() {
        wd.get("https://trello.com/");
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void logIn() {
        type(By.id("user"), "alex.afonya.84+1@gmail.com");
        type(By.id("password"), "2e3r4t5y");
        click(By.id("login"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void goToHomePage() {
        click(By.xpath("//a[@class='header-btn js-back-menu']"));
    }

}
