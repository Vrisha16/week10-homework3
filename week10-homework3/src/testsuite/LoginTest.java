package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void test1() {
        driver.get("http://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement welcomeMessage = driver.findElement(By.cssSelector(".flash.success"));
        String actualMessage = welcomeMessage.getText();
        String expectedMessage = "You logged into a secure area!";

        Assert.assertEquals(expectedMessage, actualMessage, "You logged into a secure area!");

    }

   /* @After
    public void tearDown() {
        closeBrowser();*/


    /* Write down the following test into ‘LoginTest’ class
 1. userSholdLoginSuccessfullyWithValidCredentials

 * Enter “tomsmith” username
 * Enter “SuperSecretPassword!” password

 * Click on ‘LOGIN’ button
 * Verify the text “Secure Area”*/
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.get("http://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement secureAreaText = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = secureAreaText.getText();
        String expectedText = "You logged into a secure area!";
        Assert.assertEquals(actualText, expectedText, "You logged into a secure area!");
    }

    /*verifyTheUsernameErrorMessage
* Enter “tomsmith1” username
* Enter “SuperSecretPassword!” password
* Click on ‘LOGIN’ button
* Verify the error message “Your username
is invalid!”*/
    @Test
    public void verifyTheUsernameErrorMessage() {
        driver.get("http://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys("tomsmith1");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Your password is invalid!×!";
        Assert.assertEquals("Verifying Username Error Message", expectedMessage, actualMessage);
    }

    /*verifyThePasswordErrorMessage
            * Enter “tomsmith” username
            * Enter “SuperSecretPassword” password
            * Click on ‘LOGIN’ button
            * Verify the error message “Your password

            is invalid!”*/
    @Test
    public void verifyThePasswordErrorMessage() {
        driver.get("http://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Your password is invalid!\n" +
                "×";
        Assert.assertEquals("Verifying Password Error Message", actualMessage, expectedMessage);
    }
}



















