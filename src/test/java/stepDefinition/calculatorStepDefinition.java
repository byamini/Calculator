package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class calculatorStepDefinition {
	
	public static WebDriver driver;
	String expectedTitle="BMI Calculator" ;
	
	@Given("calculator url is launched")
	public void calculator_url_is_launched() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\003QHN744\\OneDrive\\Training\\Day3\\src\\test\\chromedriver.exe");
	    driver =new ChromeDriver();
	    driver.get("https://www.calculator.net");	
	}

	@When("user clicked on BMI calculator")
	public void user_clicked_on_BMI_calculator() {
	   driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//a[contains(text(),'BMI Calculator')]")).click();
	}

	@Then("check title of the page")
	public void check_title_of_the_page() {
		String actualTitle = driver.getTitle();
		if(expectedTitle.equalsIgnoreCase(actualTitle))
		{
			System.out.println("Title of the page is: "+ actualTitle);
		}
		else {
			System.out.println("Title of the page is: "+ expectedTitle);
		}
		
	}
	
	@Given("user enter age {string} and height {string} and weight {string}")
	public void user_enter_age_and_height_and_weight(String age,String height, String weight) {
		WebElement age1=driver.findElement(By.name("cage")); 
		age1.clear();
		age1.sendKeys(age);
		WebElement height1=driver.findElement(By.name("cheightmeter"));
		height1.clear();
		height1.sendKeys(height); 
		WebElement weight1=driver.findElement(By.name("ckg"));
		weight1.clear();
		weight1.sendKeys(weight);
	}
	
			  
	  @When("calculate the calories") 
	  public void calculate_the_calories() {
	  driver.findElement(By.xpath("//input[@value='Calculate']")).click();
	  }
	  
	  @Then("capture the BMI Result value & Print it") 
	  public void capture_the_BMI_Result_value_Print_it() { 
	  String BMIvalue=driver.findElement(By.xpath("//div[@class='bigtext']/b")).getText();
	  String HealthyBMIRange = driver.findElement(By.xpath("//ul[@style='margin-left:8px;padding-left:8px;']/li[1]")).getText(); 
	  String HealthyWeight = driver.findElement(By.xpath("//ul[@style='margin-left:8px;padding-left:8px;']/li[2]")).getText(); 
	  String ponderalIndex = driver.findElement(By.xpath("//ul[@style='margin-left:8px;padding-left:8px;']/li[3]")).getText();
	  System.out.println("BMI Value is:"+BMIvalue);
	  System.out.println("Healthy BMI Range is:"+HealthyBMIRange);
	  System.out.println("Healthy Weight is:"+HealthyWeight);
	  System.out.println("Ponderal Index is:"+ponderalIndex); 
	  driver.close();
	  }
	  
	 



}
