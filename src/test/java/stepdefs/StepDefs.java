package stepdefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	
	WebDriver driver=BaseClass.driver;
	
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get("https://www.pizzahut.co.in/");
	}

	@When("I enter the location as {string}")
	public void i_enter_the_location_as(String location) {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement local = driver.findElement(By.xpath("//input[@type='text']"));
		local.sendKeys(location);
	    
	}

	@When("I select the very first suggestion from the list")
	public void i_select_the_very_first_suggestion_from_the_list() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement suggestion = driver.findElement(By.xpath("//*[contains(text(),'Pune Railway Station')]"));
	    suggestion.click();
	    
	}

	@Then("I should land on the Deals page")
	public void i_should_land_on_the_Deals_page() {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement page = driver.findElement(By.xpath("//a[contains(@class,'active')]/span[text()='Deals']"));
	    Assert.assertTrue(page.isDisplayed());
	}

	@Then("I select the tab as {string}")
	public void i_select_the_tab_as(String tabpage) {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement Pizzapage = driver.findElement(By.xpath("//a[contains(@class,'typography')]//span[text()='"+ tabpage +"']"));
		Pizzapage.click();
	    
	}

	@Then("I select the pizza as {string}")
	public void i_select_the_pizza_as(String selectpizza) {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement pizza = driver.findElement(By.xpath("//a[contains(@data-synth,'recommended')]//div[text()='"+ selectpizza +"']/following-sibling::div//span[text()='Add']"));
		pizza.click();
	    
	}

	@Then("I should see the pizza is added to the cart")
	public void i_should_see_the_pizza_is_added_to_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement cartpizza = driver.findElement(By.xpath("//div[text()='Personal Schezwan Margherita']"));
		Assert.assertTrue(cartpizza.isDisplayed());
	    
	}

	@Then("I click on the Checkout button")
	public void i_click_on_the_Checkout_button() {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement checkout = driver.findElement(By.xpath("//span[text()='Checkout']"));
		checkout.click();
	    
	}

	@Then("I should be landed on the secured checkout page")
	public void i_should_be_landed_on_the_secured_checkout_page() {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement checkout = driver.findElement(By.xpath("//span[text()='Secure Checkout']"));
		Assert.assertTrue(checkout.isDisplayed());
	    
	}

	@Then("I enter the personal details")
	public void i_enter_the_personal_details(Map<String,String> details) {
	    // Write code here that turns the phrase above into concrete actions
		
		for(String detail:details.keySet()) {
			
			String field = details.get(detail);
			WebElement personal = driver.findElement(By.xpath("//input[@name='"+ detail +"']"));
			personal.sendKeys(field);
			
		}
	    
	}

	@Then("I enter the address details")
	public void i_enter_the_address_details(List<String> address) {
	    // Write code here that turns the phrase above into concrete actions
		  WebElement Addlin1 = driver.findElement(By.xpath("//input[@placeholder='House Number or Name']"));
		  Addlin1.sendKeys(address.get(0));
		  WebElement Addlin2 = driver.findElement(By.xpath("//input[@placeholder='Landmark (Optional)']"));
		  Addlin2.sendKeys(address.get(1));
		  
	}

	@Then("I should see three payment options")
	public void i_should_see_three_payment_options(List<String> paymentops) {
	    // Write code here that turns the phrase above into concrete actions
		
		for(String payment:paymentops) {
			WebElement paymentmethod = driver.findElement(By.xpath("//span[contains(@class,'mr-auto')]/span[text()='"+ payment +"']"));
			Assert.assertTrue(paymentmethod.isDisplayed());
		}
	    
	}

	@Then("I select the payment option as {string}")
	public void i_select_the_payment_option_as(String option) {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement selectopt = driver.findElement(By.xpath("//span[text()='Cash']"));
		selectopt.click();
	   
	}


}
