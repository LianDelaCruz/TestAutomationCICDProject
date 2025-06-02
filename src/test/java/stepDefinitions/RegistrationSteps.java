package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class RegistrationSteps {

    WebDriver driver;

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        //This code lets Selenium Manager handle ChromeDriver.
        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @When("I fill in First Name with {string}")
    public void iFillInFirstNameWith(String firstName) {
        driver.findElement(By.name("Forename")).sendKeys(firstName);
    }

    @And("I fill in Last Name with {string}")
    public void iFillInLastNameWith(String lastName) {
        driver.findElement(By.id("member_lastname")).sendKeys(lastName);
    }

    @And("I fill in Email with {string}")
    public void iFillInEmailWith(String email) {
        driver.findElement(By.name("EmailAddress")).sendKeys(email);
    }

    @And("I fill in Confirm Email with {string}")
    public void iFillInConfirmEmailWith(String confirmEmail) {
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(confirmEmail);
    }

    @And("I fill in Password with {string}")
    public void iFillInPasswordWith(String password) {
        driver.findElement(By.name("Password")).sendKeys(password);
    }

    @And("I fill in Confirm Password with {string}")
    public void iFillInConfirmPasswordWith(String confirmPassword) {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirmPassword);
    }
    //I have pointed it to the checkbox itself
    @And("I accept the Terms and Conditions")
    public void iAcceptTheTermsAndConditions() {
        driver.findElement(By.cssSelector("label[for='sign_up_25']")).click();
    }

    @And("I accept the Age Confirmation")
    public void iAcceptTheAgeConfirmation() {
        driver.findElement(By.cssSelector("label[for='sign_up_26']")).click();

    }

    @And("I accept Communications Preferences")
    public void iAcceptCommunicationsPreferences() {
        driver.findElement(By.cssSelector("label[for='sign_up_27']")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_28']")).click();
    }

    @And("I accept the Code of Ethics")
    public void iAcceptTheCodeOfEthics() {
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        driver.findElement(
                By.cssSelector("input[type='submit'][value='CONFIRM AND JOIN']")
        ).click();
    }

    @Then("I should see confirmation of successful registration")
    public void iShouldSeeConfirmationOfSuccessfulRegistration() {
        //This is the confirmation url
        String currentUrl = driver.getCurrentUrl();
        assertTrue(
                "Expected registration confirmation URL to contain 'SignUpConfirmation'",
                currentUrl.contains("SignUpConfirmation")
        );
        driver.quit();
    }
}
