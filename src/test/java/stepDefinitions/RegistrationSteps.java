package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

import static org.junit.Assert.*;

public class RegistrationSteps {

    WebDriver driver;
    private String generatedEmail;

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
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

    @And("I leave Last Name blank")
    public void iLeaveLastNameBlank() {
    }

    @And("I fill in Date of Birth with {string}")
    public void iFillInDateOfBirthWith(String dob) {
        driver.findElement(By.id("dp")).sendKeys(dob);
    }

    @And("I fill in a unique Email address")
    public void iFillInAUniqueEmailAddress() {
        generatedEmail = "lian.dc+" + UUID.randomUUID() + "@example.com";
        driver.findElement(By.id("member_emailaddress")).sendKeys(generatedEmail);
    }

    @And("I fill in Confirm Email as the same unique address")
    public void iFillInConfirmEmailAsSameUniqueAddress() {
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(generatedEmail);
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
        // I chose to print out the contents of the confirmation page, so I have another guidance.
        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println("CONFIRMATION PAGE BODY = >>>\n" + bodyText);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("SignUpConfirmation"));

        String currentUrl = driver.getCurrentUrl();
        assertTrue(
                "Expected URL to contain '/SignUpConfirmation' but was: " + currentUrl,
                currentUrl.contains("SignUpConfirmation")
        );

        driver.quit();
    }


    @Then("I should see {string} error for field {string}")
    public void verifyFieldError(String expectedMessage, String fieldName) {
        String css = "span[data-valmsg-for='" + fieldName + "']";
        String actualMessage = driver.findElement(By.cssSelector(css)).getText().trim();
        assertEquals(expectedMessage, actualMessage);

        driver.quit();
    }

}
