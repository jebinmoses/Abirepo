package org.StepDefinition;

import java.io.IOException;

import org.utility.BaseClass;
import org.utility.PojoClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class FBloginStepDefinition extends BaseClass {
	
	
	@Given("User should launch the browser browser and load the facebook.")
	public void user_should_launch_the_browser_browser_and_load_the_facebook() {
		launchChrome();
		loadUrl("https://www.facebook.com/");
		winMax();
	    
	}

	@When("User should type the username in the facebook page.")
	public void user_should_type_the_username_in_the_facebook_page() throws IOException {
		PojoClass p = new PojoClass();
		fill(p.getTxtUser(),getData(1, 0));
		
	    }

	@When("User should type the password in the facebook page.")
	public void user_should_type_the_password_in_the_facebook_page() throws IOException {
		PojoClass p = new PojoClass();
		fill(p.getTxtPass(),getData(2, 1));
	    
	}

	@When("User should click the login button.")
	public void user_should_click_the_login_button() throws InterruptedException {
		PojoClass p = new PojoClass();
		btnClick(p.getBtnLogin());
		Thread.sleep(1000);
	     
	}

	@Then("User should navigate to incorrect credential page.")
	public void user_should_navigate_to_incorrect_credential_page() {
                 System.out.println("passed");
		
		}


	

}
