package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationSteps {
    WebDriver driver;

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        driver = new ChromeDriver();

        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }
}
