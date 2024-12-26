package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import page.utils.CreateAccount;

public class CreateAccountSteps {

	WebDriver driver = null;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chrome.exe");

	}

	@SuppressWarnings("deprecation")
	@Given("User is on Create Account Page")
	public void user_is_on_create_account_page() {
		System.out.println("--------------Inside Step - CreatAccountPage----------------");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Create an Account")).click();

	}

	@Given("Enter the details")
	public void enter_the_details() {
		try {
			System.out.println("----------------Inside Step - Enter Details----------------");
			driver.findElement(By.name("firstname")).sendKeys("Kowsalaya1");
			driver.findElement(By.id("lastname")).sendKeys("Marimuthau1");
			driver.findElement(By.id("email_address")).sendKeys("kowsaalyaka@gmail.com");
			driver.findElement(By.id("password")).sendKeys("Kow$aly@18");
			driver.findElement(By.id("password-confirmation")).sendKeys("Kow$aly@18");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@When("I click create an Account")
	public void i_click_create_an_account() {
		try {
			System.out.println("-----------Inside Step - Cick Create Account----------------");
			driver.findElement(By.xpath(CreateAccount.createAnAccount)).click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("Account should create successfully")
	public void account_should_create_successfully() {
		try {
			System.out.println("---------------Inside Step - Verify the Created account-----------------------");
			String message;
			message = driver.findElement(By.xpath(CreateAccount.successMessage)).getText();
			System.out.println(message);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@And("Sign Out the Account")
	public void signOut() {

		try {
			driver.findElement(By.xpath(CreateAccount.selectWelcome)).click();
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("**Signed out successfully**");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
