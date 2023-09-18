package vTiger.objectRepositery;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(name="user_name")
private WebElement usernameTextBox;

@FindBy(name="user_password")
private WebElement passwordTextbox;


@FindBy(id="submitButton")
private WebElement loginButton;


public LoginPage(WebDriver driver)
{

	PageFactory.initElements(driver, this);
}



public WebElement getUsernameTextBox() {
	return usernameTextBox;
}


public WebElement getPasswordTextbox() {
	return passwordTextbox;
}


public WebElement getLoginButton() {
	return loginButton;
}






}
