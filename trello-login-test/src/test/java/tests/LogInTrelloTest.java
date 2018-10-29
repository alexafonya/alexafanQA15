package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LogInTrelloTest extends TestBase{

    @Test

    public void testLogInTrello() throws InterruptedException {
        app.click(By.linkText("Log In"));
        app.logIn();
        app.click(By.linkText("Boards"));
        app.click(By.linkText("Create new board…"));
        app.type(By.className("subtle-input"), "My Board");
        app.click(By.className("primary"));
        Thread.sleep(3000);
        app.goToHomePage();

    }



}
