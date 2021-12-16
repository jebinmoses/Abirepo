package org.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoClass extends BaseClass {
	
	public PojoClass() {
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//div[@class='clf acc_head']")
	//private WebElement headLogin;
	
	//@FindBy(xpath="(//a[@rel='nofollow'])[9]")
	//private WebElement signIn;
	
	@FindBy(id="email")
	private WebElement txtUser;
	
	@FindBy( id="pass")
	private WebElement txtPass;
	
   @FindBy(xpath=" //button[@name='login'] ")
   private WebElement btnLogin;

	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement txtForget;
	
	@FindBy(xpath="//input[@id='identify_email']")
	private WebElement txtMail;

	//public WebElement getHeadLogin() {
		//return headLogin;
	//}

//	//public WebElement getSignIn() {
//		return signIn;
//	}

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtForget() {
		return txtForget;
	}
	
	
	
	

}
